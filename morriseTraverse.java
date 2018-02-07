// Morris Traverse -- space complexity = O(1), time complexity = O(n)

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

// Inorder Traverse
public void inorderTraverse(TreeNode root) {
	if (root == null) {
		return;
	}
	TreeNode cur = root;
	TreeNode pre = null;
	while (cur != null) {
		if (cur.left == null) {									// no left child, print
			System.out.println(cur.val);
			cur = cur.right;
		} else {
			pre = cur.left;
			while (pre.right != null && pre.right != cur) {		// find the predecessor of cur
				pre = pre.right;
			}
			if (pre.right == null) {							// first traverse pre, connect pre with cur
				pre.right = cur;
				cur = cur.left;
			} else {											// second traverse pre, disconnect pre with cur, print cur
				pre.right = null;
				System.out.println(cur.val);
				cur = cur.right;
			}
		}
	}

}

// Preorder Traverse
public void preorderTraverse(TreeNode root) {
	if (root == null) {
		return;
	}
	TreeNode cur = root;
	TreeNode pre = null;
	while (cur != null) {
		if (cur.left == null) {
			System.out.println(cur.val);
			cur = cur.right;
		} else {
			pre = cur.left;
			while (pre.right != null && pre.right != cur) {
				pre = pre.right;
			}
			if (pre.right == null) {
				pre.right = cur;
				System.out.println(cur.val);					// only different with inorderTraverse, print when connection built
				cur = cur.left;
			} else {
				pre.right = null;
				cur = cur.right;
			}
		}

	}
}










