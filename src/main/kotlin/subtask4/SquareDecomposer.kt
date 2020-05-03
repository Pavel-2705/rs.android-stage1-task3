package subtask4

class SquareDecomposer {
    fun decomposeNumber(number: Int): Array<Int>? {
        val numberLong = number.toLong()
        val resultList = decompose(numberLong, numberLong * numberLong)

        return if (resultList != null) {
            resultList.removeAt(resultList.size - 1)
            resultList.toTypedArray()
        } else {
            null
        }
    }

    private fun decompose(value: Long, remain: Long): MutableList<Int>? {
        if (remain == 0L) return mutableListOf(value.toInt())

        for (i in (value - 1) downTo 1) {
            val newRemain = remain - i * i
            if (newRemain >= 0) {
                val result = decompose(i, newRemain)
                if (result != null) {
                    result.add(value.toInt())
                    return result
                }
            }
        }
        return null
    }
}