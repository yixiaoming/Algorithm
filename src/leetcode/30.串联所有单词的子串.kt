/*
 * @lc app=leetcode.cn id=30 lang=kotlin
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        var result = mutableListOf<Int>()
        if (s.isEmpty() || words.isEmpty()) return result
        var wordLen = words[0].length
        var allLen = wordLen * words.size
        for (from in 0..(s.length - allLen)) {
            var substr = s.substring(from, from + allLen)
            var substrSet = mutableListOf<String>()
            var fromIndex = 0
            while (fromIndex + wordLen <= allLen) {
                substrSet.add(substr.substring(fromIndex, fromIndex + wordLen))
                fromIndex += wordLen
            }
            var tempList = words.toMutableList()
            while (tempList.size > 0) {
                if (substrSet.contains(tempList[0])) {
                    substrSet.remove(tempList[0])
                    tempList.removeAt(0)
                } else{
                    break
                }
            }
            if (tempList.size == 0 && substrSet.size == 0) {
                result.add(from)
            }
        }
        return result
    }
}
// @lc code=end

