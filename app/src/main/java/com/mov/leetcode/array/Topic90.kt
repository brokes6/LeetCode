package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/6/24
 * ### Modify: 中等
 * ### Description: 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * ```
 * ### 示例 2：
 * ```
 * 输入：nums = [0]
 * 输出：[[],[0]
 * ```
 * ## 思路:
 * 既然是输出子集,那么肯定会想到两层循环.
 * 但是我们可以在循环之前,先完成一些准备工作,
 * 1. 先创建一个List<List<Int>>并且向内创建一个空List
 * 2. 在向List中填充nums1中的第0个元素
 * 其实上述操作是完成了nums1中第一个元素的子集(一个本身,和一个空集)
 * 然后我们再进行循环,先判断当前需要输出子集的元素是否与上个元素相等
 * - 若不想等,则记录下当前答案列表的长度
 * - 若相等,则直接进入二级循环
 * 在二级循环中,我们先通过之前记录的答案列表长度(默认0)获取到答案列表中对应的元素,
 * 然后再创建一个List,将获取到的元素和当前元素添加入内
 * 最后将这个List添加进答案列表
 * ## 成绩:
 * - 执行用时：200 ms, 在所有 Kotlin 提交中击败了63.16%的用户
 * - 内存消耗：36.9 MB, 在所有 Kotlin 提交中击败了52.63%的用户
 *
 */
fun main() {
    Solution90().subsetsWithDup(intArrayOf(1, 2, 2)).forEach {
        println("")
        it.forEach { data ->
            print("${data},")
        }
    }
}


class Solution90 {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        // 先创建一个空的答案
        val result = mutableListOf<MutableList<Int>>(mutableListOf())
        // 当nums为空时,直接返回
        if (nums.isEmpty()) return result
        // 对nums进行排序
        nums.sort()
        val temp = mutableListOf(nums[0])
        result.add(temp)
        if (nums.size == 1) return result
        // 这里其实是用来判断答案列表中整体的位置(所谓的整体,会在下方说明)
        var lastLen = 1
        // 外层循环
        for (i in 1 until nums.size) {
            // 先获取之前存储答案的长度
            val size = result.size
            // 若之前添加的元素与当前要添加的元素不同,则可以不用去重
            if (nums[i] != nums[i - 1]){
                // 这里其实是区分从头开始,还是从前面的整体开始
                lastLen = size
            }
            // 内层循环
            for (j in size - lastLen until size) {
                // 这里分为两种情况,若外层循环中lastLen等于size,也就是前面的元素不与当前的元素相同,那么这里会对答案列表中的所有元素,每个都加上当前元素
                // 例如: [[],[1]] 那么这里就从头开始给每个元素都添加上当前元素 --> [[],[1],[2],[1,2]](添加的元素为2)
                // 若lastLen 不等于 size,则说明上个元素与当前元素一致,则不能从头开始添加元素.只能将前面添加好的整体在来添加
                // 例如: [[],[1],[2],[1,2]] 那么这里就只能对 [2],[1,2]来添加当前元素 --> [[],[1],[2],[1,2],[2,2],[1,2,2]](添加的元素为2)
                val inner: MutableList<Int> = ArrayList(result[j])
                inner.add(nums[i])
                result.add(inner)
            }
        }
        return result
    }
}