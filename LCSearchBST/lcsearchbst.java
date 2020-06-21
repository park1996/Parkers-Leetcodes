public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LCSearchBST{
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        TreeNode currentNode = root;
        while(currentNode != null && currentNode.val != val){
            if(currentNode == null){
                return null;
            }
            else if(currentNode.val < val){
                currentNode = currentNode.left;
            }
            else if(currentNode.val > val){
                currentNode = currentNode.right;
            }
            else if(currentNode.val == val){
                return currentNode;
            }
        }
        
        return currentNode;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)), new TreeNode(7, null, null));
        searchBST(root, 2);
    }
}