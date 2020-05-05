package subtask6

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        val tree = createBinaryTree(count)
        val result = mutableListOf<List<Int?>>()
        for (node in tree) {
            val list = getTreeAsList(node).toMutableList()
            while (list[list.size - 1] == null) {
                list.removeAt(list.size - 1)
            }
            result.add(list)
        }
        print(result.toString())
        return result.toString()
    }

    private fun createBinaryTree(count: Int): List<Node> {
        val resultList = mutableListOf<Node>()
        if (count % 2 == 0) return resultList
        if (count == 1) {
            resultList.add(Node(depth = 0))
            return resultList
        }
        for (value in 1 until count step 2) {
            val rightChild = createBinaryTree(value)
            val leftChild = createBinaryTree(count - 1 - value)
            for (right in rightChild) {
                for (left in leftChild) {
                    val currentDeath = maxOf(right.depth, left.depth) + 1
                    resultList.add(Node(depth = currentDeath, rightChild = right, leftChild = left))
                }
            }
        }
        return resultList
    }

    private fun getTreeAsList(node: Node): List<Int?> {
        val result = mutableListOf<Int?>()
        var currentLevel = 0
        var child = mutableListOf<Node?>(
            node.rightChild, node.leftChild
        )
        result.add(0)

        while (child.isNotEmpty()) {
            val newChild = mutableListOf<Node?>()
            for (i in child) {
                if (i == null) {
                    if (currentLevel != node.depth)
                        result.add(null)
                } else {
                    result.add(0)
                    newChild.add(i.rightChild)
                    newChild.add(i.leftChild)
                }
            }
            child = mutableListOf()
            child.addAll(newChild)
            currentLevel++
        }
        return result
    }

    inner class Node(
        var depth: Int,
        var rightChild: Node? = null,
        var leftChild: Node? = null

    )
}
