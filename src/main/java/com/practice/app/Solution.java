package com.practice.app;

import java.util.Stack;


public class Solution{

	public int scoreOfString(String s){
		int score = 0;
		for(int i=0;i<s.length()-1;i++){
			int val1 = s.charAt(i);
			int val2 = s.charAt(i+1);
			score += Math.abs(val1-val2);
		}
		return score;
	}
}
