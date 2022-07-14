package com.mov.leetcode.binary_search

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/14
 * ### Modify: 中等
 * ### Description: 33. 搜索旋转排序数组
 * * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * ### 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * ```
 * ### 示例 2：
 * ```
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * ```
 * ### 示例 3：
 * ```
 * 输入：nums = [1], target = 0
 * 输出：-1
 * ```
 * ## 思路:
 * 原先的数组是一个升序数组,但是在经过某个点之后进行了旋转,所以就不会还是一个有序数组了,但是这样就相当于分成了两个数组.
 * 其中一个必然是有序数组.因此我们可以判断target在那一段里面,从而进行二分查找
 * ## 成绩:
 * - 执行用时：204ms, 在所有 Kotlin 提交中击败了12.10%的用户
 * - 内存消耗：34.5MB, 在所有 Kotlin 提交中击败了81.45%的用户
 *
 */

fun main() {
    print(Solution33().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 6))
}

class Solution33 {
    // 4,5,6,7,0,1,2   5
    fun search(nums: IntArray, target: Int): Int {
        var x = 0
        var y = nums.size - 1
        while (x <= y) {
            val mid = x + (y - x) / 2
            if (target == nums[mid]) return mid
            // 先查找旋转点,若第一位数小于等于当前中间值,那么就可以判断为前面是有序的,因此可以进一步判断target是否在前面数组中
            if (nums[0] <= nums[mid]) {
                // 判断target在前半段,还是在后半段
                if (target >= nums[0] && target < nums[mid]) {
                    y = mid - 1
                } else {
                    x = mid + 1
                }
            } else {
                if (target <= nums[nums.size - 1] && target > nums[mid]) {
                    x = mid + 1
                }else{
                    y = mid - 1
                }
            }
        }
        return -1
    }
}