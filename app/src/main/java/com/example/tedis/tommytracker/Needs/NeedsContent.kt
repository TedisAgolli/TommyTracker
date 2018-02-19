package com.example.tedis.tommytracker.Needs

import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object NeedsContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<NeedsItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, NeedsItem> = HashMap()

    private val COUNT = 3

    /*init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createNeedsItem(i))
        }
    }*/

    private fun addItem(item: NeedsItem) {
        ITEMS.add(item)
    }

    private fun createNeedsItem(position: Int): NeedsItem {
        return NeedsItem(1, "Item " + position, "TEST")
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    class NeedsItem(val needType:Int, val sTime: String, val extraInfo: String) {

        override fun toString(): String {
            return sTime
        }
    }
}
