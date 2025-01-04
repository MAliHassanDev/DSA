package com.practice.app;



public class Solution{

	public ListNode reverseList(ListNode head){
		ListNode newHead = head;
		if(head.next == null){
			return head;
		};
		reverseList(head).next = null;
		return newHead;
	} 

	
}
