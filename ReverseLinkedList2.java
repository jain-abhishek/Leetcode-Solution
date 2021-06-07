public class ReverseLinkedList2 {

	public static void main(String[] args) {
		ReverseLinkedList2 list = new ReverseLinkedList2();
		list.head = new ListNode(1);
		list.head.next = new ListNode(2);
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(4);
		list.head.next.next.next.next = new ListNode(5);
		
		ListNode respList = list.reverseBetween(list.head, 2, 4);
		while(respList != null) {
			System.out.print(respList.value);
			respList = respList.next;
		}
		
		System.out.println();
		
		respList = list.reverseBetween(list.head, 1, 5);
		while(respList != null) {
			System.out.print(respList.value);
			respList = respList.next;
		}
	}
	
	public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode cur = null;
        ListNode nxt = null;
        
        cur = head;
        int i = 1;
        ListNode lastFromLeft = head;
        
        while(i != left){
            lastFromLeft = cur;
            cur = cur.next;
            i++;
        }
        
        ListNode firstFromRigth = cur;
            
        while(i != right+1){
            i++;
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        firstFromRigth.next = cur;
        
        if(left == 1){
            return prev;
        }
        lastFromLeft.next = prev;
        
        return head;
    }

	private ListNode head = null;
	private static class ListNode{
		ListNode next;
		Integer value;
		
		public ListNode(Integer value) {
			this.value = value;
		}
	}
}
