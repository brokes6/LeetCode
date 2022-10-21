package com.mov.leetcode.array.dfs

/**
 * ### Author: fuxinbo
 * ### Date: 2022/6/24
 * ### Modify: 简单
 * ### Description: 509. 斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * ```
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * ```
 * 给定 n ，请计算 F(n) 。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * ```
 * ### 示例 2：
 * ```
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * ```
 * ### 示例 3：
 * ```
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * ```
 * ## 思路:
 * 没啥思路，能说的都写在注释里
 * ## 成绩:
 * ### 方法1
 * - 执行用时：124ms, 在所有 Kotlin 提交中击败了75.56%的用户
 * - 内存消耗：31.8MB, 在所有 Kotlin 提交中击败了77.78%的用户
 * ### 方法2
 * - 执行用时：ms, 在所有 Kotlin 提交中击败了%的用户
 * - 内存消耗：MB, 在所有 Kotlin 提交中击败了%的用户
 *
 */

fun main() {
    println(Solution509_1().fib(0))
}

/**
 * 解法1 循环计算每一项都值，然后保存起来，方便后续使用
 *
 * @constructor Create empty Solution509
 */
class Solution509_1 {
    fun fib(n: Int): Int {
        val dp = IntArray(n + 2)
        dp[0] = 0
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[n]
    }
}

/**
 * 解法2 计算出通用公式
 *
 * @constructor Create empty Solution509_2
 */
class Solution509_2 {
    // todo
    fun fib(n: Int): Int {
        return 0
    }
}