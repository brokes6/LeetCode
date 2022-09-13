package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/9/13
 * ### Modify: 中等
 * ### Description: 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 1,2,3         7,4,1
 * 4,5,6(1,2) -> 8,5,2
 * 7,8,9         9,6,3
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * ```
 * ### 示例 2：
 * ```
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * ```
 * ## 思路:
 * 最简单的方法就是
 * - 先进行上下反转
 * - 在进行对角反转
 * 就成了..就这样，没啥别的(但是要发现这个规律还是需要一定时间的)
 * ## 成绩:
 * - 执行用时：168ms, 在所有 Kotlin 提交中击败了72.41%的用户
 * - 内存消耗：34.6MB, 在所有 Kotlin 提交中击败了37.93%的用户
 *
 */
fun main() {
    Solution48().rotate(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    ).forEach {
        println()
        it.forEach { data ->
            print("${data},")
        }
    }
}

class Solution48 {
    fun rotate(matrix: Array<IntArray>): Array<IntArray> {
        // 上下反转
        // 进行上下交换
        for (i in 0 until matrix.size / 2) {
            for (j in 0 until matrix[i].size) {
                val tmp = matrix[i][j]
                matrix[i][j] = matrix[matrix.size - 1 - i][j]
                matrix[matrix.size - 1 - i][j] = tmp
            }
        }
        // 对角反转
        for (i in 0..matrix.size) {
            for (j in i + 1 until matrix.size) {
                // 进行对角交换
                val tmp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = tmp
            }
        }
        return matrix
    }
}