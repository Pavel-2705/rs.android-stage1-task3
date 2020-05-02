package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val filteredIntArray = itemsFromArray.filterIsInstance<Int>().toMutableList()

        if (filteredIntArray.isEmpty()) return 0
        if (numberOfItems >= filteredIntArray.size) return filteredIntArray.reduce { acc, i -> acc*i }

        filteredIntArray.sortDescending()
        var product = 1
        if (numberOfItems % 2 == 1) {
            product *= filteredIntArray.first()
            filteredIntArray.removeAt(0)
        }
        for (i in 1..numberOfItems / 2) {
            val leftPair = filteredIntArray.first() * filteredIntArray[1]
            val rightPair =
                filteredIntArray[filteredIntArray.size - 1] * filteredIntArray[filteredIntArray.size - 2]
            if (leftPair >= rightPair) {
                product *= leftPair
                filteredIntArray.removeAt(1)
                filteredIntArray.removeAt(0)
            } else {
                product *= rightPair
                filteredIntArray.removeAt(filteredIntArray.size - 2)
                filteredIntArray.removeAt(filteredIntArray.size - 1)
            }
        }
        return product
    }
}
