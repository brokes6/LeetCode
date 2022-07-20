package com.mov.leetcode.array

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/19
 * ### Modify: 简单
 * ### Description: 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * ```
 * A:      a1 -> a2  -|
 *                    c1 -> c2 -> c3
 * B: b1 -> b2 -> b3 -|
 * ```
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * ```
 * ### 示例 2：
 * ```
 * 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * ```
 * ### 示例 3：
 * ```
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 * ```
 * ## 思路:
 * 评论区看到一个很优雅的方法,由于链表的长度无法得知,因此无法使用较长的来判断较短的.
 * 但是我们可以创建两个指针,A和B.它们分别从各自的链表开始并不停移动,每次进行移动时进行如下判断
 * - 若A=B,则表示找到答案,直接退出循环
 * - 若A移动到了链表的尾部,则重新移动到B链表的头部
 * - 若B移动到了链表的尾部,则重新移动到A链表的头部

 * /ps:若两个链表长度一样,会在第一次循环的时候,A与B同时指向null,因此会直接退出循环
 * ## 成绩:
 * - 执行用时：184 ms, 在所有 Kotlin 提交中击败了23.47%的用户
 * - 内存消耗：38.2MB, 在所有 Kotlin 提交中击败了11.23%的用户
 *
 */

class Solution160 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) return null
        var hA = headA
        var hB = headB
        while (hA != hB) {
            hA = if (hA == null) headB else hA.next
            hB = if (hB == null) headA else hB.next
        }
        return hA
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}