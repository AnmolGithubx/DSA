class Solution {
    public String reverseWords(String s) {
      StringBuilder sb = new StringBuilder(s).reverse(); 
      reverseWords(sb, sb.length());                     
      return cleanSpaces(sb, sb.length());               
    }
  
    private void reverseWords(StringBuilder sb, int n) {
      int i = 0;
      int j = 0;
  
      while (i < n) {
        while (i < j || i < n && sb.charAt(i) == ' ') 
          ++i;
        while (j < i || j < n && sb.charAt(j) != ' ') 
          ++j;
        reverse(sb, i, j - 1); 
      }
    }
  
   
    private String cleanSpaces(StringBuilder sb, int n) {
      int i = 0;
      int j = 0;
  
      while (j < n) {
        while (j < n && sb.charAt(j) == ' ') 
          ++j;
        while (j < n && sb.charAt(j) != ' ') 
          sb.setCharAt(i++, sb.charAt(j++));
        while (j < n && sb.charAt(j) == ' ')
          ++j;
        if (j < n) 
          sb.setCharAt(i++, ' ');
      }
  
      return sb.substring(0, i).toString();
    }
  
    private void reverse(StringBuilder sb, int l, int r) {
      while (l < r) {
        final char temp = sb.charAt(l);
        sb.setCharAt(l++, sb.charAt(r));
        sb.setCharAt(r--, temp);
      }
    }
  }