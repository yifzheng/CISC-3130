
public class Hello_World {
	public static void main(String[] args) {
		char[] array = {'M', 'O', 'N', 'D', 'A', 'Y'};
		char[] sortArr = bubbleSort(array);
		for (char x : sortArr) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
		char[] sortArr1 = insertionSort(array);
		for (char x : sortArr1) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
		char[] sortArr2 = selectionSort(array);
		for (char x : sortArr2) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
		System.out.println(linearSearch(array));
		System.out.println(binarySearch(sortArr1, 0, sortArr1.length - 1));
	}
	public static char[] bubbleSort(char[] arr) { 
		char temp = 0;
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (((int)arr[j + 1]) < ((int)arr[j])) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static char[] insertionSort(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			char temp = arr[i];
			int j = i;
			while (j > 0 && (int)arr[j - 1] > (int)temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
		return arr;
	}
	
	public static char[] selectionSort(char[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (((int)arr[j]) < ((int)arr[i])) {
					min = j;
				}
			}
			char temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		return arr;
	}
	
	public static char linearSearch(char[] arr) {
		char min = arr[0];
		for (int i = 1; i < arr.length - 1; i++) {
			if ((int)min > (int)arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}
	
	public static char binarySearch(char[] arr, int low, int high) {
		int mid = (high + low)/2;
		char val = arr[mid];
		if (high < low) {
			return val;
		}
		if ((int)val > (int)arr[mid +1]) {
			return binarySearch(arr, mid + 1, high);
		}
		else if ((int)val < (int)arr[mid - 1]) {
			return binarySearch(arr, low, mid);
		}
		else {
			return val;
		}
	}
}
