package no.hvl.dat102.klient;

public class TestV2016 {

	public static void main(String[] args) {
		int[] tab = {4, 1, 7, 3, 2};
		System.out.print("[ ");
		for (int t : tab) {
			System.out.print(t + " ");
		}
		System.out.print("]");
		System.out.println();
		
		insertionSort(tab);
		

	}

	public static void insertionSort(int[] data) {
		  for (int i = 1; i < data.length; i++) {
		    int el = data[i];
		    
		    int pos = 0;
		    boolean posFunnet = false;
		    while (pos <= i && !posFunnet) {
		      if (el <= data[pos]) {//(el.compareTo(data[pos]) <= 0) {
		        posFunnet = true;
		      } else {
		        pos++;
		      }
		    }
		    if (!(pos == i)) {
		      for (int j = i; j > pos; j--) {
		        data[j] = data[j-1];
		      }
		      data[pos] = el;
		    }
		    System.out.print("[ ");
			for (int t : data) {
				System.out.print(t + " ");
			}
			System.out.print("]");
			System.out.println();
		  }
		}
}
