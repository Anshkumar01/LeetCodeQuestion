class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Count the frequency of each character in s1
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Sliding window to check the rest of s2
        for (int i = s1.length(); i < s2.length(); i++) {
            if (matches(s1Count, s2Count)) return true;
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - s1.length()) - 'a']--;
        }

        return matches(s1Count, s2Count);
    }

    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }
}