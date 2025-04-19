class Solution 
{
    public long countFairPairs(int[] v, int lower, int upper) 
    {
        // Step 1: Sort the array
        Arrays.sort(v);
        long ans = 0;

        // Step 2: Loop through each element and count valid pairs
        for (int i = 0; i < v.length - 1; i++) 
        {
            int low = lowerBound(v, i + 1, v.length, lower - v[i]);  // Step 2.1
            int up = upperBound(v, i + 1, v.length, upper - v[i]);   // Step 2.2
            ans += up - low; // Step 2.3
        }

        // Step 3: Return result
        return ans;
    }

    // Binary search for lower bound
    private int lowerBound(int[] v, int start, int end, int target) 
    {
        while (start < end) 
        {
            int mid = start + (end - start) / 2;
            if (v[mid] >= target)
            {
                end = mid;
            } 
            else start = mid + 1;
        }
        return start;
    }

    // Binary search for upper bound
    private int upperBound(int[] v, int start, int end, int target) 
    {
        while (start < end) 
        {
            int mid = start + (end - start) / 2;
            if (v[mid] > target)
            {
                end = mid;
            } 
            else start = mid + 1;
        }
        return start;
    }
}