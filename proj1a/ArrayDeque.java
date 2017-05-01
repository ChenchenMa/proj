/**
 * Created by Administrator on 2017/4/28.
 */
public class ArrayDeque<Item> {

    private Item[] items;
    private int size;
    private int nextLast;
    private int nextFirst;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        if(nextFirst < nextLast -1){
            System.arraycopy(items,nextFirst+1, a, 0, size);
        } else if (nextFirst == items.length - 1) {
            System.arraycopy(items, 0, a, 0, size);
        } else {
            System.arraycopy(items, nextFirst+1, a, 0, items.length - nextFirst - 1);
            System.arraycopy(items, 0, a, items.length - nextFirst - 1, nextLast );
        }
        items = a;
        nextLast = size;
        nextFirst = capacity - 1;
    }

    public void addFirst(Item item) {
        if (size == items.length) {
            resize(size * 3);
        }
        items[nextFirst] = item;
        if (nextFirst != 0) {
            nextFirst -= 1;
        } else {
            nextFirst = items.length - 1;
        }
        size += 1;
    }

    public void addLast(Item item) {
        if (size == items.length) {
            resize(size * 3);
        }
        items[nextLast] = item;
        if (nextLast != items.length - 1) {
            nextLast += 1;
        } else {
            nextLast = 0;
        }
        size += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < size; i = i + 1) {
            System.out.print(get(i) + " ");
        }
    }

    public Item removeFirst() {
        if (size >= 1) {
            Item first = (Item) new Object();
            if (nextFirst != items.length - 1) {
                nextFirst += 1;
            } else if (nextFirst == items.length - 1) {
                nextFirst = 0;
            }
            first = items[nextFirst];
            items[nextFirst] = null;
            size -= 1;
            if (size * 4 < items.length && items.length > 16) {
                resize(size * 3);
            }
            return first;
        }
        else {
            return null;
        }
    }

    public Item removeLast() {
        if(size > 0) {
            Item last = (Item) new Object();
            if (nextLast != 0) {
                nextLast = nextLast - 1;
            } else if (nextLast == 0) {
                nextLast = items.length - 1;
            }
            last = items[nextLast];
            items[nextLast] = null;
            size -= 1;
            if (size * 4 < items.length && items.length < 16) {
                resize(size * 3);
            }
            return last;
        }
        else {
            return null;
        }
    }

    public Item get(int index) {
        if (index > size - 1) {
            return null;
        } else if (nextFirst + 1 + index < items.length) {
            return items[nextFirst + 1 + index];
        } else {
            return items[index - items.length + 1 + nextFirst];
        }
    }

}
