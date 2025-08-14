class Solution {
    public String largestGoodInteger(String num) {
        String maxGoodInteger = "";
        int n = num.length();
        if(n<3){
            return "";
        }

        for(int i=0;i<=n-3;i++){
            char char1 = num.charAt(i);
            char char2 = num.charAt(i + 1);
            char char3 = num.charAt(i + 2);

            if (char1 == char2 && char2 == char3){
                String currentGoodInteger = num.substring(i, i + 3);
                if (currentGoodInteger.compareTo(maxGoodInteger) > 0) {
                    maxGoodInteger = currentGoodInteger;
                }
            }
        }
        return maxGoodInteger;
    }
}