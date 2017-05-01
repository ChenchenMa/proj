/**
 * Created by Administrator on 2017/4/28.
 */
public class ArrayDeque <Item> {

    private Item[] items;
    private int size;
    private int nextLast;
    private int nextFirst;
    public int length;

    public ArrayDeque(){
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
        length=8;
    }

    private void resize(int capacity, int start){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, start, size);
        items = a;
        length = capacity;
    }

    public void addFirst(Item item){
        if(size == items.length){
            resize (size*3, size);
            nextFirst = size-1;
            nextLast = size*2;
        }
        items[nextFirst] = item;
        if(nextFirst!=0){nextFirst-=1;}
        else{nextFirst = length-1;}
        size+=1;
    }

    public void addLast(Item item){
        if(size == items.length){
            resize (size*3, size);
            nextFirst = size-1;
            nextLast = size*2;
        }
        items[nextLast]=item;
        if(nextLast!=length-1){nextLast+=1;}
        else{nextLast = 0;}
        size+=1;
    }

    public boolean isEmpty(){
        if(size==0) return true;
        else return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if(nextFirst<nextLast){
            for(int i = 1; i<=size; i++){
                System.out.print(items[nextFirst+i]+" ");
            }
        }
        else{
            for(int i = nextFirst+1; i<length; i++){
                System.out.print(items[i]+" ");
            }
            for(int i = 0; i<nextLast; i++){
                System.out.print(items[i]+" ");
            }
        }
    }

    public Item removeFirst(){
        if(size*4<length){
            resize(size*3, size);
            nextFirst = size-1;
            nextLast = size*2;
        }
       Item first = (Item) new Object();
        if(nextFirst!=length-1){
            first = items[nextFirst+1];
            nextFirst+=1;
        }
        if(nextFirst == length-1){
            first = items[0];
            nextFirst = 0;
        }
        size-=1;
        return first;
    }

    public Item removeLast(){
        if(size*4<length){
            resize(size*3, size);
            nextFirst = size-1;
            nextLast = size*2;
        }
        Item last = (Item) new Object();
        if(nextLast != 0){
            last = items[nextLast-1];
            nextLast = nextLast-1;
        }
        if(nextLast == 0){
            last = items[length-1];
            nextLast = length-1;
        }
        size-=1;
        return last;
    }

    public Item get(int index){
        if(index>size) return null;
        else return items[nextFirst+1+index];
    }

}
