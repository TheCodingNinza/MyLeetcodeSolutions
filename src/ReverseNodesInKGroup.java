public class ReverseNodesInKGroup {
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if( k == 1)
            return head;
        ListNode start = new ListNode(909);
        start.next = head;
        ListNode answerNode = start;
        ListNode end = start;
        int count = 0;
        while(true){
            end = end.next;
            if(end == null)
                break;
            if(count < k-1)
                count++;
            else{
                count = 0;
                start = reverseIt(start,end);
                end = start;
            }
        }
        answerNode = answerNode.next;
        return answerNode;
    }

    public static ListNode reverseIt(ListNode start, ListNode end){
          ListNode itr = start.next;
          ListNode nextNode = null;
          while(itr != end){
              if(nextNode == null)
                nextNode = itr.next;
              ListNode tmp = nextNode.next;
              nextNode.next = itr;
              itr = nextNode;
              nextNode = tmp;
          }
          ListNode tmp = start.next;
          start.next = itr;
          tmp.next = nextNode;
          return tmp;
    }

    public static void main(String args[]){
          ListNode firstNode = new ListNode(1);
          ListNode secondNode = new ListNode(2);
          firstNode.next = secondNode;
          ListNode thirdNode = new ListNode(3);
          secondNode.next = thirdNode;
          ListNode fourthNode = new ListNode(4);
          thirdNode.next = fourthNode;
          ListNode fifthNode = new ListNode(5);
          fourthNode.next = fifthNode;
          fifthNode.next = null;
          ListNode itr = reverseKGroup(firstNode,1);
          while (itr != null){
              System.out.println(itr.val);
              itr = itr.next;
          }
    }

}
