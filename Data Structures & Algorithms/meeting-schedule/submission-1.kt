/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        val intervals = intervals.sortedWith { a, b -> a.start - b.start }
        // println(intervals.map{"${it.start}:${it.end}"})
        
        for (i in 1 .. intervals.lastIndex) {
            val prev = intervals[i-1]
            val curr = intervals[i]
            if (curr.start<prev.end) {
                return false
            }
        }

        return true
    }
}
