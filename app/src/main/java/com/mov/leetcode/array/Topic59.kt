package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/16
 * ### Modify: 中等
 * ### Description: 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * ```
 * ### 示例 2：
 * ```
 * 输入：n = 1
 * 输出：[[1]]
 * ```
 * ## 思路:
 * 使用模拟法来进行计算，具体思路在下面代码中
 * ## 成绩:
 * - 执行用时：156ms, 在所有 Kotlin 提交中击败了41.67%的用户
 * - 内存消耗：33.2 MB, 在所有 Kotlin 提交中击败了36.11%的用户
 *
 */

fun main() {
    Solution59().generateMatrix(3).forEach {
        println(it.forEach { data->
            print(" ${data}")
        })
    }
}

class Solution59 {
    // 使用模拟法，就按照规则来一个一个模拟出来
    fun generateMatrix(n: Int): Array<IntArray> {
        // 定义4边的位置
        var l = 0
        var r = n - 1
        var t = 0
        var b = n - 1
        var num = 1
        // 在根据n的大小来决定创建多大的矩阵
        val result : Array<IntArray> = Array(n){ IntArray(n) }
        // 由于是个矩阵，所以最大的数字就是给定n的平方
        while (num <= (n * n)){
            // 首先来模拟从左到右
            for (i in l..r){
                // 给第一排的格子上填充数字
                result[t][i] = num++
            }
            // 排数+1
            t++
            // 再来模拟从上到下
            for (i in t..b){
                // 给靠右边的那一列填充数字
                result[i][r] = num++
            }
            // 右边的位置-1，因为右边已经填充完毕
            r--
            // 再来模拟从右到左
            for (i in r downTo l){
                // 给最下面一排填充数字
                result[b][i] = num++
            }
            // 底部的位置更新
            b--
            for (i in b downTo t){
                result[i][l] = num++
            }
            l++
        }
        return result
    }

}