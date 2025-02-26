/*
 * Kieran Keiller
 * 2/20/25
 * Pd.8
 * TODO: Program Description
 */
 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
    BST jim = new BST();
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
    jim.delete("H");
    jim.printInOrder();
    jim.printPreOrder();
    jim.printPostOrder();
    System.out.println(jim.find("A"));
    System.out.println(jim.find("F"));
   }
 }