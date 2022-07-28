package com.mov.leetcode.array

/**
 * ### Author: fuxinbo
 * ### Date: 2022/7/28
 * ### Modify: 简单
 * ### Description: 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，
 * 另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * ```
 * ### 示例 2：
 * ```
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * ```
 * ## 思路:
 * 通过两个指针,来不停比较两个数组中元素的大小,将教小的元素按照指针的索引保存起来,
 * 当一个数组比较完毕时,则可将另一个数组直接添加进答案中(详情可查看代码注释)
 * ## 成绩:
 * - 执行用时：172 ms, 在所有 Kotlin 提交中击败了67.50%的用户
 * - 内存消耗：34.7 MB, 在所有 Kotlin 提交中击败了48.75%的用户
 *
 */

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        // p1指针用于指向nums1的头部
        var p1 = 0
        // p2指针用于指向nums2的头部
        var p2 = 0
        // 在创建一个新的指针用于保存两个数组比较后较为小的那个元素
        var cur = 0
        // 创建一个数组用于保存答案
        val result = IntArray(m + n)
        // 只要其中一个指针没有结束,那么就还可以继续
        while (p1 < m || p2 < n) {
            cur = when {
                // 当nums1结束时,直接添加nums2即可,由于两个数组都是有序的,因此在nums1比较完毕后,nums2剩下的元素一定是比nums1中要大的
                p1 == m -> {
                    nums2[p2++]
                }
                p2 == n -> {
                    nums1[p1++]
                }
                // 进行比较,找到较小的元素
                nums1[p1] < nums2[p2] -> {
                    nums1[p1++]
                }
                else -> {
                    nums2[p2++]
                }
            }
            // 存放到结果中去
            result[p1 + p2 - 1] = cur
        }
        // 最后由于题目要求返回nums1,所以将答案同步到nums1中
        result.forEachIndexed { index, i ->
            nums1[index] = i
        }
    }
}


