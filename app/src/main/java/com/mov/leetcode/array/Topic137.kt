package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/10
 * ### Modify: 中等
 * ### Description: 137. 只出现一次的数字 II
 * 给你一个整数数组 nums.
 * 除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
 * 请你找出并返回那个只出现了一次的元素。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * ```
 * ### 示例 2：
 * ```
 *  输入：nums = [0,1,0,1,0,1,99]
 *  输出：99
 * ```
 * ## 思路:
 * - 与运算: and 相同为1,不同为0 00 and 01 = 10
 * - 异运算: xor 相同为0,不同为1 00 xor 01 = 01
 * - 按位取反: inv 将二进制上的每一位都进行取反 00.inv() = 11
 * 3次进行异或取反后将会得到0,若只进行一次,则会保留当前的数字
 * ## 成绩:
 * - 执行用时：192 ms, 在所有 Kotlin 提交中击败了42.86%的用户
 * - 内存消耗：35.2 MB, 在所有 Kotlin 提交中击败了28.57%的用户
 *
 */
fun main() {
    println(Solution137().singleNumber(intArrayOf(2,2,3,2)))
}

class Solution137 {

    // 2,2,2,3
    fun singleNumber(nums: IntArray): Int {
        var a = 0
        var b = 0
        for (x in nums) {
            b = b xor x and a.inv()
            a = a xor x and b.inv()
        }
        return b
    }
}
