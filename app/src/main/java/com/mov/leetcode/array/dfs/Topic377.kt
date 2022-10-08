package com.mov.leetcode.array.dfs

/**
 * ### Author: fuxinbo
 * ### Date: 2022/6/24
 * ### Modify: 中等
 * ### Description: 377. 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * ```
 * ### 示例 2：
 * ```
 * 输入：nums = [9], target = 3
 * 输出：0
 * ```
 * ## 思路:
 * 根据题目可得，属于完全背包求组合类型，于是我们先遍历背包容量，再正序遍历物品
 * ### 例如：
 * 容量为4，物品为【1，3】则 dp[4] = dp[4] + dp[3] + dp[1]
 * ### 还有一种说法是状态转移
 * 假设有1，2来拼凑4的组合个数为y
 * - 那么我们将组合中以1结尾的单独拿出来，个数为x1
 * - 组合中以2结尾的个数为x2
 *
 * 也就是
 * ## 成绩:
 * - 执行用时：132ms, 在所有 Kotlin 提交中击败了100.00%的用户
 * - 内存消耗：32.6MB, 在所有 Kotlin 提交中击败了66.67%的用户
 *
 */

fun main() {
    println(Solution377().combinationSum4(intArrayOf(1, 2, 3), 4))
}

class Solution377 {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1)
        // 这是当没有选中任何元素时当解
        dp[0] = 1
        for (i in 1..target) {
                for (j in nums){
                if (i >= j) {
                    dp[i] += dp[i - j]
                }
            }
        }
        return dp[target]
    }
}

