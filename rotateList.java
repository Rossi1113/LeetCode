public class rotateList {
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
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        rotateRight1(l1,3);
    }
    public static ListNode rotateRight1(ListNode head, int n) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null || k <= 0)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        ListNode prev = slow;
        ListNode tail = fast;
        dummy.next = head;
        int count = 0;
        while(fast.next != null && k > count){  //fast move k steps first. or fast move to the end if k is bigger
            fast = fast.next;
            count++;
        }
        if(k > count){
            int step  = k % count; // if k is bigger , locate the real node which needs rotate
            return rotateRight2(head,step);
        }else {
            while(fast != null){
                prev = slow;
                slow = slow.next;
                tail = fast;
                fast = fast.next;
            }  //fast is always k steps further, when fast is at the end, slow will locate on the kth node from the end.
            prev.next = null; //cut the previous node and slow node.
            tail.next = dummy.next;// connect tail node to head
            dummy.next = slow;//connect head to slow
        }
        return dummy.next;
    }
}
