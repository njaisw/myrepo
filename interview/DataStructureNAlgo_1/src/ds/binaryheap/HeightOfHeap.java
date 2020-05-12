package ds.binaryheap;

public class HeightOfHeap {

	static int height(int N) {
		return (int) Math.ceil(Math.log(N + 1) / Math.log(2)) - 1;
	}

	public static void main(String[] args) {
		int N = 6;
		System.out.println(height(N));
	}
}
