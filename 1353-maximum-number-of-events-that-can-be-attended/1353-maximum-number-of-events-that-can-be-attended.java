class Solution {
    public int maxEvents(int[][] item) {
        Arrays.sort(item, (a, b) -> Integer.compare(a[0], b[0]));
        int n = item.length;
        int ans = 0;

        int mx_day = 0;
        for (int[] val : item) {
            mx_day = Math.max(mx_day, val[1]);
        }

        PriorityQueue<Integer> kitchen = new PriorityQueue<>();
        int process = 0, day = 1;

        while (day <= mx_day) {
            // put new items according to list, available today
            while (process < n && item[process][0] <= day) {
                // storing their expiring date
                kitchen.offer(item[process][1]);

                // move to next item to be process
                process++;
            }

            // remove all the expired item
            while (!kitchen.isEmpty() && kitchen.peek() < day) {
                kitchen.poll();
            }

            // take one item which will expire earliest
            if (!kitchen.isEmpty()) {
                kitchen.poll();
                ans++;
            }

            day++;
        }

        return ans;
    }
}