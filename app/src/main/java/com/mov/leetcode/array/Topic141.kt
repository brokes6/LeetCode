package com.mov.leetcode.array

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/18
 * ### Modify: 简单
 * ### Description: 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * ```
 * ### 示例 2：
 * ```
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * ```
 * ### 示例 3：
 * ```
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * ```
 * ## 思路:
 * 题目中的pos忽视即可,题目的意思就是给你一串链表,让你判断这个链表是否存在环
 * ## HashMap
 * 所以我们可以创建一个HashMap,然后进行循环,每次都先判断HashMap中是否已经存在当前链表
 * - 如果没有,则继续讲链表存入HashMap中
 * - 如果有,则表示有环
 * ## 快慢指针
 * 创建两个指针,一开始都指向头部,然后进行循环
 * - 快指针指向下一个链表的下一个链表
 * - 慢指针指向下一个链表
 * 每次都判断这两个指针是否相等,若相等则存在环
 * ## 成绩:
 * - 执行用时：240 ms, 在所有 Kotlin 提交中击败了10.29%的用户
 * - 内存消耗：35.7 MB, 在所有 Kotlin 提交中击败了82.35%的用户
 *
 */

fun main() {
    print(Solution141().hasCycle(ListNode(3).apply {
        next = ListNode(2).apply {
            next = ListNode(0).apply {
                next = ListNode(-4)
            }
        }
    }))
}

class Solution141 {
    fun hasCycle(head: ListNode?): Boolean {
        var fast = head
        var slow = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (fast == slow) return true
        }
        return false
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}