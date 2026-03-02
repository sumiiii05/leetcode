class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        int L = beginWord.length();
        Map<String, List<String>> adj = new HashMap<>();
        for (String word : dict) {
            for (int i = 0; i < L; i++) {
                String generic = word.substring(0, i) + "*" + word.substring(i+1);
                adj.computeIfAbsent(generic, k -> new ArrayList<>()).add(word);
            }
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Map<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 1);
        while (!q.isEmpty()) {
            String word = q.poll();
            int steps = dist.get(word);
            for (int i = 0; i < L; i++) {
                String generic = word.substring(0, i) + "*" + word.substring(i+1);
                for (String nei : adj.getOrDefault(generic, new ArrayList<>())) {
                    if (nei.equals(endWord)) return steps + 1;
                    if (!dist.containsKey(nei)) {
                        dist.put(nei, steps + 1);
                        q.add(nei);
                    }
                }
            }
        }
        return 0;
    }
}