import java.util.function.Consumer;

public class treeExamples {

	
	public static void main(String... args) {
		treeExamples();
		
	}
	  static void preOrder(Node node) {
	        if (node == null) {
	            return;
	        } else {
	            System.out.print(node.getValue() + " ");
	            preOrder(node.left());
	            preOrder(node.right());
	        }
	    }

	    static void inOrder(Node node) {
	        if (node == null) {
	            return;
	        } else {
	            inOrder(node.left());
	            System.out.print(node.getValue() + " ");
	            inOrder(node.right());
	        }
	    }

	    static void postOrder(Node node) {
	        if (node != null) {
	            postOrder(node.left());
	            postOrder(node.right());
	            System.out.print(node.getValue() + " ");
	        }
	    }

	    static Consumer<Node> inorder; // Instance variable

	    static void recursiveLambdaExpressions() {

	        inorder = (Node node) -> {
	            if (node == null) {
	                return;
	            } else {
	                inorder.accept(node.left());
	                System.out.print(node.getValue() + " ");
	                inorder.accept(node.right());
	            }
	        };
	        Node root = new Node(12);
	        root.addLeft(8).addRight(9);
	        root.addRight(18).addLeft(14).addRight(17);
	        inorder.accept(root);
	    }

	    static void treeExamples() {
	        Node root = new Node(12);
	        root.addLeft(8).addRight(9);
	        root.addRight(18).addLeft(14).addRight(17);
	        System.out.println("Preorder traversal -----------------");
	        preOrder(root);
	        System.out.println();
	        System.out.println("Inorder traversal -----------------");
	        inOrder(root);
	        System.out.println();
	        System.out.println("Postoder traversal -----------------");
	        postOrder(root);
	        System.out.println();
	    }
}
