import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root;

    public BST() //- This constructor creates an empty tree (remember to set any values to null) (4 points with proper field creation)
    {
        root=null;
    }

    public int size()// returns the current number of nodes that are located in the tree
    {
        return 0;
    }
    public boolean isEmpty() //returns true if there are no nodes in the tree and false if there is at least one node in the tree
    {
        return false;
    }
    public void add(Comparable val)// - Creates a new node to store the value being sent then adds the node to the tree in the correct place (remember all left children are less than or equal to their parent and all right children are greater than their parent).   (10 points with proper helper method creation, use of recursion)
    {
        if(root==null)
		    root= new TreeNode(val, null, null);
	    else if (val.compareTo(root.getValue())<0)
		    addHelper(val, root.getLeft(), root);
	    else 
		    addHelper(val, root.getRight(), root);

    }

    public void addHelper(Comparable val, TreeNode child, TreeNode parent){
        if (child == null){
		    if (parent.getValue().compareTo(val)>=0){
			    parent.setLeft(new TreeNode(val));
            }
            if (parent.getValue().compareTo(val)<0){
			    parent.setRight(new TreeNode(val));
            }
        }
	    else if (val.compareTo(child.getValue())<0){
		    addHelper(val, child.getLeft(), child);
        }
	    else {
		    addHelper(val, child.getRight(), child);
        }
    }

    public boolean find(Comparable val) //searches through the tree to determine if the object being passed is a current element in the tree if it is, return true, otherwise, return false
    {
        if (root.getValue()==null){
            return false;
        }
        else{
            if (root.getValue()==val){
                return true;
            }
            else if (root.getValue().compareTo(val)>0){
                if (root.getLeft() != null){
                    findHelper(root, root.getLeft());
                }
                else {
                    return false;
                }
            }
        }
    }

    public TreeNode findHelper  (TreeNode parent, TreeNode child){
        return root;
    }

    public boolean replace(Comparable old, Comparable toAdd) //this method takes an “old” object – determines if it is currently in the tree and if it is, removes that object and adds the “toAdd” object.  If the element was successfully replaced then true is returned, if the old object did not exist then false is returned and the toAdd object is added to the BST.  Remember that you cannot just replace an element by changing its value because it may not belong at that spot in the tree after being replaced. 
    {
        return false;
    } 
    public boolean delete(Comparable old) //this method deletes the object being passed to the method from the tree.  When you remove the node you must then change any children around to accommodate for the deleted node.  Return true if the node was successfully deleted, false if it was not in the tree and therefore not deleted.
    {
        return false;
    }
    public void printInOrder() //prints the tree using an In Order traversal - recursion
    {
        
        
    }

    public void inOrderHelper(TreeNode child, TreeNode parent){
    }

    public void printPreOrder() //prints the tree using a Pre Order traversal - recursion
    {

    }
    public void printPostOrder() //prints the tree using a Post Order traversal – recursion
    {

    }
}