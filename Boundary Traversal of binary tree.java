class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    
	    if(isLeaf(node)==false)
	    {
	        ans.add(node.data);
	    }
	    
	    left(node,ans);
	    leaves(node,ans);
	    right(node,ans);
	    
	    return ans;
	}
	
	boolean isLeaf(Node node)
	{
	    return node.left==null && node.right==null; 
	}
	
	void left(Node node,ArrayList<Integer> res)
	{
	    Node cur = node.left;
        
        while (cur != null) {
            if (isLeaf(cur) == false) res.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
	}
	
	void right(Node node,ArrayList<Integer> res)
	{
	    Node cur = node.right;
        
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        
        int i;
        for (i = tmp.size()-1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
	}
	
	void leaves(Node root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        
        if (root.left != null) leaves(root.left, res);
        if (root.right != null) leaves(root.right, res);
    }
}

