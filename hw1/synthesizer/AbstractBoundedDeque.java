package synthesizer;

/**
 * Created by Administrator on 2017/5/5.
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>{
    protected int fillCount;
    protected int capacity;
    public int capacity(){
        return capacity;
    }
    public int fillCount(){
        return fillCount;
    }
    public boolean isEmpty(){
        return fillCount == 0;
    }
    public boolean isFull(){
        return fillCount == capacity;
    }

}