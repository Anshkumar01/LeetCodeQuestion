class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder r = new StringBuilder();
        int st=0;
        for(int sp:spaces){
            r.append(s,st,sp).append(" ");
            st=sp;
        }
        r.append(s.substring(st));
        return r.toString();
        
    }
}