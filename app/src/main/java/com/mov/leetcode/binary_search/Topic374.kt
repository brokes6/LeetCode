package com.mov.leetcode.binary_search

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/5
 * ### Modify: 简单
 * ### Description: 374. 猜数字大小
 * 猜数字游戏的规则如下：
 * - 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * - 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * ### 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * - -1：我选出的数字比你猜的数字小 pick < num
 * - 1：我选出的数字比你猜的数字大 pick > num
 * - 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：n = 10, pick = 6
 * 输出：6
 * ```
 * ### 示例 2：
 * ```
 * 输入：n = 1, pick = 1
 * 输出：1
 * ```
 * ### 示例 3：
 * ```
 * 输入：n = 2, pick = 1
 * 输出：1
 * ```
 * ### 示例 4：
 * ```
 * 输入：n = 2, pick = 2
 * 输出：2
 * ```
 * ## 思路:
 * 典型的二分查找,没啥好说的
 * 就是要注意一下栈溢出问题
 * - mid = (x + y) /2 <-- x + y会溢出
 * ## 成绩:
 * - 执行用时：132 ms, 在所有 Kotlin 提交中击败了28.57%的用户
 * - 内存消耗：32.1MB, 在所有 Kotlin 提交中击败了33.33%的用户
 *
 */
class Solution374 : GuessGame() {
    override fun guessNumber(n: Int): Int {
        var x = 1
        var y = n
        while (x < y) {
            val mid = x + (y - x) / 2
            when {
                guess(mid) == -1 -> {
                    y = mid
                }
                guess(mid) == 1 -> {
                    x = mid + 1
                }
                else -> {
                    return mid
                }
            }
        }
        return n
    }
}

open class GuessGame {

    open fun guessNumber(n: Int): Int {
        TODO("Not yet implemented")
    }

    fun guess(num: Int): Int {
        TODO("Not yet implemented")
    }
}
