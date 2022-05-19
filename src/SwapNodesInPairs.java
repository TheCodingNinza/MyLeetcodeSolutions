public class SwapNodesInPairs {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode swapPairs(ListNode head) {
        ListNode itr1 = new ListNode(909,head);
        ListNode itr2 = null;
        if(itr1.next != null){
            itr2 = itr1.next.next;
        }
        if(itr2 != null)
            head = itr2;
        else{
            if(itr1 != null)
                head = itr1.next;
            else
                head = null;
        }
        while(itr1 != null && itr2 != null){
            ListNode middleNode = itr1.next;
            itr1.next = itr2;
            ListNode nextNode = itr2.next;
            itr2.next = middleNode;
            middleNode.next = nextNode;
            itr1 = middleNode;
            if(nextNode != null)
                itr2 = nextNode.next;
            else
                itr2 = null;
        }
        return head;
    }

}
