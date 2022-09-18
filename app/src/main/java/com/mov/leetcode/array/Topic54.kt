package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/9/14
 * ### Modify: 中等
 * ### Description: 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * ```
 * ### 示例 2：
 * ```
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * ```
 * ## 思路:
 * 就纯纯的模拟法，没啥好说的，一条边一条边的模拟
 * ## 成绩:
 * - 执行用时：140ms, 在所有 Kotlin 提交中击败了90.74%的用户
 * - 内存消耗：33.2MB, 在所有 Kotlin 提交中击败了33.33%的用户
 *
 */
fun main() {
    Solution54().spiralOrder(
        arrayOf(
            intArrayOf(7),
            intArrayOf(9),
            intArrayOf(6)
        )
    ).forEach {
        print("${it},")
    }
}

class Solution54 {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = arrayListOf<Int>()
        var x = 0
        var y = matrix[0].size - 1
        var t = 0
        var b = matrix.size - 1
        var index = 0
        val n = (matrix.size * matrix[0].size)
        if (matrix.isEmpty()) return arrayListOf()
        while (true) {
            // 模拟上边
            for (i in x..y) {
                result.add(matrix[t][i])
                index++
            }
            if (index == n) return result
            t++
            // 模拟右边
            for (i in t..b) {
                result.add(matrix[i][y])
                index++
            }
            if (index == n) return result
            y--
            // 模拟下边
            for (i in y downTo x) {
                result.add(matrix[b][i])
                index++
            }
            if (index == n) return result
            b--
            // 模拟左边
            for (i in b downTo t) {
                result.add(matrix[i][x])
                index++
            }
            if (index == n) return result
            x++
        }
    }
}