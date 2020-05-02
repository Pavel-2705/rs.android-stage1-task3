package subtask1

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        return if (numbers.isEmpty()) null else {
            val outString = StringBuilder()
            outString.append(numbers[0])
            addDegreeToStringBuilder(numbers.size - 1, outString)
            for (index in 1 until numbers.size) {
                val degree = numbers.size - index - 1
                var number = numbers[index]
                if (number != 0) {
                    if (number < 0) {
                        outString.append(" - ")
                        number *= -1
                    } else if (number > 0) {
                        outString.append(" + ")
                    }
                    if (number != 1) outString.append(number)
                    addDegreeToStringBuilder(degree, outString)
                }
            }
            outString.toString()
        }
    }
}

fun addDegreeToStringBuilder(degree: Int, stringBuilder: java.lang.StringBuilder) {
    when (degree) {
        0 -> stringBuilder.append("")
        1 -> stringBuilder.append("x")
        else -> stringBuilder.append("x^${degree}")
    }
}

