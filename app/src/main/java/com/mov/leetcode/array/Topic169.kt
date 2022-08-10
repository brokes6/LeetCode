package com.mov.leetcode.array

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/9
 * ### Modify: 简单
 * ### Description: 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums = [3,2,3]
 * 输出：3
 * ```
 * ### 示例 2：
 * ```
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * ```
 * ## 思路:
 * ### V1:
 * 第一个版本就纯做,创建一个HashMap来记录每个元素出现的次数，
 * 然后在每次都进行比较当前元素出现的次数与上次最高次数的元素的次数大小
 * - 大则将当前元素替换为最大元素
 * - 小则下一个
 * ### V2:
 * 这个就有点意思,先创建一个变量用来记录当前元素出现的次数
 * 进行循环，每次循环都进行判断,当前元素是否等于一开始记录的元素
 * - 若相等，则次数+1
 * - 若不相等。则次数-1
 * - 若次数为0,则将当前循环的元素做为记录元素,继续
 * ## 成绩:
 * - 执行用时：284 ms, 在所有 Kotlin 提交中击败了11.83%的用户
 * - 内存消耗：41.8 MB, 在所有 Kotlin 提交中击败了40.86%的用户
 *
 * ## 成绩(V2):
 * - 执行用时：216 ms, 在所有 Kotlin 提交中击败了77.42%的用户
 * - 内存消耗：41.8 MB, 在所有 Kotlin 提交中击败了29.03%的用户
 */
fun main() {
    println(Solution169().majorityElement(intArrayOf(6, 5, 5)))
}

class Solution169 {
    @RequiresApi(Build.VERSION_CODES.N)
    fun majorityElement(nums: IntArray): Int {
        val tmp = hashMapOf<Int, Int>()
        var pre = nums[0]
        var result = nums[0]
        nums.forEach {
            tmp[it] = tmp.getOrDefault(it, 0) + 1
            result = if (tmp.getOrDefault(it, 0) > tmp.getOrDefault(pre, 0)) {
                pre = it
                it
            } else {
                result
            }
        }
        return result
    }

    fun majorityElementV2(nums: IntArray): Int {
        var cur = 0
        var tmp = 0
        for (i in nums.indices) {
            when {
                cur == 0 -> {
                    tmp = nums[i]
                    cur++
                }
                tmp == nums[i] -> {
                    cur++
                }
                else -> {
                    cur--
                }
            }
        }
        return tmp
    }
}