class Solution {
    private val dirs = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val qu = ArrayDeque<Data>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    qu.addLast(Data(i, j))
                }
            }
        }

        while(qu.isNotEmpty()) {
            val (i, j) = qu.removeFirst()
            dirs.forEach { (x, y) ->
                val ni = x+i
                val nj = y+j

                if (ni in grid.indices && nj in grid[0].indices && grid[ni][nj] > grid[i][j]+1) {
                    grid[ni][nj] = grid[i][j]+1
                    qu.addLast(Data(ni,nj))
                }
            }
        }
    }

    data class Data(val i: Int, val j: Int)
}
