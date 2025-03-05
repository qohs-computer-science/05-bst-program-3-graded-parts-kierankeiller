/*
 * Kieran Keiller
 * 2/20/25
 * Pd.8
 * This creates a BST class that can add, remove, find, replace, and check for size, emptiness, and print the values in a Binary Search Tree.
 */

import java.lang.Comparable;
public class BST implements BSTInterface
{
    private TreeNode root;

    public BST() //- This constructor creates an empty tree (remember to set any values to null) (4 points with proper field creation)
    {
        root=null;
    }//end BST constructor

    int size = 0;
    public int size()// returns the current number of nodes that are located in the tree
    {   
        size = 0;
        System.out.print("Size: ");
        if (root==null){
            return size;
        }//end if
        if (root.getLeft()!=null)
            sizeHelper(root.getLeft());
        size++;
        if (root.getRight()!=null)
            sizeHelper(root.getRight());
        return size;
    }//end size

    public void sizeHelper(TreeNode child){
        if (child.getLeft()!=null){
            sizeHelper(child.getLeft());
        }//end if
        size++;
        if (child.getRight()!=null){
            sizeHelper(child.getRight());
        }//end if
        return;
    }//end size helper


    public boolean isEmpty() //returns true if there are no nodes in the tree and false if there is at least one node in the tree
    {
        if (root == null){
            return true;
        }//end if
        return false;
    }//end isEmpty

    public void add(Comparable val)// - Creates a new node to store the value being sent then adds the node to the tree in the correct place (remember all left children are less than or equal to their parent and all right children are greater than their parent).   (10 points with proper helper method creation, use of recursion)
    {
        if(root==null)
		    root= new TreeNode(val, null, null);
	    else if (val.compareTo(root.getValue())<=0)
		    addHelper(val, root.getLeft(), root);
	    else 
		    addHelper(val, root.getRight(), root);
    }//end add

    public void addHelper(Comparable val, TreeNode child, TreeNode parent){
        if (child == null){
		    if (val.compareTo(parent.getValue())<=0){
			    parent.setLeft(new TreeNode(val));
            }//end if
            if (val.compareTo(parent.getValue())>0){
			    parent.setRight(new TreeNode(val));
            }//end if
        }//end if
	    else if (val.compareTo(child.getValue())<=0){
		    addHelper(val, child.getLeft(), child);
        }//end else if
	    else {
		    addHelper(val, child.getRight(), child);
        }//end else
    }//end addHelper

    public boolean find(Comparable val) //searches through the tree to determine if the object being passed is a current element in the tree if it is, return true, otherwise, return false
    {
        if (root.getValue()==null){
            return false;
        }//end if
        else{
            if (root.getValue()==val){
                return true;
            }//end if
            else if (val.compareTo(root.getValue())<=0){
                if (root.getLeft() != null){
                    return findHelper(root.getLeft(), val);
                }//end if
                else {
                    return false;
                }//end else
            }//end else if
            else if (val.compareTo(root.getValue())>0){
                if (root.getRight() != null){
                    return findHelper(root.getRight(), val);
                }//end if
                else {
                    return false;
                }//end else
            }//end else if
        }//end else
        return false;
    }//end find

    public boolean findHelper  (TreeNode child, Comparable val){
        if (child.getValue()==val){
            return true;
        }//end if
        else if (val.compareTo(child.getValue())<=0){
            if (child.getLeft() != null){
                return findHelper(child.getLeft(), val);
            }//end if
            else {
                return false;
            }//end else
        }//end else if
        else if (val.compareTo(child.getValue())>0){
            if (child.getRight() != null){
                return findHelper(child.getRight(), val);
            }//end if
            else {
                return false;
            }//end else
        }//end else if
        return false;
    }//end find helper

    public boolean replace(Comparable val, Comparable toAdd) //this method takes an “old” object – determines if it is currently in the tree and if it is, removes that object and adds the “toAdd” object.  If the element was successfully replaced then true is returned, if the old object did not exist then false is returned and the toAdd object is added to the BST.  Remember that you cannot just replace an element by changing its value because it may not belong at that spot in the tree after being replaced. 
    {
        if (this.find(val)==true){
            this.delete(val);
            this.add(toAdd);
            return true;
        }//end if
        this.add(toAdd);
        return false;
    } //end replace


