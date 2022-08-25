package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/25
 * ### Modify: 简单
 * ### Description: 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * ```
 * ### 示例 2：
 * ```
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * ```
 * ### 示例 3：
 * ```
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * ```
 * ## 思路:
 * 这题最主要的是解读k的作用，k的意思是在找到两个相等的元素时，他们之间相差的元素不能大于k个
 * 于是我们就可以创建一个set集合，每次都将元素添加入内，并判断set长度是否大于k
 * 最后通过判断当前元素在set集合中是否存在来得出答案
 * ## 成绩:
 * - 执行用时：488ms, 在所有 Kotlin 提交中击败了83.33%的用户
 * - 内存消耗：57.5MB, 在所有 Kotlin 提交中击败了5.55%的用户
 *
 */
fun main() {
    println(Solution219().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
}

class Solution219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        // 题目中k的意思是在找到两个相等的元素时，他们之间相差的元素不能大于k个
        // 于是我们先创建一个set集合，用于存放相差的元素
        val set = hashSetOf<Int>()
        for (i in nums.indices) {
            // 若在set集合中出现了重复的元素，则就是找到了答案
            if (set.contains(nums[i])) {
                return true
            }
            // 每次遍历都将当前元素添入内
            set.add(nums[i])
            // 再判断set中的元素个数是否大于k个，若大于，则将最前面的元素删除
            if (set.size > k) {
                set.remove(nums[i - k])
            }
        }
        return false
    }
}