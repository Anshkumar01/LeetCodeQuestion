class Solution {
    public int minimumLength(String s) {
        int n = s.length(), del = 0;
        Map<Character, Integer> mp = new HashMap<>();

        // Count the frequency of each character
        for (int i = 0; i < n; i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Calculate the number of characters to be removed
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            int f = entry.getValue();
            del += (f % 2 == 1) ? f - 1 : f - 2;
        }

        return n - del;
    }
}