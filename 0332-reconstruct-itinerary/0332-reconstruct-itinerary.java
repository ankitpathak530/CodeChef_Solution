class Solution {
    List<String> result = new ArrayList<>();
    int n = 0;

    public List<String> findItinerary(List<List<String>> tickets) {
        n = tickets.size();
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            List<String> list = graph.getOrDefault(from, new ArrayList<String>());
            list.add(to);
            Collections.sort(list);
            graph.put(from, list);
        }

        dfs(graph, "JFK", new ArrayList<String>());
        return result;
    }



    private boolean dfs(Map<String, List<String>> graph, String from, ArrayList<String> path) {
        path.add(from);

        if (path.size() == n + 1) {
            result = new ArrayList<>(path); // Create a new copy of the path
            return true;
        }

        List<String> nbrs = graph.getOrDefault(from, new ArrayList<>());
        List<String> nbrsCopy = new ArrayList<>(nbrs); // Create a copy of the neighbors

        for (String nbr : nbrsCopy) {
            int indexOfNbr = nbrs.indexOf(nbr);
            nbrs.remove(indexOfNbr);

            if (dfs(graph, nbr, path))
                return true;

            nbrs.add(indexOfNbr, nbr);
        }
    
        path.remove(path.size() - 1); // Backtrack
        return false;
    }
}
