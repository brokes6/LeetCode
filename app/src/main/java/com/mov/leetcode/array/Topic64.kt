package com.mov.leetcode.array

import kotlin.math.min

/**
 * ### Author: fuxinbo
 * ### Date: 2022/9/19
 * ### Modify: 中等
 * ### Description: 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * ```
 * ### 示例 2：
 * ```
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * ```
 * ## 思路:
 * 采取动态规划
 * 我们首先创建一个和题目相同大小的表，这个表的主要目的就是记录到每个元素所需的步数
 * - 先计算第一排竖着的元素所需的步数
 * - 再计算第一排横着的元素所需的步数
 * - 最后再进行双重循环，然后从(当前元素 + 当前元素垂直上一个元素)(当前元素 + 当前横向方向前一个元素)来取最小值
 *
 * 这样就计算完了全部到达全部元素所需的步数，最终答案返回最后一个元素即可
 * ## 成绩:
 * - 执行用时：188ms, 在所有 Kotlin 提交中击败了57.58%的用户
 * - 内存消耗：36.9MB, 在所有 Kotlin 提交中击败了90.91%的用户
 *
 */

fun main() {
    print(Solution64().minPathSum(arrayOf(intArrayOf(1,3,1), intArrayOf(1,5,1), intArrayOf(4,2,1))))
}

class Solution64 {
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }
        val rows = grid.size
        val columns = grid[0].size
        val dp = Array(rows) { IntArray(columns) }
        // 计算第一排竖着到达每个元素所需的步数
        dp[0][0] = grid[0][0]
        for (i in 1 until rows){
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        }
        // 再计算第一排横着达每个元素所需的步数
        for (i in 1 until columns){
            dp[0][i] = dp[0][i - 1] + grid[0][i]
        }
        // 最后再计算到达剩余元素所需的步数，然后从(当前元素 + 当前元素垂直上一个元素)(当前元素 + 当前横向方向前一个元素)来取最小值
        for (i in 1 until rows){
            for (j in 1 until columns){
                dp[i][j] = min(dp[i][j - 1] + grid[i][j],dp[i - 1][j] + grid[i][j])
            }
        }
        // 最后返回最后一个元素即可
        return dp[rows - 1][columns - 1]
    }
}