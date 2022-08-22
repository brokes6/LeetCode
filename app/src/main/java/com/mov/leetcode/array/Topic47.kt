package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/19
 * ### Modify: 中等
 * ### Description: 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * ```
 * ### 示例 2：
 * ```
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * ```
 * ## 思路:
 *  还是使用回溯算法
 *  我们可以设计一个数组用来记录之前使用了那些数字，然后每次进入递归都从头开始
 *  每次都先判断重复的问题，判断当前数字是否与上个数字一致，并且上个数字已经进入过一次递归了
 *  - 若与上个数字相等并进入过递归，则跳过当前循环
 *  - 若没使用过，则需要判断当前的数字是否使用过，若没使用过，则先添加到临时List，然后将当前数字设置为使用过，进入下一次递归
 * ## 成绩:
 * - 执行用时：272ms, 在所有 Kotlin 提交中击败了32.50%的用户
 * - 内存消耗：38.7MB, 在所有 Kotlin 提交中击败了35.00%的用户
 *
 */

fun main() {
    Solution47().permuteUnique(intArrayOf(1,1,2)).forEach {
        println()
        it.forEach {
            print("${it} ")
        }
    }
}

class Solution47 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        val tmp = mutableListOf<Int>()
        nums.sort()
        backTracking(result,tmp,nums,BooleanArray(nums.size) {
            false
        })
        return result
    }

    fun backTracking(
        result: MutableList<List<Int>>,
        tmp: MutableList<Int>,
        nums: IntArray,
        user: BooleanArray,
    ) {
        if (tmp.size == nums.size) {
            result.add(tmp)
            return
        }

        // 由于每次递归都是从头开始
        var i = 0
        while (i < nums.size) {
            // 若上一个数字为true，则表示在内层递归中，可以继续使用
            // 若为false，则表示上一个数字已经经历过一组递归了，就不能继续使用
            if (i > 0 && nums[i] == nums[i - 1] && !user[i-1]) {
                i++
                continue
            }
            // 所以需要有个数组来判断之前使用过都数字是那个
            if (!user[i]) {
                user[i] = true
                val tmps = ArrayList(tmp)
                tmps.add(nums[i])
                // 例如 第一次递归使用1 进入第2次递归 1不可用 于是是用2 进入第3次递归 1，2不可用 于是使用3 添加到答案
                // 回退到第2次递归 使用3 进入4次递归 1，3不可用 于是使用2 添加到答案
                backTracking(result, tmps, nums, user)
                user[i] = false
            }
            i++
        }
    }
}