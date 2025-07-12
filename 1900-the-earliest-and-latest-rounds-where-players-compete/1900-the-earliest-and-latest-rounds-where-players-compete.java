class Solution {
    public int[] earliestAndLatest(int n, int fp, int sp) {

        int left = Math.min(fp, sp);
        int right = Math.max(fp, sp);

        if(left+right==n+1){
            return new int[] {1,1};
        }
        if(n==3||n==4){
            return new int[] {2,2};
        }
        if(left-1>n-right){
            int temp = n+1-left;
            left = n+1 - right;
            right = temp;
        }

        int nr = (n+1)/2;
        int mir = n;
        int mar = 1;

        if(right * 2 <= n+1){
            int pl = left-1;
            int mg = right-left-1;
            for(int i=0; i<=pl; i++){
                for(int j =0;j<= mg; j++){
                    int[] res = earliestAndLatest(nr,i+1,i+j+2);
                    mir = Math.min(mir,1+res[0]);
                    mar = Math.max(mar,1+res[1]);
                }
            }
        }else{
            int mrr = n+1-right;
            int pl = left-1;
            int mg = mrr-left-1;
            int inn = right-mrr-1;
            for(int i=0; i<= pl; i++){
                for(int j=0; j<= mg; j++){
                    int[] res = earliestAndLatest(nr, i + 1, i + j + 1 + (inn + 1) / 2 + 1);
                    mir = Math.min(mir, 1+res[0]);
                    mar = Math.max(mar, 1+res[1]);

                }
            }
        }
        return new int[] {mir, mar};
        
    }
}