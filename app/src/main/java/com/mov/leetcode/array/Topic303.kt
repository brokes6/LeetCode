package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/9/6
 * ### Modify: 简单
 * ### Description: 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * 1. 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 *
 * 实现 NumArray 类：
 * - NumArray(int[] nums) 使用数组 nums 初始化对象
 * - int sumRange(int i, int j) 返回数组 nums中索引left和right之间的元素的 总和 ，
 * 包含left和right两点（也就是nums[left] + nums[left + 1] + ... + nums[right])
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * ```
 * ## 思路:
 * 首先 题目的意思是给定一个数组，然后无限次数的调用sumRange方法，
 * sumRange方法则是获取给定两个索引之前的元素和
 * 为了使后续的无限次调用效率最大化，达到o(1)
 * 所以我们在一开始时，将所有可能的结果都计算出来，（每个元素都是之前元素都和）保存在数组中
 * 在进行求和的时候，就可以通过大的元素减去小的元素来得到他们之前重叠的部分，也就是答案
 * ## 成绩:
 * - 执行用时：252ms, 在所有 Kotlin 提交中击败了65.00%的用户
 * - 内存消耗：42MB, 在所有 Kotlin 提交中击败了50.00%的用户
 *
 */

class NumArray303(nums: IntArray) {

    private val sums : IntArray = IntArray(nums.size + 1)

    init {
        // 由于题目的意思是sumRange会无限次调用，所以我们可以在一开始就将所有结果一次性全部计算出来
        for (i in nums.indices){
            sums[i + 1] = sums[i] + nums[i]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        // 这里相减是因为 sums中存储的每一个元素都是之前元素之和
        // 那么由于right肯定比left大，所以sums[right]之中就包括了sums[left]之和
        // 那么我们就可以让大的减去小的，就可以得到之中重叠的部分，也就是答案
        return sums[right + 1] - sums[left]
    }

}