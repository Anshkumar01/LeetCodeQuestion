class Solution {
    public int maximumSwap(int num) {
        // hashmap will hold right most indecies of each value
        HashMap<Integer, Integer> rightMost = new HashMap<>();
        StringBuilder s = new StringBuilder(String.valueOf(num));
        // place the right most indecies in our map
        for(int i = 0; i < s.length(); i++) {
            rightMost.put(Character.getNumericValue(s.charAt(i)), i);
        }
        // left is the pointer to where we are in our input parameter
        int left = 0;
        while(left < s.length()) {
            int leftval = Character.getNumericValue(s.charAt(left));
            int index = 9;
            // find the right most value present that is larger then the given value
            while(index > leftval) {
                // if found, swap the values
                if(rightMost.containsKey(index) && rightMost.get(index) > left) {
                    s.setCharAt(left, (char)(index + '0'));
                    s.setCharAt(rightMost.get(index), (char)(leftval + '0'));
                    return Integer.valueOf(s.toString());
                }
                index--;
            }
            left++;
        }

        return num;
    }
}