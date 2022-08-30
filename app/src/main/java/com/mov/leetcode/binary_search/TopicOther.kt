package com.mov.leetcode.binary_search

/**
 * ### Author: fuxinbo
 * ### Date: 2022/8/29
 * ### Modify: 无
 * ### Description: 个人使用测试
 * ## 例子:
 * 无
 * ## 思路:
 * 在所有字母中查找字母
 * ## 成绩:
 * - 执行用时：ms, 在所有 Kotlin 提交中击败了%的用户
 * - 内存消耗：MB, 在所有 Kotlin 提交中击败了%的用户
 *
 */

fun main() {
    val hashMap = hashMapOf<String,Int>()
    for ( i in 65..90){
        hashMap[i.toChar().toString()] = i
    }
    println(binarySearch("A",hashMap))
}

private fun binarySearch(key: String, mHashMap: HashMap<String, Int>): Int {
    val list = mHashMap.toList()
    var x = 0
    var y = list.size - 1
    while (x <= y) {
        val mid = x + (y - x) / 2
        if (list[mid].first.toCharArray()[0].code == key.toCharArray()[0].code) {
            return list[mid].second
        } else if (list[mid].first.toCharArray()[0].code < key.toCharArray()[0].code) {
            x = mid + 1
        } else {
            y = mid
        }
    }
    return 0
}