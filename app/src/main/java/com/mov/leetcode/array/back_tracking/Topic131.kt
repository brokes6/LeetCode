package com.mov.leetcode.array.back_tracking

/**
 * ### Author: fuxinbo
 * ### Date: 2022/6/24
 * ### Modify: 中等
 * ### Description: 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * ```
 * ### 示例 2：
 * ```
 * 输入：s = "a"
 * 输出：[["a"]]
 * ```
 * ## 思路:
 * 这题和组合类型，也是需要不停的进行组合然后判断当前组合是否为回文串，
 * - 若是，则加入数组
 * - 若不是，则跳过
 * 递归负责纵向循环，内部for循环负责横向
 * 例子：
 * ```
 * 1. a a b (x = 2,i = 3) --> result.add(a,a,b)
 * 2. a a b --> list.removeLast() --> a a
 * 3. a a (x = 2) --> list.removeLast() --> a
 * 4. a (x = 1,i = 2 判断ab不为回文 i++) return
 * 5. a --> list.removerLast() -> null
 * 6. null (x = 0,i = 1 判断aa为回文) --> list.add(aa)
 * 7. aa (x = 1,i = 2 判断)
 * 4. a (x = 0,i = 1 判断 aa 为回文) --> list.add(aa)
 * 5. aa (x = 2,i = 2 判断 b 为回文) --> list.add(b)
 * 6. i >= s.length --> result.add(list)
 * 7. aa b --> list.removeLast() --> aa
 * 6. aa (x = 2,i = 3) --> result.add()
 * 7. aa  --> list.removeLast() --> a
 * 8. aa (x = 2,i = 3) return
 * 9. aa --> list.removeLast() --> null
 * 10. null (x = 0,i = 2 判断ab不为回文 i++) return
 * ```
 * ## 成绩:
 * - 执行用时：640ms, 在所有 Kotlin 提交中击败了83.33%的用户
 * - 内存消耗：63.8MB, 在所有 Kotlin 提交中击败了33.33%的用户
 *
 */


fun main() {
    Solution131().partition("aab").forEach {
        println(it.forEach { s ->
            print("${s},")
        })
    }
}

class Solution131 {
    fun partition(s: String): List<List<String>> {
        val result: MutableList<List<String>> = mutableListOf()
        blackTracking(result, mutableListOf(), s, 0)
        return result
    }

    private fun blackTracking(
        result: MutableList<List<String>>,
        tmp: MutableList<String>,
        s: String,
        x: Int,
    ) {
        if (x >= s.length) {
            // 创建一个新的list添加进去
            result.add(ArrayList(tmp))
            return
        }
        for (i in x until s.length) {
            // 每次进行组合都需要判断是否为回文
            if (judgePalindromic(s, x, i)) {
                tmp.add(s.substring(x, i + 1))
            } else {
                continue
            }
            blackTracking(result, tmp, s, i + 1)
            // 每次结束当前递归都需要清除上次选择的
            tmp.removeLast()
        }

    }

    // 判断当前字符串是否为回文，两个指针，一个从前，一个从后，判断是否相等即可
    private fun judgePalindromic(s: String, x: Int, i: Int): Boolean {
        var l = x
        var r = i
        while (l < r) {
            if (s[l] != s[r]) return false
            l++
            r--
        }
        return true
    }
}

