package com.mov.leetcode.array

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/17
 * ### Modify: 简单
 * ### Description: 217. 存在重复元素
 * 给你一个整数数组 nums 。
 * 如果任一值在数组中出现 至少两次 ，
 * 返回 true ；如果数组中每个元素互不相同，返回 false 。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * ```
 * ### 示例 2：
 * ```
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * ```
 * ### 示例 3：
 * ```
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * ```
 * ## 思路:
 * - 没得说，就简单的HashMap解决
 * - 但是还可以先将数组进行排序，排序之后若有重复的元素，
 * 则会出现在相邻的两个元素中。我们就只需要每次都判断下一个元素是否与当前元素相等即可
 * ## 成绩(哈希表结果):
 * - 执行用时：360ms, 在所有 Kotlin 提交中击败了78.30%的用户
 * - 内存消耗：46.6MB, 在所有 Kotlin 提交中击败了63.21%的用户
 *
 */

fun main() {
    println(Solution217().containsDuplicate(intArrayOf(0)))
}

class Solution217 {
    @RequiresApi(Build.VERSION_CODES.N)
    fun containsDuplicate(nums: IntArray): Boolean {
        val result : HashMap<Int,Int> = hashMapOf()
        nums.forEach {
            result[it] = result.getOrDefault(it,0) + 1
            if (result.getOrDefault(it,0) >  1){
                return true
            }
        }
        return false
    }
}