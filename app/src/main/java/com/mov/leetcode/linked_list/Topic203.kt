package com.mov.leetcode.linked_list

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/26
 * ### Modify: 简单
 * ### Description: 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * ```
 * ### 示例 2：
 * ```
 * 输入：head = [], val = 1
 * 输出：[]
 * ```
 * ### 示例 3：
 * ```
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * ```
 * ## 思路:
 * 可以使用while循环来判断每个节点是否是需要删除
 * 也可以使用递归来操作每个元素
 * ## 成绩:
 * - 执行用时：232 ms, 在所有 Kotlin 提交中击败了26.79%的用户
 * - 内存消耗：37.1 MB, 在所有 Kotlin 提交中击败了5.36%的用户
 *
 */


class Solution203 {

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) return null
        head.next = removeElements(head.next, `val`)
        return if (head.`val` == `val`) head.next else head
    }
}