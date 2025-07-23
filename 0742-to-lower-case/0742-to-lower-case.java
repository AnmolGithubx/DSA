class Solution {
    public String toLowerCase(String s) {
        // return s.toLowerCase();

        // char[] c = s.toCharArray();
        // for(int i=0;i<c.length;i++){
        //     if(c[i]>=65 && c[i]<=90){
        //         c[i] = (char) (c[i]+32);
        //     }
        // }
        // return String.valueOf(c);

        String result = "";
        for(int i=0;i<s.length();i++){
            if('A' <= s.charAt(i) && s.charAt(i) <= 'Z'){
                result += (char) (s.charAt(i) + 32);
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }
}