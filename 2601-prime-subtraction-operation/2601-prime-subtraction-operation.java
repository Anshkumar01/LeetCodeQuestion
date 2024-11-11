class Solution {
    public boolean primeSubOperation(int[] nums) {
        fillFloorPrime();
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            // Either this condition
            if (i > 0 && nums[i] <= nums[i-1]) { 
                return false;
            }
            int diff = nums[i] - prev - 1;
            // Or this condition
            // if (diff < 0) {
            //     return false;
            // }
            prev = nums[i] -= getFloorPrime[diff];
        }

        return true;
    }
    
    int[] getFloorPrime = new int[1001];
    private void fillFloorPrime() {
        int prev = 0;
        for (int i = 2; i < getFloorPrime.length; i++) {
            if (isPrime(i)) {
                getFloorPrime[i] = i;
                prev = i;
            } else {
                getFloorPrime[i] = prev;
            }
        }
    }
    
    private boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}