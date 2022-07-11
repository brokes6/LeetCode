package com.mov.leetcode.binary_search

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/11
 * ### Modify: 简单
 * ### Description: 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * - 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * ```
 * ### 示例 2:
 * ```
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * ```
 * ### 示例 3:
 * ```
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 * ```
 * ## 思路:
 * 不用想这么复杂,确实就相当于是查找最小的数字,但是char数组中可能会有重复的字母,所以就需要进行一次判断
 * - 如果给定的char等于或大于char数组中最后一个,那么则直接返回char数组中第一个即可
 * - 如果不大于等于,那么就进行二分查找即可
 * ## 成绩:
 * - 执行用时：212 ms, 在所有 Kotlin 提交中击败了28.99%的用户
 * - 内存消耗：35.2 MB, 在所有 Kotlin 提交中击败了89.85%的用户
 *
 */

fun main() {
    print(Solution774().nextGreatestLetter(charArrayOf('c', 'c', 'h','h','j'), 'h'))
}

class Solution774 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var x = 0
        var y = letters.size - 1
        // 若出现 c,c,h,h这种(结果带有重复的),则会进入这条if
        if (target >= letters[y]) return letters[0]
        // 若没有特殊情况,那么普通的二分就可以解决
        while (x < y) {
            val mid = x + (y - x) / 2
            if (letters[mid] > target){
                y = mid
            }else{
                x = mid + 1
            }
        }
        return letters[x]
    }
}