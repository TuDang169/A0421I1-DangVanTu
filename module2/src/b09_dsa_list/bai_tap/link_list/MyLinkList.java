package b09_dsa_list.bai_tap.link_list;

public class MyLinkList<E> {

    private class Node{
        private Node next;
        private Object data;

        public Node(Object data){
            this.data = data;
        }

        public Object getData(){
            return this.data;
        }
    }

    private Node head;
    private int numNodes = 0;

    public MyLinkList(){

    }

    public void addFirst(E element){
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;

    }

    public void add(int index, E element){
        Node temp = head;
        Node holder;

        for (int i = 0; i< index -1 && temp.next != null; i++){
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next =  holder;
        numNodes++;
    }

    public Object get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp  = temp.next;
        }
        return temp.data;
    }

    public int size(){
        return numNodes;
    }

    public E remove(int index){
        if (index < 0 || index > numNodes){
            throw new IllegalArgumentException("Error Index: "+index);
        }
        Node temp = head;
        Object data;

        if (index == 0){
            data = temp.data;
            head = head.next;
        } else {
            for (int i = 0; i< index -1 && temp.next != null; i++){
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes++;
        }
        return (E) data;
    }

    public boolean remove(E element){
        if (head.data.equals(element)){
            remove(0);
        } else {
                Node temp = head;
                while (temp.next != null){
                    if (temp.next.data.equals(element)){
                        temp.next = temp.next.next;
                        numNodes--;
                        return true;
                    }
                    temp = temp.next;
                }
            }
        return false;
    }

    public MyLinkList<E> clone(){
        if (numNodes == 0){
            throw new NullPointerException("LinkedList is Null");
        }
        MyLinkList<E> returnLinkedList = new MyLinkList<>();
        Node temp = head;
        returnLinkedList.addFirst((E) temp);
        temp = temp.next;
        while (temp != null){
            returnLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }

    public boolean constrains(E element){
        Node temp = head;
        while (temp.next != null){
            if (temp.data.equals(element)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E element){
        Node temp = head;
        for (int i = 0; i < numNodes; i++){
            if (temp.getData().equals(element)){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
}
