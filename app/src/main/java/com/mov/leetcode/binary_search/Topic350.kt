package com.mov.leetcode.binary_search

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/6
 * ### Modify: 简单
 * ### Description: 350. 两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 * ## * 题目的意思其实就是说输出重复的数字,有多少个重复就输出多少个,不需要去重
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * ```
 * ### 示例 2:
 * ```
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * ```
 * ## 思路:
 * 1. 题目要我们从两个数组中提取出他们的交集,那么我们可以得知,答案长度一定不会超过数组长度最小的那个的长度
 * 2. 因此,我们可以先创建一个HashMap<Int,Int>,将数组长度较小的数组元素添加进去,若发现重复元素,则直接在Value上+1
 * 3. 然后循环第二个数组,每次循环都会尝试使用当前元素从HashMap中进行获取Value
 * - 如果Value>1,则表示这个元素在之前就出现过了,现在也出现了,满足题目需求.将其存放到一个新的数组中去(最后更新HashMap中的Value值)
 * - 若Value<1,则表示这个元素没有出现过,直接不管,进行下一次循环
 *
 * ## 成绩:
 * - 执行用时：196 ms, 在所有 Kotlin 提交中击败了76.27%的用户
 * - 内存消耗：37.3 MB, 在所有 Kotlin 提交中击败了11.87%的用户
 *
 */

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    print(Solution350().intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)))
}

class Solution350 {
    // [1,2,2,1]
    // [2,2]
    @RequiresApi(Build.VERSION_CODES.N)
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        // 将数组大小进行排放
        if (nums1.size > nums2.size) {
            return intersect(nums2, nums1)
        }
        val map: HashMap<Int, Int> = hashMapOf()
        // 先将数组长度小的存放进HashMap中
        nums1.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        // 有题目可知,答案长度一定不会超过最小数组长度
        val result = IntArray(nums1.size)
        var index = 0
        nums2.forEach {
            // 获取当前元素在HaspMap中的Value
            var count = map.getOrDefault(it, 0)
            // 判断是否在之前出现过
            if (count > 0) {
                // 若出现过,则将当前元素存放进答案数组中
                result[index++] = it
                count -= 1
                // 并且更新HashMap中的值
                if (count > 0) {
                    map[it] = count
                } else {
                    map.remove(it)
                }

            }
        }
        return result.copyOfRange(0, index)
    }
}