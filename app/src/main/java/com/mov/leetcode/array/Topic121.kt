package com.mov.leetcode.array

import kotlin.math.min
import kotlin.math.max

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/23
 * ### Modify: 简单
 * ### Description: 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * ```
 * ### 示例 2：
 * ```
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * ```
 * ## 思路:
 * 利益=当前股票价格-记录中最小的价格
 * 所以我们每次循环都只用更新这两个值即可
 * - 最大利益则通过上述公式来进行判断
 * - 最小价格则直接比较大小即可
 * ## 成绩:
 * - 执行用时644 ms, 在所有 Kotlin 提交中击败了10.23%的用户
 * - 内存消耗55.9 MB, 在所有 Kotlin 提交中击败了47.73%的用户
 *
 */
fun main() {
    println(Solution121().maxProfit(intArrayOf(7,1,5,3,6,4)))
}

class Solution121 {

    // 7,6,4,3,1
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) return 0
        var min = prices[0]
        var max = 0
        // 从第二个开始判断
        for (i in 1 until prices.size){
            // 最大的利益则通过每次循环，判断当前数字减去最小点的值和当前最大进行比较
            max = max(max,prices[i] - min)
            // 最小点就直接寻找最小的数即可
            min = min(min,prices[i])
        }
        return max
    }
}