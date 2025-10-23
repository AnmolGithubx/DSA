class Solution {
    public String removeDigit(String number, char digit) {
        if(number.length() == 0) return number;

        String max="";
        for(int i=0;i<number.length();i++){
            if(number.charAt(i)==digit){
                String del = number.substring(0,i)+number.substring(i+1);
                if(del.compareTo(max)>0){
                    max=del;
                }
            }
        }
        return max;
    }
}