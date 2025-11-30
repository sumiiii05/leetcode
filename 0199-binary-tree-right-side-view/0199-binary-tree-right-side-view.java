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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> rv= new ArrayList<>();
        if(root==null){
            return rv;
        }
        ArrayList<TreeNode> q= new ArrayList<>();
        q.add(root);

        while(!q.isEmpty()){
            rv.add(q.get(q.size()-1).val);
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.remove(0);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }
        return rv;
    }
}