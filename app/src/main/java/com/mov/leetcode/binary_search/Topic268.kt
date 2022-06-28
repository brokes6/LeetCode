package com.mov.leetcode.binary_search

/**
 * ### Author: 付鑫博
 * ### Date: 2022/6/24
 * ### Modify: 简单
 * ### Description:268. 丢失的数字(https://leetcode.cn/problems/missing-number/)
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * ## 例子:
 * ### 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * ### 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * ### 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * ## 思路:
 * 先将数组进行排序,然后由题目可知,数组有多长那么就会有多少个数字,于是我们就可以在排序完之后进行for循环
 * - 每次都判断当前数组中的元素是否与他的下标对得上.若无法对得上,则表示这个数字是缺失的
 * ## 成绩:
 * - 执行用时：232 ms, 在所有 Kotlin 提交中击败了44.44%的用户
 * - 内存消耗：37.8 MB, 在所有 Kotlin 提交中击败了38.89%的用户
 *
 */
fun main() {
    print(Solution().missingNumber(intArrayOf(3,0,1)))
}

class Solution {
    // nums = [3,0,1] --> [0,1,3] is not 2 in nums
    fun missingNumber(nums: IntArray): Int {
        nums.sort()
        nums.forEachIndexed { index, i ->
            if (nums[index] != index){
                return index
            }
        }
        return nums.size
    }
}