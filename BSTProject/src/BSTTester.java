/*
 * Kieran Keiller
 * 2/20/25
 * Pd.8
 * This tests the BST class we made in another file
 */
 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
    BST jim = new BST();

    System.out.print("Checking if empty: ");
    System.out.println(jim.isEmpty());
    
    System.out.println(jim.size());

    System.out.println("Adding original nodes");
    jim.add("O");
    jim.add("R");
    jim.add("C");
    jim.add("H");
    jim.add("A");
    jim.add("R");
    jim.add("D");
    jim.add("Q");
    jim.add("U");
    jim.add("I");
    jim.add("N");
    jim.add("C");
    jim.add("E");

    jim.printInOrder();
    jim.printPreOrder();
    jim.printPostOrder();

    System.out.println(jim.size());

    System.out.println("Replace C with Y");
    jim.replace("C", "Y");

    jim.printInOrder();

    System.out.println(jim.size());

    System.out.println("Deleting R");
    jim.delete("R");
    jim.printInOrder();

    System.out.println(jim.size());
    
    System.out.print("Checking if empty: ");
    System.out.println(jim.isEmpty());

    System.out.print("Finding O: ");
    System.out.println(jim.find("O"));

    System.out.print("Finding C: ");
    System.out.println(jim.find("C"));

    System.out.println("Deleting C");
    jim.delete("C");
    jim.printInOrder();

    System.out.print("Finding C: ");
    System.out.println(jim.find("C"));
   }//end main
 }//end class