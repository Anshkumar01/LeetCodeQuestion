class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        int blocks = (n+63)/64;
        long[][] masks = new long[m+1][blocks];
        
        for (int i = 0; i < m; i++) {
            for (int lang : languages[i]) {
                int idx = (lang-1)/64, bit = (lang-1)%64;
                masks[i+1][idx] |= (1L<<bit);
            }
        }
        
        HashSet<Integer> candidates = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0], v = f[1];
            boolean canTalk = false;
            for (int b = 0; b < blocks; b++) {
                if ((masks[u][b] & masks[v][b]) != 0) { canTalk = true; break; }
            }
            if (!canTalk) { candidates.add(u); candidates.add(v); }
        }
        if (candidates.isEmpty()) return 0;
        
        int[] count = new int[n+1];
        for (int u : candidates) {
            for (int lang = 1; lang <= n; lang++) {
                int idx = (lang-1)/64, bit = (lang-1)%64;
                if ((masks[u][idx] & (1L<<bit)) != 0) count[lang]++;
            }
        }
        
        int maxOverlap = 0;
        for (int lang = 1; lang <= n; lang++) maxOverlap = Math.max(maxOverlap,count[lang]);
        return candidates.size() - maxOverlap;
    }
}