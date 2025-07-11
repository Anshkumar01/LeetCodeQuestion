class Solution 
{
    public int mostBooked(int n, int[][] meetings) 
    {
        // Step 1: Sort meetings by start time
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // Step 2: Min-heap of available rooms (by room number)
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
        {
            freeRooms.offer(i);
        } 

        // Step 3: Min-heap of busy rooms [end time, room id]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0])
                                   : Long.compare(a[1], b[1])
        );

        // Step 4: Count meetings handled per room
        int[] count = new int[n]; 

        // Step 5: Process each meeting
        for (var mt : meetings) 
        {
            long start = mt[0];
            long end = mt[1];
            long duration = end - start;

            // Free up rooms that are done before this meeting starts
            while (!busy.isEmpty() && busy.peek()[0] <= start) 
            {
                freeRooms.offer((int)busy.poll()[1]);
            }

            if (!freeRooms.isEmpty()) 
            {
                // Assign to lowest-numbered available room
                int room = freeRooms.poll();
                count[room]++;
                busy.offer(new long[]{end, room});
            } 
            else 
            {
                // Delay meeting until the earliest room becomes free
                long[] earliest = busy.poll();
                int room = (int)earliest[1];
                count[room]++;
                busy.offer(new long[]{earliest[0] + duration, room});
            }
        }

        // Step 6: Return room with most meetings (tie-breaker: smallest index)
        int ans = 0;
        for (int i = 1; i < n; i++) 
        {
            if (count[i] > count[ans])
            {
                ans = i;
            } 
        }

        return ans;
    }
}