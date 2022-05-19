public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(909);
        ListNode iterator = head;
        while (true){
            int index = 909;
            int min = Integer.MAX_VALUE;
            int countOfNull = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode itr = lists[i];
                if(itr != null){
                    if(itr.val < min){
                        min = itr.val;
                        index = i;
                    }
                }else{
                    countOfNull++;
                }
            }
            if(countOfNull != lists.length) {
                iterator.next = lists[index];
                iterator = iterator.next;
                lists[index] = lists[index].next;
            }else{
                iterator.next = null;
                break;
            }
        }
       return head.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[0];
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(1);
        ListNode fourthNode = new ListNode(4);
        firstNode.next = secondNode;
        secondNode.next = null;
        thirdNode.next = fourthNode;
        fourthNode.next = null;
//        listNodes[0] = firstNode;
//        listNodes[1] = thirdNode;
        ListNode itr = mergeKLists(listNodes);
        while (itr != null){
            System.out.println(itr.val);
            itr = itr.next;
        }
    }
}
