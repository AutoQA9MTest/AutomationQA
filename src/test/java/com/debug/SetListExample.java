package com.debug;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetListExample {

	public static void main(String[] args) {
		//List Example
		System.out.println("List Example");
		List<String> arrList=new ArrayList<String>();
		arrList.add("x");
		arrList.add("b");
		arrList.add("a");
		arrList.add("a");
		for (String strItem : arrList) {
			System.out.println(strItem);
		}
		
		
		System.out.println("Set Example");
		Set<String> arrSet=new HashSet<String>(); 
		arrSet.add("x");
		arrSet.add("b");
		arrSet.add("a");
		arrSet.add("aaa");
		arrSet.add("z");
		arrSet.add("aa");
		
		Iterator<String> i=arrSet.iterator();  
         while(i.hasNext())  
         {  
         System.out.println(i.next());  
         }  
	}

}
