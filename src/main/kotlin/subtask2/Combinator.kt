package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0]
        val n = array[1]

        for (k in 0..n) {
            if (m * getFactorial(k) * getFactorial(n - k) == getFactorial(n))
                return k
        }
        return null
    }

    private fun getFactorial(n: Int): Int {
        if ((n == 0) or (n == 1)) return 1
        var factorial = 1
        for (i in 1..n) {
            factorial *= i
        }
        return factorial
    }
}