public class partitionList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
//        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        l5.next = l6;
        partition(l1,2);
        System.out.println(2%0);

    }

    //solution1: brute force, put smaller nodes before x, and greater nodes after x.
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode pnext = dummy;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = dummy;
        while(curr != null){
            if(curr.val >= x ) {
                prev = curr;
                curr = curr.next;
                continue;
            }
            else {
                if(p.next == curr){
                    p = p.next;
                    prev = curr;
                    curr = curr.next;
                }else{
                    pnext = p.next;
                    next = curr.next;
                    p.next = curr;
                    curr.next = pnext;
                    prev.next = next;
                    p = p.next;
                    // prev = pnext;
                    curr = next;
                }
            }
        }
        return dummy.next;
    }

    //solution 2: partition the list and split them into 2 list2
    //head1 leads the smaller nodes
    //head2 leads the greater nodes
    //then concatenate two lists
    public static ListNode partition2(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode head1 = dummy1;
        ListNode head2 = dummy2;
        ListNode curr = head;
        ListNode prev = curr;
        ListNode tail = head1;
        while(curr != null){
            prev = curr;
            if(curr.val < x){
                head1.next = curr;
                head1 = head1.next;
                tail = curr;
            }else {
                head2.next = curr;
                head2 = head2.next;
            }
            curr = curr.next;
            prev.next = null;
        }
        tail.next = dummy2.next;

        return dummy1.next;
    }

}

