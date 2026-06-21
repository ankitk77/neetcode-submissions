/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val intervals = intervals.sortedWith{ a, b -> a.start - b.start }
        val qu = PriorityQueue<Int>()
        for (intr in intervals) {
            if (qu.isNotEmpty() && intr.start>=qu.peek()) {
                qu.remove()
            }
            qu.add(intr.end)
        }

        return qu.size
    }
}
