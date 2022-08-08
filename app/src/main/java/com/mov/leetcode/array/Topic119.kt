package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/8
 * ### Modify: 简单
 * ### Description: 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * ## 例子:
 * ### 示例 1:
 * ```
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * ```
 * ### 示例 2:
 * ```
 * 输入: rowIndex = 0
 * 输出: [1]
 * ```
 * ### 示例 3:
 * ```
 * 输入: rowIndex = 1
 * 输出: [1,1]
 * ```
 * ## 思路:
 * 没啥好说的,基于杨辉三角I的基础上优化了代码,然后还是一样的先计算每层的元素
 * 最后根据答案返回对应层数
 * ## 成绩:
 * - 执行用时：148 ms, 在所有 Kotlin 提交中击败了50.08%的用户
 * - 内存消耗：34.2 MB, 在所有 Kotlin 提交中击败了39.61%的用户
 *
 */
fun main() {
    println(Solution119().getRow(5))
}

class Solution119 {

    fun getRow(rowIndex: Int): List<Int> {
        val result = arrayListOf<ArrayList<Int>>()
        for (i in 0..rowIndex) {
            val tmp = arrayListOf(1)
            for (j in 1..i) {
                if (j == i) {
                    tmp.add(1)
                } else {
                    tmp.add(result[i - 1][j - 1] + result[i - 1][j])
                }
            }
            result.add(tmp)
        }
        return result[rowIndex]
    }
}