public class BinarySearchTree_Problem {

	private Node root;

	public static class Node {
		private int value;
		private Node lChild;
		private Node rChild;

		public Node(int v, Node l, Node r) {
			value = v;
			lChild = l;
			rChild = r;
		}

		public Node(int v) {
			value = v;
			lChild = null;
			rChild = null;
		}
	}

	// Create Binary Search Tree From Sorted Array

	public void CreateBinaryTree(int[] arr) {
		root = CreateBinaryTree(arr, 0, arr.length - 1);
	}

	private Node CreateBinaryTree(int[] arr, int start, int end) {
		Node curr = null;
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		curr = new Node(arr[mid]);
		curr.lChild = CreateBinaryTree(arr, start, mid - 1);
		curr.rChild = CreateBinaryTree(arr, mid + 1, end);
		return curr;
	}

	// Insert Node

	public void InsertNode(int value) {
		root = InsertNode(root, value);
	}

	private Node InsertNode(Node node, int value) {
		if (node == null) {
			node = new Node(value, null, null);
		} else {
			if (node.value > value) {
				node.lChild = InsertNode(node.lChild, value);
			} else {
				node.rChild = InsertNode(node.rChild, value);
			}
		}
		return node;
	}

	// Find Node

	public boolean Find(int value) {
		Node curr = root;
		while (curr != null) {
			if (curr.value == value) {
				return true;
			} else if (curr.value > value) {
				curr = curr.lChild;
			} else {
				curr = curr.rChild;
			}
		}
		return false;
	}

	// Find Min

	public int FindMin() {
		Node node = root;
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		while (node.lChild != null) {
			node = node.lChild;
		}
		return node.value;
	}

	public Node FindMinNode(Node curr) {
		Node node = curr;
		if (node == null) {
			return null;
		}
		while (node.lChild != null) {
			node = node.lChild;
		}
		return node;
	}

	// Find Max

	public int FindMax() {
		Node node = root;
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		while (node.rChild != null) {
			node = node.rChild;
		}
		return node.value;
	}

	public Node FindMaxNode(Node curr) {
		Node node = curr;
		if (node == null) {
			return null;
		}
		while (node.rChild != null) {
			node = node.rChild;
		}
		return node;
	}

	public static void main(String[] args) {

	}

}
