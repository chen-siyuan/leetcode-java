public class Solution {

    public Node connect(Node node) {
    
        if(node == null) return null;
    
        if(node.left != null && node.right != null) node.left.next = node.right;

        Node left = null;
        if(node.left != null || node.right != null) left = node.right == null ? node.left : node.right;
 
        if(left != null && node.next != null) {
            
            Node temp = node.next;
            
            while(temp.next != null && temp.left == null && temp.right == null) temp = temp.next;

            if(temp.left != null || temp.right != null) left.next = temp.left != null ? temp.left : temp.right;
        
        }

        connect(node.right);
        connect(node.left);

        return node;
    }

}
