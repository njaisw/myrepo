package ds.greedy;

//Java program to solve fractional Knapsack Problem 
import java.util.Arrays;
import java.util.Comparator;

//Time complexity O(n log n) 
public class _17_FractionalKnapsack_IMP_2 {

	public static void main(String[] args) {
		int[] wt = { 10, 40, 20, 30 };
		int[] val = { 60, 40, 100, 120 };
		int capacity = 50;
		double maxValue = getMaxValue(wt, val, capacity);
		System.out.println("Maximum value we can obtain = " + maxValue);

	}

	// function to get maximum value
	private static double getMaxValue(int[] wt, int[] val, int capacity) {
		ItemValue[] iVal = new ItemValue[wt.length];
		for (int i = 0; i < wt.length; i++) {
			iVal[i] = new ItemValue(wt[i], val[i], i);
		}

		// IMPORTANT: sorting items by Cost; Max cost will appear first
		Arrays.sort(iVal, new Comparator<ItemValue>() {
			@Override
			public int compare(ItemValue o1, ItemValue o2) {
				return (int) (o2.cost - o1.cost);
			}
		});

		double totalValue = 0d;

		for (ItemValue i : iVal) {
			int curWt = (int) i.wt;
			int curVal = (int) i.val;
			if (capacity - curWt >= 0) {// this weight can be picked while
				capacity = capacity - curWt;
				totalValue += curVal;
			} else {// item cant be picked whole
				double fraction = ((double) capacity / (double) curWt);
				totalValue += (curVal * fraction);
				capacity = (int) (capacity - (curWt * fraction));
				break;
			}
		}
		return totalValue;

	}

	static class ItemValue {
		Double cost;
		double wt, val, ind;

		public ItemValue(int wt, int val, int ind) {
			this.wt = wt;
			this.val = val;
			this.ind = ind;
			cost = new Double(val / wt);
		}
	}
}
