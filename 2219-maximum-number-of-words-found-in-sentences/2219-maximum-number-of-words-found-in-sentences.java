class Solution {
    public int mostWordsFound(String[] sentences) {
      int maxWord = 0;
      for(int i=0;i<sentences.length;i++){
        String[] len = sentences[i].split(" ");
        if(len.length > maxWord){
            maxWord = len.length;
        }
      }  
      return maxWord;
    }
}