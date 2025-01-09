class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        int prefLen = pref.length();
        for (String word : words) {
            if (word.length() >= prefLen) {
                if (word.substring(0, prefLen).equals(pref)) {
                    count++;
                }
            }
        }
        return count;
    }
}