class Solution {
    public int maxValue(int[][] events, int limit) {
        int len = events.length;
        int[][] dp = new int[len + 1][limit + 1];

        if (limit == 1) {
            int max = 0;
            for (int[] e : events) {
                max = Math.max(max, e[2]);
            }
            
            return max;
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = len - 1; i >= 0; i--) {
            int left = i + 1;
            int right = len;
            int end = events[i][1];
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (events[mid][0] > end) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int nxt = left;

            for (int j = limit - 1; j >= 0; j--) {
                dp[i][j] = Math.max(
                        dp[i + 1][j],
                        dp[nxt][j + 1] + events[i][2]);
            }
        }

        return dp[0][0];
    }
}