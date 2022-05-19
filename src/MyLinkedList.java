public class MyLinkedList {
    public class Node{
        int val;
        int index;
        Node prev;
        Node next;

        public Node(int val, int index, Node prev, Node next) {
            this.val = val;
            this.index = index;
            this.prev = prev;
            this.next = next;
        }

        public Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
            this.index = -1;
        }
    }

    Node root;

    public MyLinkedList() {
        this.root = new Node(-999);
        this.root.index = -1;
    }



    public int get(int index) {
        Node itr = this.root;
        while (itr.next != null){
            itr = itr.next;
            if(itr.index == index)
                return itr.val;
        }
        return -1;
    }

    public void addAtHead(int val) {

    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}
