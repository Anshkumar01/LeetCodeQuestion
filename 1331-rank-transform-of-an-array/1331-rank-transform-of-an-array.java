class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans = arr.clone();
        Arrays.sort(arr);
        Map<Integer, Integer> ranks = new HashMap<>();
        for(int i : arr){
            ranks.putIfAbsent(i, ranks.size()+1);
        }
        for(int i=0; i<ans.length; i++){
            ans[i] = ranks.get(ans[i]);
        }
        return ans; 

        
    }
}