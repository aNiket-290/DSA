class Solution {

    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                List<Integer> component = new ArrayList<>();

                dfs(i, graph, visited, component);

                int vertices = component.size();
                int degreeSum = 0;

                for (int node : component) {
                    degreeSum += graph.get(node).size();
                }

                int edgesInComponent = degreeSum / 2;
                int requiredEdges = vertices * (vertices - 1) / 2;

                if (edgesInComponent == requiredEdges) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private void dfs(int node, List<List<Integer>> graph,
                     boolean[] visited, List<Integer> component) {

        visited[node] = true;
        component.add(node);

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }
}