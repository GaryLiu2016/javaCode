class TreeNode {
	
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;					// use this param to find the path to the root

	public TreeNode(int val) {
		this.val = val;
	}

}

// function: To find if the target number can be reach from the number 'start' by the 
// 			following two methods: time two(*2) or devide by three(/3). Return the shortest 
//			calculations.
// param: 
//			start: the starting number to be used in the calculation
//			target: the target number that we decide if the calculation exists
// return:
//			res: the path of the calculations from the start number to the target number  

public String findTarget(int start, int target) {
	
	String res = "";
	if (start <= 0 || target <= 0) {
		return res;
	}

	Set<Integer> number = new HashSet<>();
	number.add(start);

	TreeNode root = new TreeNode(start);

	Deque<TreeNode> queue = new Deque<>();
	queue.offer(root);

	while (!queue.isEmpty()) {

		TreeNode cur = queue.remove();
		if (cur.val == target) {
			return findPath(cur);
		}

		if (!number.contains(cur.val * 2)) {
			number.add(cur.val * 2);
			TreeNode leftChild = new TreeNode(cur.val * 2);
			cur.left = leftChild;			// just for building the BS tree
			leftChild.parent = cur;
			queue.offer(leftChild);
		}
		if (!number.contains(cur.val / 3)) {
			number.add(cur.val / 3);
			TreeNode rightChild = new TreeNode(cur.val / 3);
			cur.right = rightChild			// just for building the BS tree
			rightChild.parent = cur;
			queue.offer(rightChild);
		}


	}
	return res;
}


// function: To find the path from current node to the root of the binary tree
// param: 
//			root: the starting node from which to the root of the tree
// return:
//			res: the path from the current node to the root of the tree


public String findPath(TreeNode current) {
	
	String res = "";
	while (current != null) {
		res += current.val + " ";
		current = current.parent;
	}
	return res;
	
}