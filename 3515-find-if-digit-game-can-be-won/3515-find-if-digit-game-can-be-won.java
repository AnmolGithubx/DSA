class Solution {
    public boolean canAliceWin(int[] nums) {
        int sumSmallNumbers = 0; 
        int sumLargeNumbers = 0; 
        // taking diff variable for each small and large number

        for (int number : nums) {

            if (number < 10) {
                sumSmallNumbers += number; 
            } else {
                sumLargeNumbers += number;
            }
        }
        return sumSmallNumbers != sumLargeNumbers;
    }

}
