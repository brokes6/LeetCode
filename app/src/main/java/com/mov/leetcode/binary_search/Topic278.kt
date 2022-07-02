package com.mov.leetcode.binary_search

/**
 * ### Author: fuxinbo
 * ### Date: 2022/7/02
 * ### Modify: 简单
 * ### Description: 278. 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

 * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * ```
 * ### 示例 2：
 * ```
 * 输入：n = 1, bad = 1
 * 输出：1
 * ```
 * ## 思路:
 * 还是一样可以使用二分查找,设定两个变量x,y
 * - x从最左边开始,也就是从1开始
 * - y从最右边开始,也就是从给定数字开始
 * ### 进行循环(x<y),每次都取中间值,然后判断是否为错误版本
 * - 若为错误版本,那么说明中间值之后的所有版本都是错误版本,则只需要向前查找更小的错误版本即可(y = mid)
 * - 若不是错误版本,那么说明中间值之前的所有版本都是没有错误的,那么只需要向后查找即可(x = mid+1)
 * ## 成绩:
 * - 执行用时： 236 ms, 在所有 Kotlin 提交中击败了72.73%的用户
 * - 内存消耗： 32.1 MB, 在所有 Kotlin 提交中击败了21.21%的用户
 *
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution278 : VersionControl() {
    // 1,2,3,4,5  bad --> 4
    override fun firstBadVersion(n: Int): Int {
        var x = 1
        var y = n
        // 设置一个默认答案
        var result = 1
        while (x < y) {
            val mid = x + (y - x) / 2
            if (isBadVersion(mid)) {
                y = mid
                result = mid
            } else {
                x = mid + 1
                // 当最左端进行移动时,默认答案也需要跟着移动
                result = x
            }
        }
        return result
    }


}

open class VersionControl {

    open fun firstBadVersion(n: Int): Int {
        TODO("Not yet implemented")
    }

    fun isBadVersion(mid: Int): Boolean {
        TODO("Not yet implemented")
    }
}
