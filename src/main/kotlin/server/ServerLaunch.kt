package server

import bvanseg.talaria.server.ServerProperties
import common.Game
import bvanseg.talaria.server.TalariaServerManager
import java.awt.ScrollPane
import java.awt.TextArea
import javax.swing.JFrame
import javax.swing.WindowConstants
import java.io.PrintStream
import java.io.IOException
import java.io.ByteArrayOutputStream



object ServerLaunch {
    var lastLoopTime = System.nanoTime()
    var currentTime: Long = 0
    var deltaTime: Double = 0.0

    var frame: JFrame = JFrame()
    var textBox : ScrollPane = ScrollPane()
    var textArea : TextArea = TextArea();


    @JvmStatic
    fun main(args: Array<String>) {
        launchServer(false)
    }

    fun launchServer(noGUI : Boolean) {
        if (!noGUI) {
            val bytes = object : ByteArrayOutputStream() {
                @Synchronized
                @Throws(IOException::class)
                override fun flush() {
                    textArea.setText(toString())
                }
            }

            val out = PrintStream(bytes, true)

            System.setErr(out)
            System.setOut(out)

            textBox.add(textArea)
            frame.add(textBox)
            frame.isVisible = true
            frame.title = "Iodine server"
            frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        }


        val serverManager = TalariaServerManager(ServerProperties())

        ServerGame.instance = ServerGame()

        serverManager.entityHandler.registerEntity(ServerWorld::class.java)

        serverManager.whileRunning = {
            currentTime = System.nanoTime()
            deltaTime += (currentTime - lastLoopTime) / Game.OPTIMAL_TIME
            lastLoopTime = currentTime

            while (deltaTime >= 1) {
                ServerGame.instance.update()
                deltaTime--
            }
        }

        serverManager.start()
    }
}