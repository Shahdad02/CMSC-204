import java.util.ArrayList;

/**
 * @author Shahdad Parsi
 * @param <T>
 */
public class NotationQueue<T> implements QueueInterface<T> {
    private int qSize;
    private ArrayList<T> queue;
    int first, last, items = 0;

    public NotationQueue(){
        qSize = 5;
        queue = new ArrayList<T>(qSize);
    }

    public NotationQueue(int size){
        qSize = size;
        queue = new ArrayList<T>(qSize);
    }

    /**
     * determines is queue is empty
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if(items == 0){
            return true;
        }else{
            return false;
        }

    }

    /**
     * determines if queue is full
     * @return true if full, false otherwise
     */
    @Override
    public boolean isFull() {
        if(items == qSize){
            return true;
        }else{
            return false;
        }
    }

    /**
     * deletes the element in the front of queue
     * @return element in the front of queue
     * @throws QueueUnderflowException
     */
    @Override
    public T dequeue() throws QueueUnderflowException {
        T deleteElement;

        if(items == 0){
            throw new QueueUnderflowException();
        }else{
            deleteElement = queue.get(first);
            first++;
            items--;
        }
        return deleteElement;
    }

    /**
     * @return number of elements in queue
     */
    @Override
    public int size() {
        return items;
    }

    /**
     * adds element to end of queue
     * @param e the element to add to the end of the Queue
     * @return true if add was successful, false otherwise
     * @throws QueueOverflowException
     */
    @Override
    public boolean enqueue(T e) throws QueueOverflowException {
        if(items == qSize){
            throw new QueueOverflowException();
        }else{
            queue.add(last, e);
            last++;
            items++;
            return true;
        }
    }

    /**
     * string representation of elements in queue
     * @param delimiter
     * @return string representation of queue with elements separated
     */
    @Override
    public String toString(String delimiter) {
        String str = "";

        for(int i = 0; i < queue.size(); i++){
            if(i != queue.size()-1){
                str += queue.get(i) + delimiter;
            }else{
                str += queue.get(i);
            }
        }
        return str;
    }

    /**
     * fills queue with elements from arraylist
     * @param list elements to be added to the Queue
     */
    @Override
    public void fill(ArrayList list) {
        ArrayList<T> arr = new ArrayList<T>(list);
        queue.addAll(arr);
        items = queue.size();
    }

    /**
     * added toString method
     * @return string representation of queue with elements
     */
    public String toString(){
        String str = "";

        for(T i: queue){
            str += i;
        }
        return str;
    }
}
