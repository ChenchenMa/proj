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

    private void resize(int capacity, int start) {
        Item[] a = (Item[]) new Object[capacity];
        if (nextLast < nextFirst) {
            System.arraycopy(items, 0, a, start, size);
        } else {
            System.arraycopy(items, nextLast, a, start, size - nextLast);
            System.arraycopy(items, 0, a, start + size - nextLast, nextFirst + 1);
        }
        items = a;
        nextLast = start + size;
        nextFirst = start - 1;
    }

    public void addFirst(Item item) {
        if (size == items.length) {
            resize(size * 3, size);
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
            resize(size * 3, size);
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
        return (size == 0)
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (nextLast - nextFirst + 1 == size) {
            for (int i = 0; i < size; i++) {
                System.out.print(items[nextFirst + i + 1] + " ");
            }
        } else if (nextFirst < nextLast) {
            for (int i = nextFirst + 1; i < items.length; i++) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print(items[i] + "");
            }
        }
    }

    public Item removeFirst() {
        if (size * 4 < items.length) {
            resize(size * 3, size);
        }
        Item first = (Item) new Object();
        if (size >= 1) {
            if (nextFirst != items.length - 1) {
                first = items[nextFirst + 1];
                nextFirst += 1;
            } else (nextFirst == items.length - 1) {
                first = items[0];
                nextFirst = 0;
            }
            size -= 1;
            return first;
        }
        else {
            return null;
        }

    }

    public Item removeLast() {
        if (size * 4 < items.length) {
            resize(size * 3, size);
        }
        Item last = (Item) new Object();
        if(size > 0) {
            if (nextLast != 0) {
                last = items[nextLast - 1];
                nextLast = nextLast - 1;
            } else (nextLast == 0) {
                last = items[items.length - 1];
                nextLast = items.length - 1;
            }
            size -= 1;
            return last;
        }
        else {
            return null;
        }
    }

    public Item get(int index) {
        if (index > size) {
            return null;
        } else if (nextFirst + 1 + index < items.length) {
            return items[nextFirst + 1 + index];
        } else {
            return items[index - items.length + 1 + nextFirst];
        }
    }

}
