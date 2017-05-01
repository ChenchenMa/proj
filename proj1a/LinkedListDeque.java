public class LinkedListDeque <Item> {

    private class Node {
        public Item item;
        public Node next;
        public Node before;
        public Node (Item item, Node next, Node before){
            this.item = item;
            this.next = next;
            this.before = before;
        }
    }

    private Node Sentinal;
    private int size;

    public LinkedListDeque(){
    size = 0;
    Sentinal = new Node(null,null,null);
    Sentinal.next=Sentinal;
    Sentinal.before=Sentinal;
    }

    
    public void addFirst(Item item){
        size+=1;
        Sentinal.next = new Node(item, Sentinal.next, Sentinal);
        Sentinal.next.next.before=Sentinal.next;
    }

    public void addLast(Item item){
        Sentinal.before.next=new Node(item, Sentinal, Sentinal.before);
        Sentinal.before=Sentinal.before.next;
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
        Node currentNode = Sentinal.next;
        while(currentNode.next!=Sentinal){
            System.out.print(currentNode.item + " ");
            currentNode = currentNode.next;
        }
    }

    public Item removeFirst(){
        Node first = Sentinal.next;
        if(first==null) return null;
        Sentinal.next = Sentinal.next.next;
        Sentinal.next.before = Sentinal;
        size -= 1;
        return first.item;
    }

    public Item removeLast(){
        Node last = Sentinal.before;
        if(last==null) return null;
        Sentinal.before = Sentinal.before.before;
        Sentinal.before.next=Sentinal;
        size -=1;
        return last.item;
    }

    public Item get(int index){
        if(index+1>size) return null;
        Node currentNode = Sentinal.next;
        for(int i=0; i<index;i++){
        currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    private Item getRecursiveHelper(Node front, int index){
        if(front == null) return null;
        if(index == 0) return front.item;
        else return getRecursiveHelper(front.next, index-1);
    }

    public Item getRecursive(int index){
        return getRecursiveHelper(Sentinal.next, index);
    }

}