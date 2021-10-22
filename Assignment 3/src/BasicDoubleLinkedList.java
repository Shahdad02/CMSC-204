/**
 * Assignment 3
 * @author Shahdad Parsi
 */

import java.util.*;

public class BasicDoubleLinkedList<T> {
    protected int size;
    protected Node head;
    protected Node tail;

    ArrayList<T> list = new ArrayList<T>();

    /**
     * class constructor that sets the head and tail to null
     */
    public BasicDoubleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * @return size of the linked list
     */
    public int getSize(){
        return size;
    }

    /**
     * Add element to the end of the list
     * @param data
     * @return reference to the current object
     */
    public BasicDoubleLinkedList<T> addToEnd(T data){
        Node link = new Node(data);
        BasicDoubleLinkedList<T> list = new BasicDoubleLinkedList<T>();

        if(isEmpty()){
            head = link;
        }else{
            tail.next = link;
            link.previous = tail;
        }
        tail = link;
        size++;
        return this;
    }

    /**
     * Add element to the front of the list
     * @param data
     * @return reference to the current object
     */
    public BasicDoubleLinkedList<T> addToFront(T data){
        Node link = new Node(data);
        BasicDoubleLinkedList<T> list = new BasicDoubleLinkedList<T>();

        if(isEmpty()){
            tail = link;
        }
        else{
            link.next = head;
            head.previous = link;
        }
        head = link;
        size++;
        return this;
    }

    /**
     * Return but doesn't remove the first element from the list
     * @return the data element or null
     */
    public T getFirst(){
        if(isEmpty()){
            return null;
        }else
            return head.data;
    }

    /**
     * Returns but doesn't remove the last element from the list
     * @return the data element or null
     */
    public T getLast(){
        if(isEmpty()){
            return null;
        }else{
            return tail.data;
        }
    }

    /**
     * Checks to see if the list is empty or not
     * @return true if empty, false otherwise
     */
    private boolean isEmpty() {
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * defines hasNext(), next(), hasPrevious(), previous()
     * @throws UnsupportedOperationException
     * @throws NoSuchElementException
     */
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
        return new DoubleLinkedListIterator();
    }

    /**
     * Removes first instance of targeted data while performing a single traversal over the list
     * @param targetedData
     * @param comparator
     * @return data element or null
     */
    public BasicDoubleLinkedList<T> remove(T targetedData, Comparator<T> comparator){
        Node previous = null;
        Node found = null;
        Node current = head;
        BasicDoubleLinkedList<T> list = new BasicDoubleLinkedList<T>();

        while(!isEmpty()){
            if(comparator.compare(targetedData, current.data) == 0){
                if(size == 1){
                    found = head;
                    head = null;
                    tail = null;
                    size--;
                    break;
                }else if(current == head){
                    found = current;
                    head.next.previous = null;
                    head = head.next;
                    size--;
                    break;
                }else if(current == tail){
                    found = current;
                    tail.previous.next = null;
                    tail = tail.previous;
                    size--;
                    break;
                }else{
                    found = current;
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    size--;
                    break;
                }
            }
            previous = current;
            current = current.next;
        }
        return this;
    }

    /**
     * Removes and returns the first element from the list, null if empty
     * @return data element or null
     */
    public T retrieveFirstElement(){
        if(isEmpty()){
            return null;
        }else if(size == 1){
            T first = getFirst();
            head = null;
            tail = null;
            size--;
            return first;
        }else{
            T first = getFirst();
            head.next.previous = null;
            head = head.next;
            size--;
            return first;
        }
    }

    /**
     * Removes and returns the last element from the lest, null if empty
     * @return data element or null
     */
    public T retrieveLastElement(){
        if(isEmpty()){
            return null;
        }else if(size == 1){
            T last = getLast();
            head = null;
            tail = null;
            size--;
            return last;
        }else{
            T last = getLast();
            tail.previous.next = null;
            tail = tail.previous;
            size--;
            return last;
        }
    }

    /**
     * Returns an arraylist of the items in the list
     * @return an arraylist
     */
    public ArrayList<T> toArrayList(){
        ListIterator<T> it = iterator();

        while (it.hasNext()){
            list.add(it.next());
        }
        return list;
    }

    class Node{
        public Node previous;
        public Node next;
        public T data;

        public Node(){
            previous = null;
            next = null;
            data = null;
        }

        Node(T data){
            this.data = data;
        }
    }

    /**
     * iterator class
     * hasNext(), next()
     * hasPrevious, previous()
     */
    class DoubleLinkedListIterator implements ListIterator<T>{
        private Node previousL;
        private Node currentL;

        public DoubleLinkedListIterator() {
            previousL = null;
            currentL = head;
        }

        @Override
        public boolean hasNext() {
            return currentL != null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }else{
                previousL = currentL;
                currentL = currentL.next;
                return previousL.data;
            }
        }

        @Override
        public boolean hasPrevious() {
            return previousL != null;
        }

        @Override
        public T previous() {
            if(!hasPrevious()){
                throw new NoSuchElementException();
            }else{
                currentL = previousL;
                previousL = previousL.previous;
                return currentL.data;
            }
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();
        }
    }
}
