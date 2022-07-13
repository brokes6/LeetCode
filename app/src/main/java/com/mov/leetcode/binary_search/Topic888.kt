package com.mov.leetcode.binary_search

import java.util.*

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/12
 * ### Modify: 简单
 * ### Description: 888. 公平的糖果交换
 * 爱丽丝和鲍勃拥有不同总数量的糖果。
 * 给你两个数组 aliceSizes 和 bobSizes ，aliceSizes[i] 是爱丽丝拥有的第 i 盒糖果中的糖果数量，
 * bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量。</n>
 * 两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。一个人拥有的糖果总数量是他们每盒糖果数量的总和。
 * 返回一个整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。
 * 如果存在多个答案，你可以返回其中 任何一个 。题目测试用例保证存在与输入对应的答案。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：aliceSizes = [1,1], bobSizes = [2,2]
 * 输出：[1,2]
 * ```
 * ### 示例 2：
 * ```
 * 输入：aliceSizes = [1,2], bobSizes = [2,3]
 * 输出：[1,2]
 * ```
 * ### 示例 3：
 * ```
 * 输入：aliceSizes = [2], bobSizes = [1,3]
 * 输出：[2,3]
 * ```
 * ### 示例 4：
 * ```
 * 输入：aliceSizes = [1,2,5], bobSizes = [2,4]
 * 输出：[5,4]
 * ```
 * ## 思路:
 * 首先先要从题目中得出以下公式
 * * 设爱丽丝糖果总数为Asum,鲍勃糖果总数为Bsum.爱丽丝交换出去的糖果为x,鲍勃交换的糖果为y
 * ```
 *  Asum -x +y = Bsum +x -y
 *  2y = Asum - Bsum + 2x
 *  y = (Asum - Bsum) / 2 +x
 * ```
 * 也就是现在演变成了从鲍勃的糖果中查找是否有满足以上公式的个数,若满足,则为答案
 * ## 成绩:
 * - 执行用时：316 ms, 在所有 Kotlin 提交中击败了100.00%的用户
 * - 内存消耗：39.1 MB, 在所有 Kotlin 提交中击败了66.67%的用户
 *
 */

fun main() {
    Solution888().fairCandySwap(intArrayOf(1, 1), intArrayOf(2, 2)).forEach {
        println(it)
    }
}

class Solution888 {
    fun fairCandySwap(aliceSizes: IntArray, bobSizes: IntArray): IntArray {
        // 计算爱丽丝和鲍勃的糖果总数
        val Asum = Arrays.stream(aliceSizes).sum()
        val Bsum = Arrays.stream(bobSizes).sum()
        // 先进行公式(Asum - Bsum) / 2部分
        val difference = (Asum - Bsum) / 2
        // 在创建一个临时的HashSet集合,用于存放爱丽丝的糖果
        val temporary = hashSetOf<Int>()
        aliceSizes.forEach {
            temporary.add(it)
        }
        val result = IntArray(2)
        // 在循环鲍勃糖果,每次都从中进行查找是否有满足以上公式的糖果
        bobSizes.forEach {
            val x = difference + it
            if (temporary.contains(x)) {
                // 若满足,则为答案
                result[0] = x
                result[1] = it
                return@forEach
            }
        }
        return result
    }
}