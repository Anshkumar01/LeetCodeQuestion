class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int m = Arrays.stream(candies).max().getAsInt();
        List<Boolean> r = new ArrayList<>();

        for(int candy:candies){
            r.add(candy+extraCandies>=m);
        }
        return r;
    }
}