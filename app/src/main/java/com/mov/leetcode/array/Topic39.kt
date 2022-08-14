package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/13
 * ### Modify: 中等
 * ### Description: 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。
 * 如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * ```
 * ### 示例 2：
 * ```
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * ```
 * ### 示例 3：
 * ```
 * 输入: candidates = [2], target = 1
 * 输出: []
 * ```
 * ## 思路:
 * 使用回溯算法，本质上就是列举所有可能，使用循环条件来进行限制
 * 首先我们可以使用一个循环来进行数组的遍历
 * 然后每次循环都将当前数字添加进临时的List中
 * 然后再将target-添加的数字再次传入本身(也就是进行递归)
 * 直到 target == 0 退出递归
 * 我们还需要创建一个变量用于记录使用过的数字，防止重复
 * ## 成绩:
 * - 执行用时：232ms, 在所有 Kotlin 提交中击败了51.65%的用户
 * - 内存消耗：39.4MB, 在所有 Kotlin 提交中击败了14.29%的用户
 *
 */
fun main() {
    println(Solution39().combinationSum(intArrayOf(1, 2, 3), 3))
}


class Solution39 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val listAll = arrayListOf<List<Int>>()
        val list = arrayListOf<Int>()
        candidates.sort()
        dsl(listAll, list, candidates, target, 0)
        return listAll
    }

    fun dsl(
        listAll: MutableList<List<Int>>,
        tmp: MutableList<Int>,
        candidates: IntArray,
        target: Int,
        num: Int
    ) {
        // 当目标数字已经用完了，那就直接返回
        if (target == 0) {
            listAll.add(tmp)
            return
        }
        // 如果目标数字比当前循环当数字要小，那么表示当前分支已经失败了，直接return即可
        if (target < candidates[0]) return
        // 这里是用于记录每层递归中已使用的数字，这样每层递归都会去使用下一个数字
        var i = num
        while (i < candidates.size && candidates[i] <= target) {
            //拷贝一份，不影响下次递归
            val list: MutableList<Int> = ArrayList(tmp)
            list.add(candidates[i])
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            dsl(listAll, list, candidates, target - candidates[i], i)
            // 更新使用过的数字
            i++
        }
    }
}