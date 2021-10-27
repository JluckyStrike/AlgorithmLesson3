package deque;


public class MyDeque<T> {
    private class Node{
        public T data;
        Node next;
        Node prev;

        public Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    int size = 0;

    public void insertLeft(T item){
        Node newNode = new Node(item);

        if (isEmpty()){
            tail = newNode;
            head = newNode;
        }else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void insertRight(T item){
        Node newNode = new Node(item);

        if (isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public void removeLeft(){
        if (head.next == null){
            tail = null;
            head = null;
        }else{
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    public void removeRight(){
        if (tail.prev == null){
            tail = null;
            head = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }

        size--;
    }

    public void insertAt(int index, T item){
        if (index < size){
            Node newNode = new Node(item);
            Node current = head;
            int i = 0;

            while (i < index){
                current = current.next;
                i++;
            }

            if (current == head){
                insertLeft(item);
            }
            else if (current == tail){
                insertRight(item);
            }else {
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }else{
            System.out.println("Неккоректный индекс");
        }

    }

    public void removeAt(int index){
        if (index < size){
            Node current = head;
            int i = 0;

            while (i < index){
                current = current.next;
                i++;
            }

            if (current == head){
                removeLeft();
            }
            else if (current == tail){
                removeRight();
            }else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                current = null;

            }
        }else{
            System.out.println("Неккоректный индекс");
        }

    }

    public void displayBack(){
        Node current = tail;

        while (current != null){
            System.out.println(current.data);
            current = current.prev;
        }
    }

    public void displayFront(){
        Node current = head;

        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
