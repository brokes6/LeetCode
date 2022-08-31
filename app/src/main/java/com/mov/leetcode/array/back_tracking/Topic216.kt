package com.mov.leetcode.array.back_tracking

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/31
 * ### Modify: 中等
 * ### Description: 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * - 只使用数字1到9
 * - 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * ## 例子:
 * ### 示例 1:
 * ```
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * ```
 * ### 示例 2:
 * ```
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * ```
 * ## 思路:
 * 没啥好说的，回溯就完事了,只是循环条件稍微有些不同
 * ## 成绩:
 * - 执行用时：148ms, 在所有 Kotlin 提交中击败了50.00%的用户
 * - 内存消耗：34MB, 在所有 Kotlin 提交中击败了30.00%的用户
 *
 */

fun main() {
    Solution216().combinationSum3(3, 9).forEach {
        println()
        it.forEach { data ->
            print(data)
        }
    }
}

class Solution216 {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        val tmp: MutableList<Int> = mutableListOf()
        backTrack(result, tmp, k, 1, n)
        return result
    }

    fun backTrack(
        result: MutableList<List<Int>>,
        tmp: MutableList<Int>,
        use: Int,
        index: Int,
        target: Int
    ) {
        // 若target=0，答案都个数为指定个数，那么表示找到一个答案
        if (target == 0 && tmp.size == use) {
            result.add(tmp)
            return
        }
        // 每次都从上一个数字开始
        var i = index
        // 可用数字为1-9
        while (i <= 9 && target > 0) {
            val tmps = ArrayList(tmp)
            tmps.add(i)
            // 这里采取相减的方式进行，每次都减去当前都数字，若还有剩余数字，那么继续
            backTrack(result, tmps, use, i + 1, target - i)
            i++
        }
        return
    }
}