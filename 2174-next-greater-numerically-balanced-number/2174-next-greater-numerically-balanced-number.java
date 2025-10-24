class Solution {
    public int nextBeautifulNumber(int n) {
        int num = n+1;
        while(true){
            if(isBalanced(num)) return num;
            num++;
        }
    }
    private boolean isBalanced(int num){
        String s = Integer.toString(num);
        int[] count = new int[10];

        for(char c : s.toCharArray()){
            count[c-'0']++;
        }
        for(char c : s.toCharArray()){
            int digit = c-'0';
            if(count[digit] != digit){
                return false;
            }
        }
        return true;
    }
}