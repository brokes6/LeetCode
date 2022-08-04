package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/4
 * ### Modify: 中等
 * ### Description: 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。
 * 返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * ```
 * ### 示例 2：
 * ```
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * ```
 * ## 思路:
 * 由于题目中明确说明不会有重复的元素,那么我们就只需要在每次进行下一轮循环时
 * 吧当前的元素添加进前面每一个List中,然后再将这个List存入答案中即可
 * /ps:由于子集中肯定包括一个null和一个本身,所以这两个元素我们可以在一开始就直接给他添加进去(这样的话,外层循环要从1开始)
 * ## 成绩:
 * - 执行用时：184 ms, 在所有 Kotlin 提交中击败了65.12%的用户
 * - 内存消耗：35.8 MB, 在所有 Kotlin 提交中击败了51.16%的用户
 *
 */


class Solution78 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>(mutableListOf())
        if (nums.isEmpty()) return result
        result.add(mutableListOf(nums[0]))
        if (nums.size == 1) return result
        for (i in 1 until nums.size) {
            val size = result.size
            // 给前面全部的元素都添加上当前元素
            for (j in 0 until size) {
                val cur = ArrayList(result[j])
                cur.add(nums[i])
                result.add(cur)
            }
        }
        return result
    }
}