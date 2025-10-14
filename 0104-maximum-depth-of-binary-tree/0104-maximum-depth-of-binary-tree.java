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

import java.util.*;
class Solution {
    public int maxDepth(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> a=new ArrayList<>();

        if(root==null) return a.size();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> at=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode x=q.poll();
                at.add(x.val);
                if(x.left!=null) q.add(x.left);
                if(x.right!=null) q.add(x.right);
            }
            ans.add(at);
        }
       for(int i=0;i<ans.size();i++){
           a.add(ans.get(i).get(0));
       }
       return a.size();
    }
}