class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val visited = mutableSetOf<Int>()
        val adj = mutableMapOf<Int, MutableList<Int>>()
        edges.forEach {
            val s = it[0]
            val d = it[1]
            adj.getOrPut(s){mutableListOf()}.add(d)
            adj.getOrPut(d){mutableListOf()}.add(s)
        }
        
        if (!dfs(0,-1, visited, adj)) return false

        return visited.size == n
    }

    fun dfs(node: Int,parent: Int, visited: MutableSet<Int>, adj: Map<Int, List<Int>>) : Boolean {
        if (visited.contains(node)) return false

        visited.add(node)
        adj[node]?.forEach {
            if (it==parent) return@forEach 
            if (!dfs(it, node, visited, adj)) return false
        }

        return true
    }
}
