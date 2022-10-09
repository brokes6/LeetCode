package com.mov.leetcode.array.dfs

import kotlin.math.min

/**
 * ### Author: fuxinbo
 * ### Date: 2022/10/9
 * ### Modify: 中等
 * ### Description: 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 * ```
 * ### 示例 2：
 * ```
 * 输入：triangle = [[-10]]
 * 输出：-10
 * ```
 * ## 思路:
 * 首先我们可以从题目中看出一个公式：
 * f[i][j] = min([ i - 1 ][j],[i - 1][j + 1]) + target[i][j]
 * 也就是指定元素距离底边的距离为 下一个元素或者下一个元素的后一个元素取最小值，再加上当前元素
 * 那么公式就构建出来了，那么就可以进行如下操作
 * 1. 创建一个名为dp的数组，数组大小为给定list长度+1(这是因为我们是从最后一排开始的，
 * 那么最后一排中的每个元素都需要根据公式去加上下一排中元素的值，那么就需要这么一排为0的元素)
 * 2. 从下至上进行外循环，内循环为每一排中的元素
 * 3. 每次都进行如下操作
 * ```
 * dp[i][j] = min(dp[i + 1][j + 1], dp[i + 1][j]) + triangle[i][j]
 * ```
 * ## 成绩:
 * - 执行用时：168ms, 在所有 Kotlin 提交中击败了86.67%的用户
 * - 内存消耗：39.3MB, 在所有 Kotlin 提交中击败了60.00%的用户
 *
 */

fun main() {
    println(
        Solution120().minimumTotal(
            mutableListOf(
                listOf(-1), listOf(2, 3), listOf(1, -1, -3)
            )
        )
    )
}

class Solution120 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val n = triangle.size
        val dp = Array(n + 1) { IntArray(n + 1) }
        // 由于是个三角形，那么高就是底边的长度，所以这里减1，底边进行循环的时候也不需要担心范围超出
        for (i in n - 1 downTo 0) {
            for (j in 0..i) {
                // 将这一排的数全都计算一边
                // 有题目可知，每次元素只能向下或者向下并向后移动，那么我们从下向上也是同理
                // dp[i][j]代表着当前<i,j>位置到底边的距离(是从<i+1,j>和<i+1,j+1>中取最小数得来的)
                dp[i][j] = min(dp[i + 1][j + 1], dp[i + 1][j]) + triangle[i][j]
            }
        }
        return dp[0][0]
    }
}