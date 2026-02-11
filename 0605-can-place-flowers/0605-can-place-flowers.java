class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;
        for(int i=0; i<len; i++){
            if(flowerbed[i] ==0){
                boolean l_empty = (i==0) || (flowerbed[i-1]==0);
                boolean r_empty = (i== len-1) ||(flowerbed[i+1]==0);

                if(l_empty && r_empty){
                    flowerbed[i] = 1;
                    count++;
                    if(count >= n){
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }
}