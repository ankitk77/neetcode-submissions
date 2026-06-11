class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val adj = mutableMapOf<Int, MutableList<Int>>()
        edges.forEach {
            adj.getOrPut(it[0]){mutableListOf()}.add(it[1])
            adj.getOrPut(it[1]){mutableListOf()}.add(it[0])
        }
        val visited = mutableSetOf<Int>()
        var ans = 0

        fun dfs(node: Int, par: Int) {
            if (visited.contains(node)) return
            visited.add(node)
            adj[node]?.forEach {
                if (it!=par) {
                    dfs(it, node)
                }
            }
        }

        for (i in 0 until n) {
            if (visited.contains(i).not()) {
                dfs(i,-1)
                ans++
            }
        }

        return ans
    }
}
