public class Client
{
	public static void main(String[] args)
	{
		int[] a = {40, 20, 10, 50, 30, 70, 60 };
		IBST bst = new BST();
		for(int elem : a)
		{
			bst.insert(elem);
		}
		//bst.disp();
		System.out.println("search : " + bst.search(70));
		System.out.println("search : " + bst.search(10));
		System.out.println("search : " + bst.search(100));
		
	}
}
