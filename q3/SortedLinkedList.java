public class SortedLinkedList implements SortedList {
    private Node head;
    private Node tail;
    private int size;
    private boolean ascending;

    public SortedLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.ascending = true;
    }

    public int size() { return size; }

    public void add(String string) { insertSingleNode(new Node(string)); }

    public void add(Node node) {
        if (node == null) return;

        Node currentToAdd = node;
        
        while (currentToAdd != null) {
            Node nextToAdd = currentToAdd.getNext();
            
            currentToAdd.setNext(null);
            currentToAdd.setPrev(null);
            
            insertSingleNode(currentToAdd);
            
            currentToAdd = nextToAdd;
        }
    }

    private void insertSingleNode(Node node) {
        if (node.getString() == null) return;

        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }

        Node current = head;
        while (current != null) {
            int cmp = current.getString().compareToIgnoreCase(node.getString());

            if (cmp == 0) return;
            
            boolean shouldInsertBefore = ascending ? (cmp > 0) : (cmp < 0);
            
            if (shouldInsertBefore) break;
            current = current.getNext();
        }

        if (current == head) {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        } else if (current == null) {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        } else {
            Node prevNode = current.getPrev();
            prevNode.setNext(node);
            node.setPrev(prevNode);
            node.setNext(current);
            current.setPrev(node);
        }
        size++;
    }

    public Node getFirst() { return head; }

    public Node getLast() { return tail; }

    public Node get(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public boolean isPresent(String string) {
        if (string == null) return false;
        Node current = head;
        while (current != null) {
            if (current.getString().equalsIgnoreCase(string)) return true;
            current = current.getNext();
        }
        return false;
    }

    public boolean removeFirst() {
        if (size == 0) return false;
        return removeInternal(head);
    }

    public boolean removeLast() {
        if (size == 0) return false;
        return removeInternal(tail);
    }

    public boolean remove(int index) {
        Node nodeToRemove = get(index);
        return removeInternal(nodeToRemove);
    }

    public boolean remove(String string) {
        if (string == null) return false;
        Node current = head;
        while (current != null) {
            if (current.getString().equalsIgnoreCase(string)) return removeInternal(current);
            current = current.getNext();
        }
        return false;
    }

    private boolean removeInternal(Node node) {
        if (node == null) return false;

        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = node.getNext();
            head.setPrev(null);
        } else if (node == tail) {
            tail = node.getPrev();
            tail.setNext(null);
        } else {
            Node prevNode = node.getPrev();
            Node nextNode = node.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
        }
        size--;
        return true;
    }

    public void orderAscending() {
        if (!ascending) {
            ascending = true;
            reverseList();
        }
    }

    public void orderDescending() {
        if (ascending) {
            ascending = false;
            reverseList();
        }
    }

    private void reverseList() {
        if (head == null || head == tail) return;

        Node current = head;
        Node temp = null;
        Node originalHead = head;

        while (current != null) {
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);
            current = current.getPrev(); 
        }

        if (temp != null) {
            tail = originalHead;
            head = temp.getPrev();
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getString());
            current = current.getNext();
        }
    }
}