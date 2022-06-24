package com.mov.leetcode.palindromic_number

/**
 * ### Author: 付鑫博
 * ### Date: 2022/6/24
 * ### Modify: 简单
 * ### Description:13. 罗马数字转整数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * - 例如，121 是回文，而 123 不是。

 * ## 例子:
 * ### 示例 1：
 * 输入：x = 121
 * 输出：true
 * ### 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * ### 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * ## 思路:
 * 先来个简单做法来康复训练一下,首先将int转为String类型,再创建两个指针（x,y）
 * - x用于从头开始
 * - y用于从尾部开始

 * 建立一个while循环(x<y),判断x指向的元素是否与y指向的元素相等
 * - 相等就继续
 * - 不相等就直接返回false，表示不是回文
 * ## 成绩:
 * - 执行用时：232 ms, 在所有 Kotlin 提交中击败了34.10%的用户
 * - 内存消耗：34.6 MB, 在所有 Kotlin 提交中击败了41.01%的用户
 *
 */
fun main() {
    print(Solution().isPalindrome(1231))
}

class Solution {
    fun isPalindrome(x: Int): Boolean {
        // 先转换为String,方便查看每一个元素
        val data = x.toString()
        // 再创建两个指针
        var x = 0
        var y = data.length - 1
        // 进行循环判断...(确实有点捞)
        while (x < y) {
            if (data[x] == data[y]) {
                x++
                y--
            } else {
                // 若对应元素不相等,则直接返回false
                return false
            }
        }
        return true
    }
}