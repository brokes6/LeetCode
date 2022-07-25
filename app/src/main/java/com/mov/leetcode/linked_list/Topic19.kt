package com.mov.leetcode.linked_list

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/25
 * ### Modify: 中等
 * ### Description: 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * ```
 * ### 示例 2：
 * ```
 * 输入：head = [1], n = 1
 * 输出：[]
 * ```
 * ### 示例 3：
 * ```
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * ```
 * ## 思路:
 * 采用快慢指针来进行答题,由题目可得出一个信息,若快指针比慢指针快出n个节点时,
 * 当快指针指向结尾时,慢指针刚好指向要删除的元素
 * 于是我们可以在这基础上进行答题
 * 1. 创建一个新的节点,用于指向head
 * 2. 创建快指针f,指向head
 * 3. 创建慢指针s,指向刚刚创建的新节点,也就是在head之前
 * 4. 进行循环,将快指针提前指向第n个节点
 * 5. 开始快慢指针的行动
 * 6. 当快指针指向尾部时,就表示慢指针的next则是要被删除的元素
 * ## 成绩:
 * - 执行用时：204 ms, 在所有 Kotlin 提交中击败了6.58%的用户
 * - 内存消耗：34.4 MB, 在所有 Kotlin 提交中击败了15.13%的用户
 *
 */


class Solution19 {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        // 首先创建一个节点来用于指向给定的头结点
        val origin = ListNode(0, head)
        // 再创建两个快慢指针
        var f: ListNode? = head
        var s: ListNode? = origin
        // 快指针提前向后指向第n个
        for (i in 0 until n) {
            f = f?.next
        }
        // 然后开始进行慢指针的动作
        while (f != null) {
            f = f.next
            s = s?.next
        }
        // 当快指针指向结尾时,慢指针会刚好指向要删除的元素的上一个节点
        s?.next = s?.next?.next
        // 于是我们只要返回最开始的头结点即可
        return origin.next
    }
}