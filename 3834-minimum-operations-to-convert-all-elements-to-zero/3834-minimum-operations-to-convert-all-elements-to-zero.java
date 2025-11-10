import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); 

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
            if (stack.peek() < num) {
                ans++;
                stack.push(num);
            }
        }

        return ans;
    }
}