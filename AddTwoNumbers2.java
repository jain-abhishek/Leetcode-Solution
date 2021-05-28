// working 100%: not reversing: summing up the nodes which are at the same position without frwding the carry and keep adding the node in the front. eg: 1->9->9 & 2: 11->9->1. 
// Then take care of carry by adding node to the front. so 11->9->1 will become 2->0->1     

public class AddTwoNumbers2 {

	public static void main(String[] args) {
		AddTwoNumbers2 obj = new AddTwoNumbers2();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);

		ListNode l2 = new ListNode(9);
		
		ListNode resp = obj.addTwoNumbers(l1, l2);
		System.out.println(resp);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        
        ListNode x = l1;
        while(x != null){
            len1++;
            x = x.next;
        }
        
        ListNode y = l2;
        while(y != null){
            len2++;
            y = y.next;
        }        
    
        x = l1;
        y = l2;
        
        ListNode sumList = new ListNode(-1);
        ListNode z = sumList;
        
        while(len1 != 0 && len2 != 0){
            if(len1 > len2){
                while(len1 > len2){
                    z = x; 
                    x = x.next;
                    z.next = sumList;
                    sumList = z;
                    len1--;
                }
            }
            else if(len1 < len2){
                while(len1 < len2){
                    z = y;
                    y = y.next;
                    z.next = sumList;
                    sumList = z;
                    len2--;
                }
            }
            else{
                x.val = x.val + y.val;
                z = x;
                x = x.next;
                y = y.next;
                z.next = sumList;
                sumList = z;
                len1--;
                len2--;
            }
        }
        
        int sum = 0;
        int carry = 0;
        sumList = null;
        
        while(z.val != -1){
            sum = carry + z.val;
            if(sum/10 == 1){
                carry = 1;
                sum = sum %10;
            }
            else
            	carry = 0;
            
            y = new ListNode(sum);
            y.next = sumList;
            sumList = y;
            z = z.next;
        }
        
        if(carry == 1){
            y = new ListNode(1);
            y.next = sumList;
            sumList = y;
        }
        
        return sumList;
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