    public boolean delete(Comparable val) //this method deletes the object being passed to the method from the tree.  When you remove the node you must then change any children around to accommodate for the deleted node.  Return true if the node was successfully deleted, false if it was not in the tree and therefore not deleted.
    {
        if(root==null)
		    return false;
        else if (root.getValue()==val){
            if (root.getLeft() != null && root.getRight() != null){ // has a right and left child
                TreeNode temp = root.getLeft();
                while(temp.getRight() != null){
                    temp = temp.getRight();
                }//end while
                temp.setRight(root.getRight());
                root.setRight(null);
                root = root.getLeft();
            }//end if
            else if (root.getRight() != null){ //has a right child
                root = root.getRight();
            }//end else if
            else if (root.getLeft() != null){// has a left child
                root = root.getLeft();
            }//end else if
            else { // has no child
                root = null;
                return true;
            }//end else
        }//end else if
	    else if (val.compareTo(root.getValue())<=0)
		    deleteHelper(val, root.getLeft(), root);
	    else 
		    deleteHelper(val, root.getRight(), root);
        return false;
    }// end delete

    public boolean deleteHelper(Comparable val, TreeNode parent, TreeNode gpa) 
    {
        if(parent==null)
		    return false;
        else if (parent.getValue()==val){
            if (parent.getLeft() != null && parent.getRight() != null){ // has a right and left child
                TreeNode temp = parent.getLeft();
                while(temp.getRight() != null){
                    temp = temp.getRight();
                }//end while
                temp.setRight(parent.getRight());
                parent.setRight(null);
                if (parent.getValue().compareTo(gpa.getValue())>0){
                    gpa.setRight(parent.getLeft());
                }//end if
                else{
                    gpa.setLeft(parent.getLeft());
                }//end else
                parent.setRight(null);
                parent.setLeft(null);
                parent = temp;
                return true;
            }//end if
            else if (parent.getRight() != null){ //has a right child
                TreeNode temp = parent.getRight();
                if (parent.getValue().compareTo(gpa.getValue())>0){
                    gpa.setRight(parent.getRight());
                }//end if
                else{
                    gpa.setLeft(parent.getRight());
                }//end else
                parent.setRight(null);
                parent.setLeft(null);
                parent = temp;
                return true;
            }//end else if
            else if (parent.getLeft() != null){// has a left child
                TreeNode temp = parent.getLeft();
                if (parent.getValue().compareTo(gpa.getValue())>0){
                    gpa.setRight(parent.getLeft());
                }//end if
                else{
                    gpa.setLeft(parent.getLeft());
                }//end else
                parent.setRight(null);
                parent.setLeft(null);
                parent = temp;
                return true;
            }//end else if
            else { // has no child
                parent.setValue(null);
                return true;
            }//end else
        }//end else if
        else if (val.compareTo(parent.getValue())<=0)
		    deleteHelper(val, parent.getLeft(), parent);
	    else 
		    deleteHelper(val, parent.getRight(), parent);
        return false;
    }//end delete helper

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
    }//end printInOrder

    public void inOrderHelper(TreeNode child){
        if (child.getLeft()!=null){
            inOrderHelper(child.getLeft());
        }//end if
        System.out.print(child.getValue() + " ");
        if (child.getRight()!=null){
            inOrderHelper(child.getRight());
        }//end if
        return;
    }//end inOrderHelper

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
    }//end printPreOrder

    public void preOrderHelper(TreeNode child){
        System.out.print(child.getValue() + " ");
        if (child.getLeft()!=null){
            preOrderHelper(child.getLeft());
        }//end if
        if (child.getRight()!=null){
            preOrderHelper(child.getRight());
        }//end if
        return;
    }//end preOrderHelper

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
    }//end printPostOrder

    public void postOrderHelper(TreeNode child){
        if (child.getLeft()!=null){
            postOrderHelper(child.getLeft());
        }//end if
        if (child.getRight()!=null){
            postOrderHelper(child.getRight());
        }//end if
        System.out.print(child.getValue() + " ");
        return;
    }//end postOrderHelper
}//end BST class