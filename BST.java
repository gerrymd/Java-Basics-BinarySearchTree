public class BST implements IBST
{
	private Node root; // root = null;
	public void insert(int key)
	{
		Node temp = new Node(key);
		root = insertR(root, temp);
	}
	static Node insertR(Node root, Node temp)
	{
		if(root == null)
		{
			root = temp;
		}
		else if(root.key < temp.key)
		{
			root.right = insertR(root.right, temp);
		}
		else
		{
			root.left = insertR(root.left, temp);
		}
		return root;
	}
	public void disp()
	{
	//	inorderR(root);
	//	inorderI(root);
	//	preorderR(root);
	//	preorderI(root);
	//	postorderR(root);
		postorderI(root);
	}
	// observer that inorder traversal (root, right in inorder, left in inorder)
	// reversed is postorder(left in postorder, right in postorder, root)
	static void postorderI(Node temp)
	{
		Stack stack = new Stack(10); //  hard coding!
		Stack reverseStack =  new Stack(10);
		while(temp != null  || ! stack.isEmpty())
		{
			// push the root of the trees to the stack; move left
			while(temp != null)
			{
//				System.out.println(temp.key);
				reverseStack.push(temp);
				stack.push(temp);
				temp = temp.right;
			}
			if(! stack.isEmpty() )
			{
				temp = stack.pop();
				temp =  temp.left;
			}
		}
		while(! reverseStack.isEmpty())
		{
			System.out.println(reverseStack.pop().key);
		}
	}
	static void postorderR(Node temp)
	{
		if(temp != null)
		{
			postorderR(temp.left);
			postorderR(temp.right);
			System.out.println(temp.key);
		}
	}
	static void preorderI(Node temp)
	{
		Stack stack = new Stack(10); //  hard coding!
		while(temp != null  || ! stack.isEmpty())
		{
			// push the root of the trees to the stack; move left
			while(temp != null)
			{
				System.out.println(temp.key);
				stack.push(temp);
				temp = temp.left;
			}
			if(! stack.isEmpty() )
			{
				temp = stack.pop();
				temp =  temp.right;
			}
		}
	}

	static void preorderR(Node temp)
	{
		if(temp != null)
		{
			System.out.println(temp.key);
			preorderR(temp.left);
			preorderR(temp.right);
		}
	}
	static void inorderI(Node temp)
	{
		Stack stack = new Stack(10); //  hard coding!
		while(temp != null  || ! stack.isEmpty())
		{
			// push the root of the trees to the stack; move left
			while(temp != null)
			{
				stack.push(temp);
				temp = temp.left;
			}
			if(! stack.isEmpty() )
			{
				temp = stack.pop();
				System.out.println(temp.key);
				temp =  temp.right;
			}
		}
	}
	
	static void inorderR(Node temp)
	{
		if(temp != null)
		{
			inorderR(temp.left);
			System.out.println(temp.key);
			inorderR(temp.right);
		}
			
	}
	public boolean search(int key)
	{
		return searchR(root, key);
	}
	static boolean searchR(Node root, int key)
	{
		if(root == null)
		{
			return false;
		}
		else if(root.key == key)
		{
			return true;
		}
		else if(root.key > key)
		{
			return searchR(root.left, key);
		}
		else
		{
			return searchR(root.right, key);
		}
	}
}
// array implementation
class Stack
{
	private int size;
	private Node[] s;
	private int sp = -1;
	public Stack(int size)
	{
		this.size = size;
		s = new Node[size];
	}
	public void push(Node temp)
	{
		// no check
		s[++sp] =  temp;
	}
	public Node pop()
	{
		// no check
		return s[sp--];
	}
	public boolean isEmpty()
	{
		return sp == -1;
	}
	
}
class Node
{
	int key;
	Node left;
	Node right;
	public Node(int key)
	{
		this.key = key;
		left = right = null;
	}
}