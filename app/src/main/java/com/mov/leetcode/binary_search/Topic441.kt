package com.mov.leetcode.binary_search


/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/7
 * ### Modify: 简单
 * ### Description: 441. 排列硬币
 * 你总共有n枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 给你一个数字n ，计算并返回可形成 完整阶梯行 的总行数。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * ```
 * ### 示例 2：
 * ```
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 * ```
 * ## 思路:
 * 题目的意思是判断给定的数字能搭成多少层的阶梯,那么我们就可以进行一个循环,每次循环都用当前的数字
 * 去减去当前的阶梯数,然后再判断剩余的数字是>1还是=1还是<1
 * - 剩余数字>1:大于1则表示当前阶梯全部搭建完毕,可以使阶梯数+1,继续下一阶梯
 * - 剩余数=1:等于1则表示当前阶梯刚好搭建完毕,直接输出当前阶梯数
 * - 剩余数<1:小于1则表示当前阶梯无法搭建完毕,当前阶梯数-1,并退出循环
 * ## 成绩:
 * - 执行用时：148 ms, 在所有 Kotlin 提交中击败了42.86%的用户
 * - 内存消耗：32.7 MB, 在所有 Kotlin 提交中击败了64.29%的用户
 *
 */

fun main() {
    print(Solution441().arrangeCoins(3))
}

class Solution441 {
    fun arrangeCoins(n: Int): Int {
        if (n <= 0) return 0
        var result = 1
        var total: Int = n
        while (total > 0) {
            total -= result
            when {
                total > 0 -> {
                    result += 1
                }
                total == 0 -> {
                    return result
                }
                else -> {
                    result -= 1
                }
            }
        }
        return result
    }
}