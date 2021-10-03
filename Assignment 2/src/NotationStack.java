import java.util.ArrayList;

/**
 * @author Shahdad Parsi
 * @param <T>
 */
public class NotationStack<T> implements StackInterface<T> {
    private int sSize;
    private ArrayList<T> stack;
    int items = 0;

    public NotationStack(){
        sSize = 5;
        stack = new ArrayList<T>(sSize);
    }

    public NotationStack(int size){
        sSize = size;
        stack = new ArrayList<T>(sSize);
    }

    /**
     * checks to see if the stack is empty
     * @return true if stack is empty, false otherwise
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
     * checks to see if the stack is full
     * @return true if stack is full, false otherwise
     */
    @Override
    public boolean isFull() {
        if(items == sSize){
            return true;
        }else{
            return false;
        }
    }

    /**
     * removes/pops the top element of the stack
     * @return the element at the top of the stack
     * @throws StackUnderflowException
     */
    @Override
    public T pop() throws StackUnderflowException {
        T popElem = null;

        if(items == 0){
            throw new StackUnderflowException();
        }else{
            popElem = stack.get(items - 1);
            stack.remove(items - 1);
            items--;
            return popElem;
        }
    }

    /**
     * returns the top of the stack, but doesn't pop it off
     * @return element at the top of the stack
     * @throws StackUnderflowException
     */
    @Override
    public T top() throws StackUnderflowException {
        if(items == 0){
            throw new StackUnderflowException();
        }else{
            return stack.get(items - 1);
        }
    }

    /**
     * checks and returns the size of stack
     * @return size of stack
     */
    @Override
    public int size() {
        return items;
    }

    /**
     * adds/pushes element to top of stack
     * @param e the element to add to the top of the Stack
     * @return true if the element was added to top, false otherwise
     * @throws StackOverflowException
     */
    @Override
    public boolean push(T e) throws StackOverflowException {
        if(items >= sSize){
            throw new StackOverflowException();
        }else{
            stack.add(e);
            items++;
            return true;
        }
    }

    /**
     * returns the string representation of the stack
     * from the beginning to the bottom of stack
     * @param delimiter
     * @return string representation of stack
     */
    @Override
    public String toString(String delimiter) {
        String str = "";

        for(int i = 0; i < stack.size(); i++){
            if(i != stack.size()-1){
                str += stack.get(i) + delimiter;
            }else{
                str += stack.get(i);
            }
        }
        return str;

    }

    /**
     * fills stack with elements from ArrayList
     * @param list elements to be added to the Stack from bottom to top
     */
    @Override
    public void fill(ArrayList list) {
        ArrayList<T> arr = new ArrayList<T>(list);
        stack.addAll(arr);
        items = stack.size();
    }

    /**
     * added toString method
     * @return string that represents the objects in the stack
     */
    public String toString(){
        String str = "";

//        for(int i = 0; i < stack.size(); i++){
//            str += i;
//        }
        for(T i: stack){
            str += i;
        }
        return str;
    }
}
