package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/2
 * ### Modify: 简单
 * ### Description: 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * ## 例子:
 * ### 示例 1:
 * ```
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * ```
 * ### 示例 2:
 * ```
 * 输入: numRows = 1
 * 输出: [[1]]
 * ```
 * ## 思路:
 * 杨辉三角嘛,它的第一层和第二层都是固定的(都为1),那么我们可以节省点操作,直接将前两层都搭建好.
 * 于是直接从第三层开始计算.接下来肯定要创建一个循环嘛,用于外层创建层数.
 * 然后我们继续再创建两个快慢指针,这两个指针的作用是用来指向上一层的元素,来计算当前位置元素的值
 * 准备工作都完成之后,在进行一个内循环,用于一层中内部元素值的计算
 * - 内存循环条件:慢指针指向上一层的尾部时结束
 * 每次都将快指针指向的值+慢指针指向的值,添加进临时List中
 * 然后再移动这两个指针即可
 *
 * ## 成绩:
 * - 执行用时：144 ms, 在所有 Kotlin 提交中击败了81.58%的用户
 * - 内存消耗：34.3 MB, 在所有 Kotlin 提交中击败了55.26%的用户
 *
 */

fun main() {
    Solution118().generate(5).forEach { it ->
        println()
        it.forEach {
            print("${it},")
        }
    }
}


class Solution118 {
    fun generate(numRows: Int): List<List<Int>> {
        // 第一层和第二层可直接写好来,因为是不会有变化的
        if (numRows == 0) return mutableListOf(mutableListOf())
        if (numRows == 1) return mutableListOf(mutableListOf(1))
        val result = mutableListOf(mutableListOf(1), mutableListOf(1, 1))
        var cur = 2
        while (cur < numRows) {
            var fast = 0
            var slow = fast + 1
            val tmp = mutableListOf<Int>()
            // 由于杨辉三角的头和尾部都是固定的1,于是我们就可以直接添加上
            tmp.add(1)
            while (slow < cur) {
                // 根据上一层对应的元素相加来获取当前元素的值
                tmp.add(result[cur - 1][fast] + result[cur - 1][slow])
                fast += 1
                slow += 1
            }
            cur++
            // 结尾处也要加上1
            tmp.add(1)
            result.add(tmp)
        }
        return result
    }
}