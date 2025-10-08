
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;
        int max = 0;
        int[] res = new int[m];
        for(int i=0; i<n; i++){
            max = Math.max(max, potions[i]);
        }
        int[] map = new int[max+1];
        for(int i=0; i<n; i++){
            map[potions[i]]++;
        }
        int sum = 0;
        for(int i=max; i>=0; i--){
            sum+=map[i];
            map[i] = sum;
        }
        for(int i=0; i<m; i++){
            int spell = spells[i];
            long index = (success + spell -1)/spell;
            if(index <= max){
                res[i] = map[(int) index];
            } 
        }
        return res;
    }
}