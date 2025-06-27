class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray())
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        List<Character> valid = new ArrayList<>();
        for (char ch : freq.keySet()) {
            if (freq.get(ch) >= k) {
                valid.add(ch);
            }
        }

        valid.sort((a, b) -> Character.compare(b, a)); // descending lex

        Queue<String> queue = new LinkedList<>();
        queue.add("");
        String answer = "";

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (char ch : valid) {
                String next = curr + ch;
                if (isKRepeatedSubsequence(s, next, k)) {
                    if (next.length() > answer.length() || 
                       (next.length() == answer.length() && next.compareTo(answer) > 0)) {
                        answer = next;
                    }
                    queue.add(next);
                }
            }
        }

        return answer;
    }

    private boolean isKRepeatedSubsequence(String s, String sub, int k) {
        String target = sub.repeat(k);
        int j = 0;
        for (char ch : s.toCharArray()) {
            if (j < target.length() && ch == target.charAt(j)) {
                j++;
            }
        }
        return j == target.length();
    }
}