package com.mov.leetcode.array


/**
 * ### Author: fuxinbo
 * ### Date: 2022/9/5
 * ### Modify: 中等
 * ### Description: 36. 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 1. 数字 1-9 在每一行只能出现一次。
 * 2. 数字 1-9 在每一列只能出现一次。
 * 3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 * 注意:
 * - 一个有效的数独（部分已被填充）不一定是可解的。
 * - 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * - 空白格用 '.' 表示。
 * ## 例子:
 * 例子建议前往力扣官网查看：https://leetcode.cn/problems/valid-sudoku/
 * ## 思路:
 * 这道题可以先创建3个数组，用来判断是否有重复数字：
 * - 横向
 * - 纵向
 * - 3*3的矩形
 *
 * 然后进行双重循环，遍历每一个元素，
 * 1. 判断当前位置上的元素是否为空，为空则跳过
 * 2. 判断当前位置上的元素记录值是否大于1，大于1则表示有重复数字
 * 3. 我们先将题目给定的chat转换成int
 * 4. 每次遍历，都将当前位置上的元素记录+1
 * ## 成绩:
 * - 执行用时：228ms, 在所有 Kotlin 提交中击败了24.39%的用户
 * - 内存消耗：40MB, 在所有 Kotlin 提交中击败了70.73%的用户
 *
 */

class Solution36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val row = Array(9) { IntArray(9) }
        val col = Array(9) { IntArray(9) }
        val box = Array(3) {
            Array(3) {
                IntArray(9)
            }
        }
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (board[i][j] == '.') {
                    continue
                }
                // 由于题目给定的类型为chat，所以我们需要转换成int
                val current = board[i][j] - '0' - 1
                // 若当前对应的数组上的值大于1，则表示为有重复数字
                if (row[i][current] >= 1 || col[j][current] >= 1 || box[i / 3][j / 3][current] >= 1) return false
                // 若当前位置上的字符不为空，则在对应数组上+1
                row[i][current]++
                col[j][current]++
                // 这里除以3是因为 每个小矩形都是3 * 3的，所以在一排中只会有3个矩形出现。
                // 于是就通过当前的索引 / 3 来计算出矩形中的位置
                box[i / 3][j / 3][current]++
            }
        }
        return true
    }
}