package main;

import java.util.Comparator;

public class Day1LamdaExpression {

	public static void main(String... args) {
		
		
		
        //BEFORE
		
		  Comparator<Integer> comparator1 = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2); // -1 , +1 , 0
			}
		};
		
		System.out.println(comparator1.compare(12, 12));
		
		
		
		
		//AFTER 
		Comparator<Integer>  comparator2 = (Integer o1,Integer o2) -> o1.compareTo(o2);
		System.out.println(comparator2.compare(4, 5));
	
	}	
}
























//
//
////Before
//		Runnable r1 = new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("\nHi I am from r1 run method1");
//				System.out.println("Hi I am from r1 run method2");
//				System.out.println("Hi I am from r1 run method3");
//			}
//		};
//		
//		
//		 new Thread(r1).start();
//       
//		
//		
//		//AFter
//		 
//	    Runnable r2 = () -> {
//	    	 System.out.println("\nHi I am from r2 run method1");
//	    	 System.out.println("Hi I am from r2 run method2");
//	    	 System.out.println("Hi I am from r2 run method3");
//	    };
//	
//	    new Thread(r2).start();
//
//
//
//















