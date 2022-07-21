package com.mov.leetcode.linked_list

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/21
 * ### Modify: 简单
 * ### Description: 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。
 * 返回 已排序的链表 。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * ```
 * ### 示例 2：
 * ```
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * ```
 * ## 思路:
 * 这题很简单,但还是有个坑的,先说解法
 * 进行一次循环
 * - 若下一个节点与当前节点相等,则将当前节点的下一个指向下一个节点的下一个
 * - 若不相等,则正常指向下一个

 * /ps: 需要再创建一个变量来等于head,这么做是为了保留一个头结点(因为是地址引用,在变量上进行更改,head中也会生效)
 * ## 成绩:
 * - 执行用时：196 ms, 在所有 Kotlin 提交中击败了24.56%的用户
 * - 内存消耗：34.5 MB, 在所有 Kotlin 提交中击败了91.23%的用户
 *
 */

fun main() {
    println(Solution83().deleteDuplicates(ListNode(1).apply {
        next = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(3)
                }
            }
        }
    }))
}

class Solution83 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return head
        // 这里主要是为了保留住头指针,如果没有头指针.那么之前的节点全都会丢失
        var result = head
        while (result?.next != null) {
            // 若下一个节点与当前节点相等,则将当前节点的下一个指向下一个节点的下一个
            if (result.`val` == result.next?.`val`) {
                result.next = result.next?.next
            }else{
                result = result.next
            }
        }
        // 这里得返回head,而不是result,因为result在每次移动中都变成了各个节点,因此需要返回头结点才可以
        return head
    }
}