package com.mov.leetcode.linked_list

/**
 * ### Author: 付鑫博
 * ### Date: 2022/7/20
 * ### Modify: 简单
 * ### Description: 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * ```
 * ### 示例 2：
 * ```
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * ```
 * ### 示例 3：
 * ```
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * ```
 * ## 思路:
 * 这道题的本质就是不断寻找当前较小的那应该节点,并使用递归串在一起
 * 于是我们可以在第一层的时候就进行判断两个链表的大小(List1,List2)
 * - 若List1较小,我们就把List1作为我们答案的链表.反之就List2作为答案的链表
 * - 然后我们进行递归,将我们选择好的链表头的next传入,第二个参数则传入剩下的那个链表
 * - 就这样不停的递归下去,每次都会找到当前循环中最小的链表,并将本身都next传递下去
 * - 这样直到next为空,则会停止递归,向上返回答案
 * ## 成绩:
 * - 执行用时：160 ms, 在所有 Kotlin 提交中击败了88.51%的用户
 * - 内存消耗：34.3 MB, 在所有 Kotlin 提交中击败了68.51%的用户
 *
 */
class Solution21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        // 寻找当前较小的链表
        val result: ListNode = if (list1.`val` < list2.`val`) list1 else list2
        // 将答案链表的next传递下去,并将剩下的那个链表传入
        result.next = mergeTwoLists(result.next, if (list1.`val` >= list2.`val`) list1 else list2)
        return result
    }
}