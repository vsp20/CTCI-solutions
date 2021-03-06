/**
 * Created by Vishal on 12/5/16.
 * LinkedList class taken from https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java
 */
import java.util.*;

public class LinkedList<AnyType> implements Iterable<AnyType> {
    private Node<AnyType> head;

    /**
     * Constructs an empty list
     */
    public LinkedList() {
        head = null;
    }

    /**
     * Returns true if the list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Inserts a new node at the beginning of this list.
     */
    public void addFirst(AnyType item) {
        head = new Node<AnyType>(item, head);
    }

    /**
     * Returns the first element in the list.
     */
    public AnyType getFirst() {
        if (head == null) throw new NoSuchElementException();

        return head.data;
    }

    /**
     * Removes the first element in the list.
     */
    public AnyType removeFirst() {
        AnyType tmp = getFirst();
        head = head.next;
        return tmp;
    }

    /**
     * Inserts a new node to the end of this list.
     */
    public void addLast(AnyType item) {
        if (head == null)
            addFirst(item);
        else {
            Node<AnyType> tmp = head;
            while (tmp.next != null) tmp = tmp.next;

            tmp.next = new Node<AnyType>(item, null);
        }
    }

    /**
     * Returns the last element in the list.
     */
    public AnyType getLast() {
        if (head == null) throw new NoSuchElementException();

        Node<AnyType> tmp = head;
        while (tmp.next != null) tmp = tmp.next;

        return tmp.data;
    }

    /**
     * Removes all nodes from the list.
     */
    public void clear() {
        head = null;
    }

    /**
     * Returns true if this list contains the specified element.
     */
    public boolean contains(AnyType x) {
        for (AnyType tmp : this)
            if (tmp.equals(x)) return true;

        return false;
    }

    /**
     * Returns the data at the specified position in the list.
     */
    public AnyType get(int pos) {
        if (head == null) throw new IndexOutOfBoundsException();

        Node<AnyType> tmp = head;
        for (int k = 0; k < pos; k++) tmp = tmp.next;

        if (tmp == null) throw new IndexOutOfBoundsException();

        return tmp.data;
    }

    /**
     * Returns a string representation
     */
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (Object x : this)
            result.append(x + " ");

