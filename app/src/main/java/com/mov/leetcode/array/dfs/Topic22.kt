package com.mov.leetcode.array.dfs

/**
 * ### Author: fuxinbo
 * ### Date: 2022/9/20
 * ### Modify: 中等
 * ### Description: 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * ## 例子:
 * ### 示例 1：
 * ```
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * ```
 * ### 示例 2：
 * ```
 * 输入：n = 1
 * 输出：["()"]
 * ```
 * ## 思路:
 * 这题采用dfs(深度优先搜索算法)来进行完成
 * - dfs：即 按照题目要求一直向下走，直到无法满足题目则返回上一步
 * - 可参考 https://www.cnblogs.com/DWVictor/p/10048554.html
 *
 * 由于题目中说明了是 有效的 括号，所以我们优先放置左括号，右括号的放置则根据是否放置了左括号来
 * 剩下就是当括号放置完毕，添加到答案中
 * ## 成绩:
 * - 执行用时：168ms, 在所有 Kotlin 提交中击败了80.23%的用户
 * - 内存消耗：34.8MB, 在所有 Kotlin 提交中击败了94.19%的用户
 *
 */

fun main() {
    Solution22().generateParenthesis(3).forEach {
        print("${it},")
    }
}

class Solution22 {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        dfs(result,"",n,n)
        return result
    }

    fun dfs(result: MutableList<String>, tmp: String, l: Int, r: Int) {
        // 通过减少左括号和右括号的数量来进行控制结束
        if (l == 0 && r == 0) {
            result.add(tmp)
            return
        }
        // 若左括号还有剩余，则添加左括号
        if (l > 0) {
            dfs(result, "$tmp(", l - 1, r)
        }
        // 由于一个左括号就要匹对一个右括号
        // 于是只能在使用过左括号之后才可以使用右括号
        if (r > l) {
            dfs(result, "$tmp)", l, r - 1)
        }
    }
}