package _com.ds.multithreaded;

import java.util.ArrayList;
import java.util.List;

public class MergeNPrintSortedArrays {

	static public class mergeKList implements Runnable {
		
		private static volatile List<int[]> myList = new ArrayList();
		
		//private Object
		
		

		public mergeKList(int [] arry) {
			myList.add(arry);
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args) {

		List<int[]> myList = new ArrayList();
		int[] arr1 = new int[] { 2, 10 };
		int[] arr2 = new int[] { 1, 14 };
		int[] arr3 = new int[] { 5, 7 };
		int[] arr4 = new int[] { 3, 9 };
		int[] arr5 = new int[] { 4, 5 };

		myList.add(arr1);
		myList.add(arr2);
		myList.add(arr3);
		myList.add(arr4);
		myList.add(arr5);

	}

}
