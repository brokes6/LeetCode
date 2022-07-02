package com.mov.leetcode.binary_search

/**
 * ### Author: 付鑫博
 * ### Date: 2022/6/29
 * ### Modify: 简单
 * ### Description: 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。

 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * ## 例子:
 * ### 示例 1：
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 * ### 示例 2：
 * 输入：numbers = [2,2,2,0,1]
 * 输出：0
 * ## 思路:
 *
 * ## 成绩:
 * - 执行用时： ms, 在所有 Kotlin 提交中击败了%的用户
 * - 内存消耗： MB, 在所有 Kotlin 提交中击败了%的用户
 *
 */

class Solution_Offer_11 {
    fun minArray(numbers: IntArray): Int {
        var x = 0
        var y = numbers.size - 1
        while (x < y) {
            val mid = (y - x) / 2
            when {
                // 第一种情况,当前数如果小于最后一位数,那么表示着从mid到y之间的数都比mid要大
                // (这里是由于numbers之前是一个升序数组,就算进行了旋转,但仍然会有两部分依旧是升序的)
                numbers[mid] < numbers[y] -> {
                    // 就可以直接忽略后面的数字
                    y = mid
                }
                // 第二种情况,当前数如果大于最后一位数字,那么表示着左边的数字都是小鱼
                numbers[mid] > numbers[y] -> {
                    x = mid + 1
                }
                else -> {
                    y -= 1
                }
            }
        }
        return numbers[x]
    }
}