package com.mov.leetcode.binary_search

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/4
 * ### Modify: 简单
 * ### Description: 349. 两个数组的交集模板
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * ```
 * ### 示例 2：
 * ```
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * ```
 * ## 思路:
 *
 * ## 成绩:(方法一)
 * - 执行用时：216 ms, 在所有 Kotlin 提交中击败了40.74%的用户
 * - 内存消耗：35.2 MB, 在所有 Kotlin 提交中击败了92.59%的用户
 *
 */

fun main() {
    Solution349().intersection(intArrayOf(1, 2, 2, 3), intArrayOf(2, 3, 4)).forEach {
        print(it)
    }
}

/**
 * 解法一
 * 使用Set集合
 *
 */
class Solution349 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.isEmpty() || nums2.isEmpty()) {
            return intArrayOf()
        }
        val result: HashSet<Int> = hashSetOf()
        val temporary : HashSet<Int> = hashSetOf()
        nums1.forEach {
            temporary.add(it)
        }
        nums2.forEach {
            if (temporary.contains(it)) {
                result.add(it)
            }
        }
        return result.toIntArray()
    }
}

/**
 * 解法二
 * 使用数组
 *
 */
class Solution349V2 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        // 先将两个数组进行升序排序
        nums1.sort()
        nums2.sort()
        var index = 0
        var index1 = 0
        var index2 = 0
        //  先创建一个最大结果长度的数组
        val result = IntArray(nums1.size + nums2.size)
        while (index1 < nums1.size && index2 < nums2.size) {
            // 每次都比较两个数组中的数字大小
            val num1 = nums1[index1]
            val num2 = nums2[index2]
            when {
                // 若相等,则判断重复问题
                num1 == num2 -> {
                    // 判断是否与上一个数字相等
                    if (index == 0 || num1 != result[index - 1]) {
                        result[index++] = num1
                    }
                    // 继续判断下一个
                    index1++
                    index2++
                }
                // 若当前判断的两个数字不相等,则小的那一方向后移动一位
                num1 < num2 -> {
                    index1++
                }
                else -> {
                    index2++
                }
            }
        }
        return result
    }
}