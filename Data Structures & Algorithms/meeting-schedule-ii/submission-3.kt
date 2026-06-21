/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val intervals = intervals.sortedWith{ a, b -> a.start - b.start }
        val rooms = mutableListOf<MutableList<Interval>>()

        intervals.forEach { intr ->
            var isAdded = false
            for (croom in rooms) {
                if (croom.isEmpty() || intr.start>=croom.last().end) {
                    croom.add(intr)
                    isAdded = true
                    break
                }
            }
            if (!isAdded)
                rooms.add(mutableListOf(intr))
        }

        rooms.map{ println(it.map{"${it.start}:${it.end}"}) }

        return rooms.size
    }
}
