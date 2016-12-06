/**
 * Created by Vishal on 12/5/16.
 */
/**
 * A class to represent a linked list of nodes.
 */
public class LinkedList<T> {
    /** the first node of the list, or null if the list is empty */
    private LLNode<T> first;

    /**
     * Creates an initially empty linked list
     */
    public LinkedList() {
        first = null;
    }

    /**
     * Returns the first node.
     */
    protected LLNode<T> getFirst() {
        return first;
    }

    /**
     * Changes the first node.
     * @param node  the node that will be the first node of the new linked list
     */
    protected void setFirst(LLNode<T> node) {
        this.first = node;
    }

    /**
     * Add an element to the front of the linked list
     */
    public void addToFront(T element) {
        setFirst(new LLNode<T>(element, getFirst()));
    }

    /**
     * Return whether the list is empty
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return (getFirst() == null);
    }

    /**
     * Returns the length of the linked list
     * @return the number of nodes in the list
     */
    public int length() {
        int lengthSoFar = 0;
        LLNode<T> nodeptr = getFirst();
        while (nodeptr != null) {
            lengthSoFar++;
            nodeptr = nodeptr.getNext();
        }
        return lengthSoFar;
    }

  /*-------------------------------------------*/
  /* THE NEXT METHODS WILL BE COMPLETED IN LAB */
  /*-------------------------------------------*/

    /**
     * Returns a String representation of the list
     * @return a String representing the list
     */
    public String toString() {
        return null;
    }

    /**
     * Determines whether an element is stored in the list
     * @param element  the element to search for in the list
     * @return true if and only if the parameter element is in the list
     */
    public boolean contains(T element) {
        LLNode<T> nodeptr = getFirst();
        if (this.getFirst() == null){
            return false;
        }
        for (int i = 0; i < this.length(); i++){
            if (nodeptr.getElement() == element){
                return true;
            }
            nodeptr = nodeptr.getNext();
        }

        return false;
    }

    /**
     * Deletes the first occurrance of an element in the list.
     * If the element is not in the list, the list is unchanged.
     * @param element  the element to remove
     */
    public void remove(T element) {
    }

    /*
    public void reverse(){
      LLNode<T> Current = this.getFirst();
      LLNode<T> D = Current.getNext();
      LLNode<T> P = D.getNext();
      while (P != null){
       if (Current == this.getFirst()){
       Current.setNext(null);
       }
       D.setNext(Current);
       Current = D;
       D = P;
       P = P.getNext();
      }


    }
    */
}