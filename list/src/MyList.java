/**
 * This program demonstrates a self-defined List class which is a circular doubly linked list.
 *
 * @param <T> any type of data can be stored in the nodes of a circular doubly linked list
 */
public class MyList<T> {
    // header of circular doubly linked list
    private ListNode<T> header;
    // the number of nodes
    private int counter;

    // use inner class to define the nodes in a circular doubly linked list
    private final class ListNode<T> {
        public ListNode prev;
        public ListNode next;
        public T value;

        /**
         * Constructs a node in a circular doubly linked list.
         *
         * @param value the data stored in a node
         * @param prev  the previous node
         * @param next  the next node
         */
        public ListNode(T value, ListNode prev, ListNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Constructs a circular doubly linked list using default values.
     */
    public MyList() {
        // create header node, please note that there is no data in it
        this.header = new ListNode<T>(null, null, null);
        this.header.prev = this.header;
        this.header.next = this.header;
        // initialize "the number of nodes" to 0 at the beginning
        this.counter = 0;
    }

    /**
     * Gets the number of nodes in a circular doubly linked list.
     *
     * @return the number of nodes
     */
    public int size() {
        return counter;
    }

    /**
     * Checks whether the list is empty.
     *
     * @return if the list is empty return true; if the list is not empty, return false
     */
    public boolean isEmpty() {
        return counter == 0;
    }

    /**
     * Gets the node in specific position.
     * In order to improve the efficiency of searching, both forward and backward searching should be used.
     *
     * @param index the position of the node
     * @return the node in specific position
     */
    private ListNode<T> getNode(int index) {
        if ((index < 0) || (index >= counter)) {
            throw new IndexOutOfBoundsException();
        }

        // forward searching
        if (index <= counter / 2) {
            // initialize start position and search
            ListNode<T> node = header.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        // backward searching
        ListNode<T> node = header.prev;
        for (int j = 0; j < counter - index - 1; j++) {
            node = node.prev;
        }
        return node;
    }

    /**
     * Gets the data in a specific node.
     *
     * @param index the position of the node
     * @return the data value in specific position
     */
    public T getData(int index) {
        return getNode(index).value;
    }

    /**
     * Gets the data in the first node.
     *
     * @return the data in the first node
     */
    public T getFirstData() {
        return getNode(0).value;
    }

    /**
     * Gets the data in the last node.
     *
     * @return the data in the last node
     */
    public T getLastData() {
        return getNode(counter - 1).value;
    }

    /**
     * Inserts a node to a specific position.
     *
     * @param index the index of the insert position
     * @param data  the data to be inserted
     * @return if insert successfully, return true; if not, return false
     */
    public boolean insert(int index, T data) {
        if (index == 0) {
            ListNode<T> node = new ListNode<>(data, header, header.next);
            header.next.prev = node;
            header.next = node;
            counter++;
            return true;
        } else if ((index > 0) && (index < counter)) {
            ListNode<T> oldNode = getNode(index);
            ListNode<T> newNode = new ListNode<>(data, oldNode.prev, oldNode);
            oldNode.prev.next = newNode;
            oldNode.prev = newNode;
            counter++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inserts a node after the header.
     *
     * @param data the data to be inserted
     * @return if insert successfully, return true; if not, return false
     */
    public boolean insertFirst(T data) {
        return insert(0, data);
    }

    /**
     * Appends a node to the end of a circular doubly linked list.
     *
     * @param data the data to be appended
     * @return always true
     */
    public boolean appendLast(T data) {
        ListNode<T> node = new ListNode<>(data, header.prev, header);
        header.prev.next = node;
        header.prev = node;
        counter++;
        return true;
    }

    /**
     * Deletes the node in a circular doubly linked list.
     *
     * @param index the index of the delete position
     * @return if delete successfully, return true; if not, return false
     */
    public boolean delete(int index) {
        boolean flag;
        if ((index > 0) && (index < counter)) {
            ListNode<T> node = getNode(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node = null;
            counter--;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * Deletes the first node in a circular doubly linked list.
     */
    public void deleteFirst() {
        delete(0);
    }

    /**
     * Deletes the last node in a circular doubly linked list.
     */
    public void deleteLast() {
        delete(counter - 1);
    }
}

