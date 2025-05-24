class Solution 
{
    public List<Integer> findWordsContaining(String[] words, char x) 
    {
        // Step 1: Create result list
        List<Integer> result = new ArrayList<>();
        
        // Step 2: Loop through each word
        for (int i = 0; i < words.length; i++) 
        {
            // Step 3: Check if current word contains character x
            if (words[i].indexOf(x) != -1) 
            {
                // Step 4: If yes, add index to result list
                result.add(i);
            }
        }

        // Step 5: Return the result list
        return result;
    }
}