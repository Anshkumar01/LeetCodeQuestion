class Solution {
    public char kthCharacter(long k, int[] operations) {
        k -= 1; // Convert to 0-based
        int res = 0;

        for (int i = 0; i < operations.length && i < 60; ++i) {
            // Check if bit at position i in k is 1 (affects this level of expansion)
            if (((k >> i) & 1) == 1) {
                res += operations[i];
            }
        }

        // Final character is 'a' + number of shifts (mod 26)
        return (char)('a' + res % 26);
    }
}