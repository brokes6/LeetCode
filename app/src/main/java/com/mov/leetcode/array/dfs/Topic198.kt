package com.mov.leetcode.array.dfs

import kotlin.math.max

/**
 * ### Author: fuxinbo
 * ### Date: 2022/6/24
 * ### Modify: 中等
 * ### Description: 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * ```
 * ### 示例 2：
 * ```
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * ```
 * ## 思路:
 * 首先找到转移方程，将问题转换成另一个小问题
 *
 * 我们先来将nums定为3个数[1,2,3]
 * 1.先偷1，3 盈利 4
 * 2.偷2 盈利 2
 * 于是乎就找到了公式
 * ```
 * dp[x] = max(dp[x - 1],dp[x - 2] + nums[x - 1])(这里的nums - 1，是因为索引是从0开始)
 * ```
 * 接下来就是进行循环计算出每个dp的结果，然后提交最后一个
 * ### 注意
 * 但个数为0和1个时
 * - 0个当然就没有盈利可言，所以dp[0] = 0
 * - 1个的时候当然就是本身,dp[1] = nums[0]
 * 所以循环从第二个开始
 * ## 成绩:
 * - 执行用时：168ms, 在所有 Kotlin 提交中击败了25.76%的用户
 * - 内存消耗：32.5MB, 在所有 Kotlin 提交中击败了32.5%的用户
 *
 */

fun main() {
    println(Solution198().rob(intArrayOf(2, 7, 9, 3, 1)))
}

class Solution198 {
    fun rob(nums: IntArray): Int {
        val dp = IntArray(nums.size + 1) { 0 }
        dp[0] = 0
        dp[1] = nums[0]
        for (i in 2..nums.size) {
            dp[i] = max(dp[i - 1], nums[i - 1] + dp[i - 2])
        }
        return dp[nums.size]
    }
}