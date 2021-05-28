public class AddTwoNumbers2 {

	public static void main(String[] args) {
		AddTwoNumbers2 obj = new AddTwoNumbers2();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);

		ListNode l2 = new ListNode(2);
		
		ListNode resp = obj.addTwoNumbers(l1, l2);
		System.out.println(resp);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        int carry = 0;
        ListNode sumList = new ListNode(-1); 
        ListNode x = sumList;
        int sum = 0;
        
        while(l1 != null || l2 != null){
            sum = carry;
            
            if(l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            if(sum / 10 == 1){
                sum = sum % 10;
                carry = 1;
            }
            else
            	carry = 0;
            
            x.next = new ListNode(sum);
            
            x = x.next;
            
        }
        
        if(carry == 1)
            x.next = new ListNode(1);
        
        return reverse(sumList.next);
    }
    
    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    private static class ListNode {
		private ListNode next;
		private int val;

		public ListNode(int value) {
			this.val = value;
		}

		public ListNode(int value, ListNode next) {
			this.val = value;
			this.next = next;
		}
	}
}
