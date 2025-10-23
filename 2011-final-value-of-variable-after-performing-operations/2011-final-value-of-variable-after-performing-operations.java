class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;  // Initial value
        
        for (String operation : operations) {
            // Check if operation is increment (contains "++")
            if (operation.contains("++")) {
                x++;
            } 
            // Otherwise it's decrement (contains "--")
            else {
                x--;
            }
        }
        
        return x;
    }
}