public class ArrayStack<E> implements Stack<E> {

    E[] stack;
    int stackPositionCounter = 0;

    public ArrayStack(int size) {
        stack = (E[]) new Object[size];
    }

    public ArrayStack() { stack = (E[]) new Object[1000];}

    public void push(E e) {
        stack[stackPositionCounter] = e;
        stackPositionCounter++;
    }

    public E top(){
        try {
            return stack[stackPositionCounter - 1];
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

    public E pop() {
        try {
            E e = stack[stackPositionCounter - 1];
            stack[stackPositionCounter] = null;
            stackPositionCounter--;
            return e;
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

    public int size() {
        return stackPositionCounter;
    }

    public boolean empty() {
        if(stackPositionCounter -1 < 0){
            return true;
        }else return false;
    }
}
