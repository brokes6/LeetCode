package com.mov.leetcode.linked_list

/**
 * ### Author: fuxinbo
 * ### Date: 2022/7/27
 * ### Modify: 简单
 * ### Description: 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * ```
 * ### 示例 2：
 * ```
 * 输入：head = [1,2]
 * 输出：[2,1]
 * ```
 * ## 思路:
 * 我们可以使用一个循环,每次循环过程中,先创建一个变量来保存当前的节点的下一个元素.
 * 然后让当前节点的next指向上一个节点(最开始上一个节点默认为Null).
 * 就这样不停的循环,直接当前节点为Null
 * ## 成绩(尾递归):
 * - 执行用时：176 ms, 在所有 Kotlin 提交中击败了42.13%的用户
 * - 内存消耗：35.5 MB, 在所有 Kotlin 提交中击败了14.72%的用户
 *
 */

//迭代
class Solution206 {
    fun reverseList(head: ListNode?): ListNode? {
        // 先模拟一个尾部出来
        var pre: ListNode? = null
        var current: ListNode? = head
        // 从头开始循环
        while (current != null) {
            // 每次循环前先临时保存下下一个需要替换的节点
            val temp = current.next
            // 将当前节点的next指向上一个节点
            current.next = pre
            // 在将pre节点向后移动
            pre = current
            // 在恢复当前节点
            current = temp
        }
        return pre
    }
}


// 尾递归
class Solution206V2 {
    fun reverseList(head: ListNode?): ListNode? {
        return recursion(null, head)
    }

    private fun recursion(pre: ListNode?, cur: ListNode?): ListNode? {
        if (cur == null) return pre
        // 保存下一个需要替换的节点
        val next = cur.next
        // 将当前节点的next指向上一个节点
        cur.next = pre
        return recursion(cur, next)
    }
}