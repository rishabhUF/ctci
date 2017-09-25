package chapter2;

public class BinaryTree {
	class Node{
		int data;
		Node left,right;
		
		public Node(int data)
		{
			this.data = data;
			left=right=null;
		}
	}
	public class BinaryTrees{
		Node root;
		
		//Constructors
		BinaryTrees(int data)
		{
			root = new Node(data);
		}
		
		BinaryTrees()
		{
			root = null;
		}
	}
	public static void main(String[] args)
	{
		
	}
}
