package com.mov.leetcode.binary_search

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/8
 * ### Modify: 简单
 * ### Description: 704. 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * ## 例子:
 * ### 示例 1:
 * ```
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * ```
 * ### 示例 2:
 * ```
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * ```
 * ## 思路:
 * 经典二分查找,没啥好说的。但是需要注意区间,我使用的是左闭右开区间。
 * ```
 * 因此y = nums.size(不需要-1)
 * y = mid(不需要+1)
 * ```
 * ## 成绩:
 * - 执行用时：312 ms, 在所有 Kotlin 提交中击败了5.00%的用户(^^)
 * - 内存消耗：36.6 MB, 在所有 Kotlin 提交中击败了93.00%的用户
 *
 */

fun main() {
    print(Solution704().search(intArrayOf(-1,0,3,5,9,12),12))
}

class Solution704 {
    fun search(nums: IntArray, target: Int): Int {
        var x = 0
        var y = nums.size
        while (x < y){
            val mid = x + (y - x) / 2
            when {
                nums[mid] < target -> {
                    x = mid + 1
                }
                nums[mid] > target -> {
                    y = mid
                }
                else -> {
                    return mid
                }
            }
        }
        return -1
    }
}