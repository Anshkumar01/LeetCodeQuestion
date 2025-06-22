import java.util.*;

class Solution {
    public List<String> divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int end = Math.min(i + k, s.length());
            String part = s.substring(i, end);
            if (part.length() < k) {
                StringBuilder sb = new StringBuilder(part);
                while (sb.length() < k) {
                    sb.append(fill);
                }
                part = sb.toString();
            }
            result.add(part);
            i += k;
        }
        return result;
    }
}