        return result.toString();
    }

    /**
     * Inserts a new node after a node containing the key.
     */
    public void insertAfter(AnyType key, AnyType toInsert) {
        Node<AnyType> tmp = head;

        while (tmp != null && !tmp.data.equals(key)) tmp = tmp.next;

        if (tmp != null)
            tmp.next = new Node<AnyType>(toInsert, tmp.next);
    }

    /**
     * Inserts a new node before a node containing the key.
     */
    public void insertBefore(AnyType key, AnyType toInsert) {
        if (head == null) return;

        if (head.data.equals(key)) {
            addFirst(toInsert);
            return;
        }

        Node<AnyType> prev = null;
        Node<AnyType> cur = head;

        while (cur != null && !cur.data.equals(key)) {
            prev = cur;
            cur = cur.next;
        }
        //insert between cur and prev
        if (cur != null)
            prev.next = new Node<AnyType>(toInsert, cur);
    }

    /**
     * Removes the first occurrence of the specified element in this list.
     */
    public void remove(AnyType key) {
        if (head == null)
            throw new RuntimeException("cannot delete");

        if (head.data.equals(key)) {
            head = head.next;
            return;
        }

        Node<AnyType> cur = head;
        Node<AnyType> prev = null;

        while (cur != null && !cur.data.equals(key)) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == null)
            throw new RuntimeException("cannot delete");

        //delete cur node
        prev.next = cur.next;
    }

    /**
     * Returns a deep copy of the list
     * Complexity: O(n^2)
     */
    public LinkedList<AnyType> copy1() {
        LinkedList<AnyType> twin = new LinkedList<AnyType>();
        Node<AnyType> tmp = head;
        while (tmp != null) {
            twin.addLast(tmp.data);
            tmp = tmp.next;
        }

        return twin;
    }

    /**
     * Returns a deep copy of the list
     * Complexity: O(n)
     */
    public LinkedList<AnyType> copy2() {
        LinkedList<AnyType> twin = new LinkedList<AnyType>();
        Node<AnyType> tmp = head;
        while (tmp != null) {
            twin.addFirst(tmp.data);
            tmp = tmp.next;
        }

        return twin.reverse();
    }

    /**
     * Reverses the list
     * Complewxity: O(n)
     */
    public LinkedList<AnyType> reverse() {
        LinkedList<AnyType> list = new LinkedList<AnyType>();
        Node<AnyType> tmp = head;
        while (tmp != null) {
            list.addFirst(tmp.data);
            tmp = tmp.next;
        }
        return list;
    }

    /**
     * Returns a deep copy of the immutable list
     * It uses a tail reference.
     * Complexity: O(n)
     */
    public LinkedList<AnyType> copy3() {
        LinkedList<AnyType> twin = new LinkedList<AnyType>();
        Node<AnyType> tmp = head;
        if (head == null) return null;
        twin.head = new Node<AnyType>(head.data, null);
        Node<AnyType> tmpTwin = twin.head;
        while (tmp.next != null) {
            tmp = tmp.next;
            tmpTwin.next = new Node<AnyType>(tmp.data, null);
            tmpTwin = tmpTwin.next;
        }

        return twin;
    }

    /*******************************************************
     *
     *  The Node class
     *
     ********************************************************/
    private static class Node<AnyType> {
        private AnyType data;
        private Node<AnyType> next;

        public Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }
    }

    /*******************************************************
     *
     *  The Iterator class
     *
     ********************************************************/

    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<AnyType> {
        private Node<AnyType> nextNode;

        public LinkedListIterator() {
            nextNode = head;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public AnyType next() {
            if (!hasNext()) throw new NoSuchElementException();
            AnyType res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* Question 2.1
     * In order to delete duplicates we need a way to store the ones that have already appeared (HashTable)
     * Basically the main concept is to loop through the list and if it already "contains" the number, delete it
     * else add it to the table. This takes O(N) only iterating through one time.
     * Should probably always declare a previous node to delete and edit the list.
     */
    public void deleteDups(Node n) {
        HashSet<Integer> set = new HashSet<Integer>();
        Node previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;

            } else {
                set.add((Integer) n.data);
                previous = n;
            }
            n = n.next;
        }

    }

    /* Question 2.2
     * For this we can use a runner
     * runner should basically be k-1 elements ahead so that when runner hits the end of the list
     * n should be pointing to the wanted Node
     */
    public Object kthLast(int k) {
        Node n = this.head;
        Node runner = this.head;
        for (int i = 0; i < k-1; i++) {
            runner = runner.next;
        }
        while (runner.next != null){
            runner = runner.next;
            n = n.next;
        }
        System.out.println(n.data);
        return n.data;
    }

    /*  Question 2.3
     * Basically this deletes a node without being able to access the head or previous nodes
     * so what i did was take the next node and basically copied that to the given node, then deleted
     * the next node.
     * Here we use the fact that n.previous points to n.
     *
     */
    public void deleteMiddle(Node n) {
        if (n.next == null || n.next.next == null){

        }
        else{
            Node next = n.next;
            n.data = next.data;
            n.next = next.next;

        }

    }
    /* Question 2.4
     * The way i went about this was adding any number < x to the front of the list and any
     * number >= x to the back of the list.
     * Be sure to set tail.next = null when finished with making lists like these because it will
     * end in an infinite loop
     * Also since we are tampering with n.next, use a next variable to store the real n.next at the beginning of the loop
     */
    public void partition(Node n, int x){
        Node head = n;
        Node tail = n;
        while (n != null){
            Node next = n.next;
            if ((int)n.data >= x){
                tail.next = n;
                tail = n;
            }
            else{
                n.next = head;
                head = n;
            }
            n = next;

        }
        tail.next = null;
        Node node = head;
        while (node != null){
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();

    }


    public void sumList(Node n1, Node n2){
        Node n3 = null;
        boolean carry = false;
        int count = 0;
        Node n3head = null;
        while (n1 != null && n2 != null){
            int sum = (int)n1.data + (int)n2.data;
            if (carry){
                sum = sum + 1;
            }
            carry = false;
            if (sum >= 10){
                carry = true;
                sum = sum - 10;
            }
            n3.data = sum;
            if (count == 0){
                n3head = n3;
            }
            n3 = n3.next;
            count++;
        }
        while (n3head != null){
            System.out.print(n3head.data);
            n3head = n3head.next;
        }
        System.out.println();

    }




    public void print(){
        Node n = head;
        while (n != null){
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();

    }


    public static void main(String[] args){
        LinkedList<Integer> a = new LinkedList<Integer>();
        LinkedList<Integer> b = new LinkedList<Integer>();
        LinkedList<Integer> c = new LinkedList<Integer>();
        LinkedList<Integer> d = new LinkedList<Integer>();
        LinkedList<Integer> e = new LinkedList<Integer>();
        a.addFirst(3);
        a.addLast(4);
        a.addLast(3);
        a.addLast(5);
        a.print();
        a.deleteDups(a.head);
        a.print();
        b.addFirst(3);
        b.addLast(4);
        b.addLast(5);
        b.addLast(6);
        b.addLast(7);
        b.print();
        b.kthLast(3);
        b.deleteMiddle(b.head.next);
        b.print();
        c.addFirst(3);
        c.addLast(5);
        c.addLast(8);
        c.addLast(5);
        c.addLast(9);
        c.addLast(2);
        c.addLast(1);
        c.print();
        c.partition(c.head, 5);
        d.addFirst(7);
        d.addLast(1);
        d.addLast(6);
        e.addFirst(2);
        e.addLast(9);
        e.addLast(5);
        a.sumList(d.head,e.head);

    }
}

