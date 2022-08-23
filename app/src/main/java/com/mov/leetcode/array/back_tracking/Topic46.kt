package com.mov.leetcode.array.back_tracking

import java.util.*

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/5
 * ### Modify: 中等
 * ### Description: 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。
 * 你可以 按任意顺序 返回答案。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * ```
 * ### 示例 2：
 * ```
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * ```
 * ### 示例 3：
 * ```
 * 输入：nums = [1]
 * 输出：[[1]]
 * ```
 * ## 思路:
 * 可以使用回溯算法,简单来说就是,每次循环都替换一下指定元素的位置,然后再判断是否还有替换的可能
 * 而在循环结束时,又将被替换位置的元素重新替换回去
 * 不太懂.....
 *
 * ## 成绩:
 * - 执行用时：224 ms, 在所有 Kotlin 提交中击败了39.67%的用户
 * - 内存消耗：37.8 MB, 在所有 Kotlin 提交中击败了29.76%的用户
 *
 */
fun main() {
    Solution46().permute(intArrayOf(1, 2, 3)).forEach { it ->
        println("")
        it.forEach { data ->
            print("${data},")
        }
    }
}


class Solution46 {

    // 1,2,3
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val out = nums.toMutableList()
        backtrack(nums.size, result, out, 0)
        return result
    }

    private fun backtrack(
        size: Int,
        result: MutableList<MutableList<Int>>,
        out: MutableList<Int>,
        first: Int
    ) {
        if (first == size) {
            result.add(ArrayList(out))
        }
        for (i in first until size) {
            Collections.swap(out, first, i)
            backtrack(size, result, out, first + 1)
            Collections.swap(out, first, i)
        }
    }
}