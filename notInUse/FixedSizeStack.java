package notInUse;

import java.util.Stack;

public class FixedSizeStack<T> {
    private Stack<T> stack = new Stack<>();
    private int maxSize;
    private int currentSize = 0;

    public FixedSizeStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(T item){
        if(currentSize < maxSize){
            stack.push(item);
            currentSize++;
        }
    }

    public T pop(){
        currentSize--;
        return stack.pop();
    }

    public T peek(){
        return stack.peek();
    }

    @Override
    public String toString() {
        return "notInUse.FixedSizeStack{" +
                "stack=" + stack +
                ", maxSize=" + maxSize +
                ", currentSize=" + currentSize +
                '}';
    }
}
