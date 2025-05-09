import java.util.*;

public class Solution {
    static final int MOD = 1_000_000_007;
    int[] fact, inv, invFact;

    void precompute(int n) {
        fact = new int[n + 1];
        inv = new int[n + 1];
        invFact = new int[n + 1];
        fact[0] = inv[0] = invFact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (int) ((1L * fact[i - 1] * i) % MOD);
        }

        inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            inv[i] = MOD - (int) ((1L * (MOD / i) * inv[MOD % i]) % MOD);
        }

        for (int i = 1; i <= n; i++) {
            invFact[i] = (int) ((1L * invFact[i - 1] * inv[i]) % MOD);
        }
    }

    public int countBalancedPermutations(String num) {
        int n = num.length();
        int sum = 0;
        for (char c : num.toCharArray()) {
            sum += c - '0';
        }
        if (sum % 2 == 1) return 0;

        precompute(n);
        int halfSum = sum / 2;
        int halfLen = n / 2;

        int[][] dp = new int[halfSum + 1][halfLen + 1];
        dp[0][0] = 1;

        int[] digits = new int[10];

        for (int i = 0; i < n; i++) {
            int d = num.charAt(i) - '0';
            digits[d]++;
            for (int s = halfSum; s >= d; s--) {
                for (int l = halfLen; l >= 1; l--) {
                    dp[s][l] = (dp[s][l] + dp[s - d][l - 1]) % MOD;
                }
            }
        }

        int res = dp[halfSum][halfLen];
        res = (int) (((1L * res * fact[halfLen]) % MOD * fact[n - halfLen]) % MOD);

        for (int cnt : digits) {
            res = (int) ((1L * res * invFact[cnt]) % MOD);
        }

        return res;
    }
}