class Solution {
    public int maximum69Number (int num) {
        String numStr = Integer.toString(num);

        for(int i=0;i<numStr.length();i++){
            if(numStr.charAt(i)=='6'){
                String newNumStr = numStr.substring(0,i)+'9'+numStr.substring(i+1);
                return Integer.parseInt(newNumStr);
            }
        }
        return num;
    }
}