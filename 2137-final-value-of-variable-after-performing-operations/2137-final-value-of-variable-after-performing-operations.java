class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int count = 0;

        for(String c : operations){
            if(c.equals("--X") || c.equals("X--")){
                count--;
            } else if(c.equals("++X") || c.equals("X++")){
                count++;
            }
        }
        return count;
    }
}