class Solution {
    static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long evenCnt = (n + 1) / 2;
        long oddCnt = n / 2;

        long evenW = modPow(5, evenCnt, MOD);
        long oddW = modPow(4, oddCnt, MOD);

        return (int)((evenW * oddW) % MOD);
    }

    // divide and conquer
    private long modPow(long base, long exp, int mod){
        if(exp == 0) return 1;
        long half = modPow(base, exp / 2, mod);
        long result = (half * half) % mod;
        if(exp % 2 == 1) result = (result * base) % mod;
        return result;
    }
}