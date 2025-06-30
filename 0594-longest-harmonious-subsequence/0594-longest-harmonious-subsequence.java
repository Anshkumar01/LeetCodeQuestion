class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0)+1);

        }

        int maxi = 0;

        for(int key: mp.keySet()){
            if(mp.containsKey(key+1)){
                int freq = mp.get(key) + mp.get(key+1);
                maxi = Math.max(freq, maxi);
            }
        }
        return maxi;
    }
}