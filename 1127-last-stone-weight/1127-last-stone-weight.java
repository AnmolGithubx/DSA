import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {

        ArrayList<Integer> stoneList = new ArrayList<>();
        for (int stone : stones) {
            stoneList.add(stone);
        }

        while (stoneList.size() > 1) {
            Collections.sort(stoneList, Collections.reverseOrder());

            int y = stoneList.get(0);
            int x = stoneList.get(1); 

            stoneList.remove(0);
            stoneList.remove(0);

            if (y != x) {
                stoneList.add(y - x);
            }
        }

        return stoneList.isEmpty() ? 0 : stoneList.get(0);
    }
}
