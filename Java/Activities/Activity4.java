package Activities;

public class Activity4 {

	static void display(int a[]) {
		for (int i : a) {
			System.out.print(" " + i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int a[] = { 6, 24, 7, 435, 75, 16, 33 };
		int n = a.length;

		System.out.print("Before sorting:");
		display(a);

		for (int i = 1; i < n; i++) {
			int key = a[i];
			int j = i - 1;

			while (j >= 0 && key < a[j]) {
				a[j + 1] = a[j];
				--j;
			}
			a[j + 1] = key;
		}

		System.out.print("After sorting:");

		display(a);

	}

}
