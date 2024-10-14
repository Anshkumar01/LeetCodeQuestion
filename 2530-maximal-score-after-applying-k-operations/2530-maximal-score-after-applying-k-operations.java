class Solution {
    public long maxKelements(int[] nums, int k) {
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all elements to the max-heap
        for (int num : nums) {
            maxHeap.offer(num);
        }

        long score = 0;

        // Perform k operations
        while (k-- > 0) {
            // Extract the largest element
            int largest = maxHeap.poll();
            score += largest;

            // Replace the element with ceil(largest / 3)
            maxHeap.offer((largest + 2) / 3); // (x + 2) / 3 is equivalent to ceil(x / 3)
        }

        return score;

    }
}