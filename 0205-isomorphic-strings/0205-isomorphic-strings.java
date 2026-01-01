class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] ls = new int[256];
        int[] lt = new int[256];

        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(ls[c1] != lt[c2]){
                return false;
            }
            ls[c1]=i+1;
            lt[c2]=i+1;
        }
        return true;
    }
}