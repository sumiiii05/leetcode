class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        int maxCount = 0;

        for (int i = 0; i + minSize <= s.length(); i++) {

            String sub = s.substring(i, i + minSize);

            if (countUnique(sub) <= maxLetters) {
                freqMap.put(sub, freqMap.getOrDefault(sub, 0) + 1);
                maxCount = Math.max(maxCount, freqMap.get(sub));
            }
        }
        return maxCount;
    }

    private int countUnique(String str) {
        boolean[] seen = new boolean[26];
        int count = 0;

        for (char c : str.toCharArray()) {
            if (!seen[c - 'a']) {
                seen[c - 'a'] = true;
                count++;
            }
        }
        return count;
    }
}