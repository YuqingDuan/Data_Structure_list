/**
 * This program demonstrates a test for MyList class.
 */
public class TestMyList {
    public static void main(String[] args) {
        // operate int data
        System.out.println("\n----int_test----");

        // create a circular doubly linked list
        MyList<Integer> list = new MyList<>();

        // insert 20 to first position
        System.out.println("insert: " + list.insert(0, 20));
        // append 10 to the end 
        System.out.println("appendLast: " + list.appendLast(10));
        // insert 30 to first position
        System.out.println("insertFirst: " + list.insertFirst(30));
        // check whether the list is empty
        System.out.println("isEmpty: " + list.isEmpty());
        // the number of nodes in a circular doubly linked list
        System.out.println("size: " + list.size());
        // print the list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.getData(i));
        }
    }
}
