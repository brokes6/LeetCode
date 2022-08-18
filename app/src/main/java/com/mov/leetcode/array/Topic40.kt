package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/18
 * ### Modify: 中等
 * ### Description: 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * ## 例子:
 * ### 示例 1:
 * ```
 * 输入: candidates =[10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * ```
 * ### 示例 2:
 * ```
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * ```
 * ## 思路:
 * 对于组合、排列、子集等问题都可以使用回溯算法来解答
 * 在本题中，题目要求数组中都元素只可使用一次，并结果不能重复
 * 所以我们可以先对数组进行排序，然后通过一个BooleanArray来进行甄别当前元素是否重复
 * - 若重复，则跳过当前循环
 * - 若不重复，则将当前元素添加进临时列表中，并累加上当前元素进入递归
 * 在递归后方，就是进行回溯的时候了，将用于甄别的BooleanArray重新置于false
 * 注：每次循环都需要将用于记录当前索引值的元素+1
 * ## 成绩:
 * - 执行用时：220ms, 在所有 Kotlin 提交中击败了75.00%的用户
 * - 内存消耗：35.5MB, 在所有 Kotlin 提交中击败了96.43%的用户
 *
 */

fun main() {
    Solution40().combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8).forEach {
        println()
        it.forEach { sub ->
            print(sub)
        }
    }
}

class Solution40 {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val tmp = mutableListOf<Int>()
        candidates.sort()
        // 创建一个默认为false的数组，用于后续甄别当前元素是否重复使用(只在递归内层进行甄别)
        backTracking(result, tmp, BooleanArray(candidates.size) {
            false
        }, candidates, target, 0, 0)
        return result
    }

    fun backTracking(
        result: MutableList<List<Int>>,
        tmp: MutableList<Int>,
        uses: BooleanArray,
        candidates: IntArray,
        target: Int,
        index: Int,
        sum: Int
    ) {
        // 递归出口，将当前结果进行收集
        if (sum == target) {
            result.add(tmp)
            return
        }
        var i = index
        // 进行单层搜索，条件为当前索引小于list长度，当前累计的数字小于或等于给定数字
        while (i < candidates.size && sum + candidates[i] <= target) {
            // 若当前数字不为第一个数字并且与上个数字相同，用于甄别的uses也为false，这就表明这个元素在之前就使用过了
            if (i > 0 && candidates[i] == candidates[i - 1] && !uses[i - 1]) {
                i++
                continue
            }
            uses[i] = true
            // 复制一份tmp，将当前元素存入
            val tmps = ArrayList(tmp)
            tmps.add(candidates[i])
            // 进行递归
            backTracking(result, tmps, uses, candidates, target, i + 1, sum + candidates[i])
            // 进行回溯，将之前的操作回溯掉
            uses[i] = false
            i++
        }
    }
}