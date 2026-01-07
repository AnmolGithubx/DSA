class Solution {
    private List<Long> subtreeSums = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        long totalSum = calculateSubtreeSum(root);
        long maxProd = 0;
        
        for (long s : subtreeSums) {
            long currentProd = s * (totalSum - s);
            if (currentProd > maxProd) {
                maxProd = currentProd;
            }
        }
        
        return (int) (maxProd % 1000000007);
    }

    private long calculateSubtreeSum(TreeNode node) {
        if (node == null) return 0;
        
        long currentSum = node.val + calculateSubtreeSum(node.left) + calculateSubtreeSum(node.right);
        subtreeSums.add(currentSum);
        return currentSum;
    }
}