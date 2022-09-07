package com.mov.leetcode.array

import java.util.Collections.swap

/**
 * ### Author: fuxinbo
 * ### Date: 2022/9/7
 * ### Modify: 简单
 * ### Description: 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * ## 例子:
 * ### 示例 1:
 * ```
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * ```
 * ### 示例 2:
 * ```
 * 输入: nums = [0]
 * 输出: [0]
 * ```
 * ## 思路:
 * 双指针法，创建两个指针i和j
 * - i用于正常循环
 * - j用于记录当前操作非0的元素下标
 * 在循环中，如果当前元素不等于0，则将当前元素赋值给nums[j]
 * 就这样，将所有非0的元素移动至前头，那么后面剩余的空间自然都是0
 * ## 成绩:
 * - 执行用时：272ms, 在所有 Kotlin 提交中击败了87.37%的用户
 * - 内存消耗：36.6MB, 在所有 Kotlin 提交中击败了100.00%的用户
 *
 */
fun main() {
    Solution283().moveZeroes(intArrayOf(0,0,1)).forEach {
        print("${it} ")
    }
}


class Solution283 {
    fun moveZeroes(nums: IntArray): IntArray {
        var j = 0
        for (i in nums.indices){
            // 将非0的元素都移动至前头去
            if (nums[i] != 0){
                nums[j++] = nums[i]
            }
        }
        // 若记录的索引还有剩余，那么现在数组后头都为0
        while (j < nums.size){
            nums[j++] = 0
        }
        return nums
    }
}