import java.util.ArrayDeque;
import java.util.Deque;

public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
//        TreeNode n1 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n6.right = n9;
        System.out.println(hasPathSum1(n1,22));

    }

    //solution 1: DFA traversal
    public static boolean hasPathSum1(TreeNode root, int sum) {
        boolean[] found = new boolean[1];
        DFS(root,0,sum,found);
        return found[0];
    }

    public static void DFS(TreeNode node, int partSum, int sum, boolean[] found){
        if(found[0])
            return;
        if(node == null)
            return;
        partSum += node.val;
        if(partSum == sum && node.left == null && node.right == null){
            found[0] = true;
        } else if ( partSum < sum){
            DFS(node.left, partSum, sum, found);
            DFS(node.right, partSum, sum, found);
        }

    }

    //solution2:  Iteration
    public static boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null)
            return false;
        Deque<TreeNode> node = new ArrayDeque<>();
        Deque<Integer> value = new ArrayDeque<>();
        node.push(root);
        value.push(root.val);
        while(!node.isEmpty()){
            TreeNode current = node.poll();
            int partSum = value.poll();
            if(current.left != null){
                node.push(current.left);
                value.push(partSum + current.left.val);
            }
            if(current.right != null){
                node.push(current.right);
                value.push(partSum + current.right.val);
            }
            if(current.left == null && current.right == null && partSum == sum)
                return true;
        }
        return false;
    }

    //solution3:  recursion
    public static boolean hasPathSum3(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum3(root.left, sum - root.val) || hasPathSum3(root.right, sum - root.val);
    }


}
