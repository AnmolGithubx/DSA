class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalapples = 0;
        for(int a : apple){
            totalapples += a;
        }
        Arrays.sort(capacity);
        int boxesused = 0;
        int currentcapacity = 0;

        for(int i=capacity.length-1; i>=0 ;i--){
            currentcapacity += capacity[i];
            boxesused++;
            if(currentcapacity >= totalapples){
                return boxesused;
            }
        }
        return boxesused;
    }
}