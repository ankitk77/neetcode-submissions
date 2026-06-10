class Solution {
    private val dirs = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val qu = ArrayDeque<Data>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    qu.addLast(Data(i, j, 0))
                }
            }
        }

        while(qu.isNotEmpty()) {
            repeat(qu.size) {
                val (i, j, d) = qu.removeFirst()
                dirs.forEach { (x, y) ->
                    val ni = x+i
                    val nj = y+j
                    val nd = d+1
                    if (ni in grid.indices && nj in grid[0].indices && grid[ni][nj] > nd) {
                        grid[ni][nj] = nd
                        qu.addLast(Data(ni,nj,nd))
                    }
                }
            }
        }
    }

    data class Data(val i: Int, val j: Int, val dis: Int)
}
