package ds.divideNConquer;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 * Solution Take minimum size of two array. Possible number of partitions are
 * from 0 to m in m size array. Try every cut in binary search way. When you cut
 * first array at i then you cut second array at (m + n + 1)/2 - i Now try to
 * find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition
 * around which lies the median.
 *
 * Time complexity is O(log(min(x,y)) Space complexity is O(1)
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4
 */
public class MedianOfTwoSortedArrayOfDifferentLength_IMP_3 {

	public double findMedianSortedArrays(int a[], int b[]) {
		// if input1 length is greater than switch them so that input1 is smaller than
		// input2.
		if (a.length > b.length) {
			return findMedianSortedArrays(b, a);
		}
		int aLen = a.length;
		int bLen = b.length;

		int alow = 0;
		int ahigh = aLen;
		while (alow <= ahigh) {
			int partitionX = (alow + ahigh) / 2;
			int partitionY = (aLen + bLen + 1) / 2 - partitionX;

			// if partitionX is 0 it means nothing is there on left side. Use -INF for
			// maxLeftX
			// if partitionX is length of input then there is nothing on right side. Use
			// +INF for minRightX
			int xLeft = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX - 1];
			int xRight = (partitionX == aLen) ? Integer.MAX_VALUE : a[partitionX];

			int yLeft = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY - 1];
			int yRight = (partitionY == bLen) ? Integer.MAX_VALUE : b[partitionY];

			if (xLeft <= yRight && yLeft <= xRight) {
				// We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get the median in
				// case of even length combined array size
				// or get max of left for odd length combined array size.
				if ((aLen + bLen) % 2 == 0) {
					return ((double) Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2;
				} else {
					return (double) Math.max(xLeft, yLeft);
				}
			} else if (xLeft > yRight) { // we are too far on right side for partitionX. Go on left side.
				// TODO remember the condition
				ahigh = partitionX - 1;
			} else { // we are too far on left side for partitionX. Go on right side.
				alow = partitionX + 1;
			}
		}

		// Only we we can come here is if input arrays were not sorted. Throw in that
		// scenario.
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		int[] x = { 1, 3, 8, 9, 15 };
		int[] y = { 7, 11, 19, 21, 18, 25 };

		MedianOfTwoSortedArrayOfDifferentLength_IMP_3 mm = new MedianOfTwoSortedArrayOfDifferentLength_IMP_3();
		System.out.println(mm.findMedianSortedArrays(x, y));
	}
}
