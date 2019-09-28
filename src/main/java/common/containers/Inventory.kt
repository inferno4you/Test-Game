package common.containers

class Inventory : IInventory {
    private var slots: Array<ISlot>? = null

    constructor() {
        slots = arrayOfNulls(10)
    }

    constructor(size: Int) {
        slots = arrayOfNulls(size)
    }

    override fun getSlot(slot: Int): ISlot? {
        return if (slots!!.size < slot || slot < 0) null else slots!![slot]
    }

    override fun setSlot(slot: ISlot) {
        // TODO: Add a way to check if slot has the item or if no slot has item go to first air item found.
    }
}
