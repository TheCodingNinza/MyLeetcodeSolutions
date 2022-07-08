public class RemoveNthNodeFromEndOfList {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode removeNthFromEnd(ListNode head, int n) {
          ListNode start  = new ListNode(-999,head);
          ListNode itr1 = start, itr2 = start;
          int count = 0;
          while (count < n){
              itr2 = itr2.next;
              count++;
          }
          while (itr2.next != null){
              itr2 = itr2.next;
              itr1 = itr1.next;
              itr1.next = itr2;
          }
          return start.next;

    }
}
