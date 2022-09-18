package com.mov.leetcode.array.back_tracking

/**
 * ### Author: fuxinbo
 * ### Date: 2022/9/15
 * ### Modify: 77. 组合
 * ### Description: 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * ```
 * ### 示例 2：
 * ```
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * ```
 * ## 思路:
 * 还是一样，使用回溯算法，终止条件就是：当临时列表的长度等于指定长度时，添加进答案中并return
 * * 需要注意的是，每次进行内层循环时，都需要重新创建一个新的临时列表，以防是引用传值
 * ## 成绩:
 * - 执行用时：328ms, 在所有 Kotlin 提交中击败了28.57%的用户
 * - 内存消耗：41.5MB, 在所有 Kotlin 提交中击败了34.29%的用户
 *
 */

fun main() {
    Solution77().combine(4, 2).forEach {
        println()
        it.forEach { data ->
            print("${data},")
        }
    }
}

class Solution77 {
    val result = mutableListOf<List<Int>>()

    fun combine(n: Int, k: Int): List<List<Int>> {
        val tmp = mutableListOf<Int>()
        backTracking(tmp, 1, n, k)
        return result
    }

    fun backTracking(
        tmp: MutableList<Int>,
        index: Int,
        n: Int,
        k: Int
    ) {
        if (tmp.size == k) {
            result.add(tmp)
            return
        }
        for (i in index..n) {
            // 每层都需要创建一个新都tmp list，不然传递会是引用传值
            val tmps = ArrayList(tmp)
            tmps.add(i)
            backTracking(tmps, i + 1, n, k)
            // 不需要进行remove的操作，由于我们每层都是重新创建list，当这层不满足条件时，直接舍弃即可
        }
    }
}