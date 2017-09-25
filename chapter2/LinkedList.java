package chapter2;

public class LinkedList {
	Node head;
	
	class Node{
		int data;
		Node next;
		//constructor
		Node(int data)
		{
			this.data = data;
		}
	}
	
	//Insert a node at the beg in the list
	public void push(int value)
	{
		Node new_node = new Node(value);
		new_node.next = head;
		head = new_node;
	}
	
	public void insertAfter(Node prev_node,int data)
	{
		if(prev_node == null)
		{
			 System.out.println("The given previous node cannot be null");
	         return;
		}
		Node new_node = new Node(data);
		new_node.next = prev_node.next;
		prev_node = new_node;
	}
	
	public void append(int new_data)
    {
        Node new_node = new Node(new_data);
        if (head == null)
        {
            head = new Node(new_data);
            return;
        }
 
        new_node.next = null;

        Node last = head; 
        while (last.next != null)
            last = last.next;
 
        last.next = new_node;
        return;
    }
	 public void printList()
	    {
	        Node tnode = head;
	        while (tnode != null)
	        {
	            System.out.print(tnode.data+" ");
	            tnode = tnode.next;
	        }
	    }
	 
	 public Node reverse(Node head)
	 {
		 Node prev = null;
		 Node current = head;
		 Node next = null;
		 while(current!=null)
		 {
			 next = current.next;
			 current.next = prev;
			 prev = current;
			 current = next;
		 }
		 //returning the beg of the list
		 head = prev;
		 return head;
	 }
	 
	 //reverse list in a group of size
	 public Node reverseGroupK(Node head,int k)
	 {
		 Node prev = null;
		 Node current = head;
		 Node next = null;
		 int count = 0;
		 while(count < k && current!=null)
		 {
			 next = current.next;
			 current.next = prev;
			 prev = current;
			 current = next;
			 count++;
		 }
		 if(next!=null)
		 {
			 //here it is done so that we can connect the node with the reversed node after k subset.
			 head.next = reverseGroupK(next,k);
		 }
		 return prev;
	 }
	 
	 public Node addTwoList(Node head1, Node head2)
	 {
		 Node res = null; //head of result node.
		 Node prev = null;
		 Node temp = null;
		 int carry=0,sum;
		 while(head1!=null || head2!=null)
		 {
			sum = carry + (head1!=null ? head1.data : 0) + (head2!=null ? head2.data : 0);
			carry = (sum >= 10) ? 1:0;
			sum = sum%10;
			//now create new list with sum as a data.
			temp = new Node(sum);
			if(res == null)
			{
				res = temp;
			}
			else
			{
				prev.next = temp;
			}
			prev = temp;
			if(head1!=null)
				head1=head1.next;
			if(head2!=null)
				head2=head2.next;
		 }
		 if(carry>0)
		 {
			 temp.next = new Node(carry);
		 }
		 return res;
	 }
	 public static void main(String[] args)
	 {
	        LinkedList llist = new LinkedList();
	
	        llist.append(6);
	        llist.push(7);
	        llist.push(1);
	        llist.push(2);
	        llist.push(3);
	        llist.push(5);
	        llist.append(4);
	        llist.insertAfter(llist.head.next, 8);
	 
	        System.out.println("\nCreated Linked list is: ");
	        llist.head =  llist.reverseGroupK(llist.head, 3);
	        llist.printList();
	    }
	}
	 
