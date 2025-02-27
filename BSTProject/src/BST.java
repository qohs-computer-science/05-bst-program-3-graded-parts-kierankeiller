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
	    else if (val.compareTo(root.getValue())<=0)
		    addHelper(val, root.getLeft(), root);
	    else 
		    addHelper(val, root.getRight(), root);
    }

    public void addHelper(Comparable val, TreeNode child, TreeNode parent){
        if (child == null){
		    if (val.compareTo(parent.getValue())<=0){
			    parent.setLeft(new TreeNode(val));
            }
            if (val.compareTo(parent.getValue())>0){
			    parent.setRight(new TreeNode(val));
            }
        }
	    else if (val.compareTo(child.getValue())<=0){
		    addHelper(val, child.getLeft(), child);
        }
	    else {
		    addHelper(val, child.getRight(), child);
        }
    }

    public boolean find(Comparable val) //searches through the tree to determine if the object being passed is a current element in the tree if it is, return true, otherwise, return false
    {
        System.out.print("Looking for " + val + ": ");
        if (root.getValue()==null){
            return false;
        }
        else{
            if (root.getValue()==val){
                return true;
            }
            else if (val.compareTo(root.getValue())<=0){
                if (root.getLeft() != null){
                    return findHelper(root.getLeft(), val);
                }
                else {
                    return false;
                }
            }
            else if (val.compareTo(root.getValue())>0){
                if (root.getRight() != null){
                    return findHelper(root.getRight(), val);
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean findHelper  (TreeNode child, Comparable val){
        if (child.getValue()==val){
            return true;
        }
        else if (val.compareTo(child.getValue())<=0){
            if (child.getLeft() != null){
                return findHelper(child.getLeft(), val);
            }
            else {
                return false;
            }
        }
        else if (val.compareTo(child.getValue())>0){
            if (child.getRight() != null){
                return findHelper(child.getRight(), val);
            }
            else {
                return false;
            }
        }
        return false;
    }

    public boolean replace(Comparable old, Comparable toAdd) //this method takes an “old” object – determines if it is currently in the tree and if it is, removes that object and adds the “toAdd” object.  If the element was successfully replaced then true is returned, if the old object did not exist then false is returned and the toAdd object is added to the BST.  Remember that you cannot just replace an element by changing its value because it may not belong at that spot in the tree after being replaced. 
    {
        return false;
    } 


    public boolean delete(Comparable val) //this method deletes the object being passed to the method from the tree.  When you remove the node you must then change any children around to accommodate for the deleted node.  Return true if the node was successfully deleted, false if it was not in the tree and therefore not deleted.
    {
        if(root==null)
		    return false;
        else if (root.getValue()==val){
            if (root.getLeft() != null && root.getRight() != null){ // has a right and left child
                TreeNode temp = root.getLeft();
                while(temp.getRight() != null){
                    temp = temp.getRight();
                }
                temp.setRight(root.getRight());
                root.setRight(null);
                root = root.getLeft();
            }
            else if (root.getRight() != null){ //has a right child
                root = root.getRight();
            }
            else if (root.getLeft() != null){// has a left child
                root = root.getLeft();
            }
            else { // has no child
                root.setValue(null);
                return true;
            }
        }
	    else if (val.compareTo(root.getValue())<=0)
		    deleteHelper(val, root.getLeft(), root);
	    else 
		    deleteHelper(val, root.getRight(), root);
        return false;
    }

    public boolean deleteHelper(Comparable val, TreeNode parent, TreeNode gpa) 
    {
        if(parent==null)
		    return false;
        else if (parent.getValue()==val){
            if (parent.getLeft() != null && parent.getRight() != null){ // has a right and left child
                TreeNode temp = parent.getLeft();
                while(temp.getRight() != null){
                    temp = temp.getRight();
                }
                temp.setRight(parent.getRight());
                parent.setRight(null);
                if (parent.getValue().compareTo(gpa.getValue())>0){
                    gpa.setRight(parent.getLeft());
                }
                else{
                    gpa.setLeft(parent.getLeft());
                }
                parent = parent.getLeft();
                return true;
            }
            else if (parent.getRight() != null){ //has a right child
                if (parent.getValue().compareTo(gpa.getValue())>0){
                    gpa.setRight(parent.getRight());
                }
                else{
                    gpa.setLeft(parent.getRight());
                }
                parent = parent.getRight();
                return true;
            }
            else if (parent.getLeft() != null){// has a left child
                if (parent.getValue().compareTo(gpa.getValue())>0){
                    gpa.setRight(parent.getLeft());
                }
                else{
                    gpa.setLeft(parent.getLeft());
                }
                parent = parent.getLeft();
                return true;
            }
            else { // has no child
                parent.setValue(null);
                return true;
            }
        }
        else if (val.compareTo(parent.getValue())<=0)
		    deleteHelper(val, parent.getLeft(), parent);
	    else 
		    deleteHelper(val, parent.getRight(), parent);
        return false;
    }

    public void printInOrder() //prints the tree using an In Order traversal - recursion
    {
        System.out.print("In Order Print: ");
        if (root == null)
            System.out.println("There is nothing to print");
        if (root.getLeft()!=null)
            inOrderHelper(root.getLeft());
        System.out.print(root.getValue() + " ");
        if (root.getRight()!=null)
            inOrderHelper(root.getRight());
        System.out.println();
    }

    public void inOrderHelper(TreeNode child){
        if (child.getLeft()!=null){
            inOrderHelper(child.getLeft());
        }
        System.out.print(child.getValue() + " ");
        if (child.getRight()!=null){
            inOrderHelper(child.getRight());
        }
        return;
    }

    public void printPreOrder() //prints the tree using a Pre Order traversal - recursion
    {
        System.out.print("Pre Order Print: ");
        if (root == null)
            System.out.println("There is nothing to print");
        System.out.print(root.getValue() + " ");
        if (root.getLeft()!=null)
            preOrderHelper(root.getLeft());
        if (root.getRight()!=null)
            preOrderHelper(root.getRight());
        System.out.println();
    }

    public void preOrderHelper(TreeNode child){
        System.out.print(child.getValue() + " ");
        if (child.getLeft()!=null){
            preOrderHelper(child.getLeft());
        }
        if (child.getRight()!=null){
            preOrderHelper(child.getRight());
        }
        return;
    }

    public void printPostOrder() //prints the tree using a Post Order traversal - recursion
    {
        System.out.print("Post Order Print: ");
        if (root == null)
            System.out.println("There is nothing to print");
        if (root.getLeft()!=null)
            postOrderHelper(root.getLeft());
        if (root.getRight()!=null)
            postOrderHelper(root.getRight());
        System.out.print(root.getValue() + " ");
        System.out.println();
    }

    public void postOrderHelper(TreeNode child){
        if (child.getLeft()!=null){
            postOrderHelper(child.getLeft());
        }
        if (child.getRight()!=null){
            postOrderHelper(child.getRight());
        }
        System.out.print(child.getValue() + " ");
        return;
    }
}