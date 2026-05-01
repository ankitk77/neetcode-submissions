class Solution {

    fun encode(strs: List<String>): String {
        val result = StringBuilder("")
        strs.forEach {
            result.append("${it.length}#$it")
        }
        return result.toString()
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()

        var i = 0
        while(i < str.length) {
            var stepsInString = ""
            while(str[i] != '#') {
                stepsInString += str[i++]
            }
            val steps = stepsInString.toInt()
            
            val word = StringBuilder("")
            repeat(steps) {
                word.append(str[++i])
            }
            result.add(word.toString())
            i++
        }
        return result
    }
}
