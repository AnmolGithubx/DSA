/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        q.add(root);
        
        if(root == null){
            return ans;
        }

        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0;i<sz;i++){
                TreeNode x = q.poll();
                level.add(x.val);
                if(x.left != null) q.add(x.left);
                if(x.right != null) q.add(x.right);
            }
            ans.add(0,level);
        }
        return ans;
    }
}