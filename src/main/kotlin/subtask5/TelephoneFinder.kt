package subtask5

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val intNumber = number.toInt()
        if (intNumber < 0) {
            return null
        }

        val outputArrayList = mutableListOf<String>()
        for (digit in number.indices) {
            val charDigit = number[digit]

            val neighborArray = neighborMap.getOrDefault(charDigit, arrayOf(charDigit.toInt()))
            for (char in neighborArray.indices) {
                val neighborNumber =
                    number.replaceRange(digit, digit + 1, neighborArray[char].toString())
                outputArrayList.add(neighborNumber)
            }
        }

        return outputArrayList.toTypedArray()
    }

    companion object {
        val neighborMap = hashMapOf(
            '0' to arrayOf(8),
            '1' to arrayOf(2, 4),
            '2' to arrayOf(1, 3, 5),
            '3' to arrayOf(2, 6),
            '4' to arrayOf(1, 5, 7),
            '5' to arrayOf(2, 4, 6, 8),
            '6' to arrayOf(3, 5, 9),
            '7' to arrayOf(4, 8),
            '8' to arrayOf(5, 7, 9, 0),
            '9' to arrayOf(6, 8)
        )
    }
}
