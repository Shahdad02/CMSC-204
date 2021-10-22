/**
 * Assignment 3
 * @author Shahdad Parsi
 */

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator comparator;

    /**
     * class constructor, sets comparator to comparator1
     * @param comparator1
     */
    public SortedDoubleLinkedList(Comparator<T> comparator1){
        comparator = comparator1;
    }

    /**
     * Insterts the element to its correct position in the list
     * @param data
     * @return reference to the current object
     */
    public SortedDoubleLinkedList<T> add(T data){
        Node link = new Node(data);
        Node current = head;
        Node previous;

        if(size == 0){
            head = link;
            tail = link;
            size++;
            return this;
        }

        if(size == 1){
            if(comparator.compare(data, current.data) < 0 || comparator.compare(data, current.data) == 0){
                super.addToFront(data);
                return this;
            }else{
                super.addToEnd(data);
                return this;
            }
        }else{
            while(comparator.compare(current.data, data) < 0){
                previous = current;
                current = current.next;

                if(current == null){
                    current = link;
                    link.previous = previous;
                    previous.next = link;
                    tail = link;
                    size++;
                    return this;
                }
            }
            if(current == head){
                if(comparator.compare(data, current.data) < 0){
                    super.addToFront(data);
                }
            }else if(current == tail){
                current.previous.next = link;
                link.next = current;
                link.previous = current.previous;
                current.previous = link;
                size++;
            }
            return this;
        }
    }

    /**
     * Invalid for a list
     * @param data
     * @return reference to current object
     * @throws UnsupportedOperationException
     */
    public SortedDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * Invalid for a list
     * @param data
     * @return reference to current object
     * @throws UnsupportedOperationException
     */
    public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * Implements iterator by calling its superclass method
     * @return iterator positioned at the head of list
     */
    public ListIterator<T> iterator(){
        return super.iterator();
    }

    /**
     * Implements the remove by calling its super class method
     * @param data
     * @param comparator
     * @return data element or null
     */
    public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator){
        super.remove(data, comparator);
        return this;
    }
}
