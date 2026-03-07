/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int bottomUp(TreeNode root,TreeNode target, int k,HashMap<TreeNode,Integer>map){
        if(root==null)return Integer.MAX_VALUE;
        if(root==target){
            map.put(root,0);
            return 0;
        }
        int dist=Math.min(bottomUp(root.left,target,k,map),bottomUp(root.right,target,k,map));
        if(dist!=Integer.MAX_VALUE){
            map.put(root,dist+1);
            return dist+1;
        }
        return Integer.MAX_VALUE;
    }
    public void topDown(TreeNode root,int k,HashMap<TreeNode,Integer>map,int dist,List<Integer>ans){
        if(root==null)return;
        if(!map.containsKey(root)){
            map.put(root,dist);
            if(dist==k)ans.add(root.val);
        }else if(map.get(root)==k){
            ans.add(root.val);
        }
        topDown(root.left,k,map,map.get(root)+1,ans);
        topDown(root.right,k,map,map.get(root)+1,ans);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>ans=new ArrayList<>();
        if(root==null)return ans;
        HashMap<TreeNode,Integer>map=new HashMap<>();
        bottomUp(root,target,k,map);
        int distRoot=map.get(root);
        topDown(root,k,map,distRoot,ans);
        return ans;
    }
}