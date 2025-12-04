class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0;
        int right = n-1;

        while ( left < n && directions.charAt(left) == 'L'){
            left++;
        }
        while ( right >= 0 && directions.charAt(right) == 'R'){
            right--;
        }
        int totalMid = right-left+1;
        if(totalMid <= 0){
            return 0;
        }
        int stat = 0;
        for(int i=left; i<=right;i++){
            if(directions.charAt(i)=='S'){
                stat++;
            }
        }
        return totalMid - stat;
    }
}