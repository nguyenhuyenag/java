package learn.oop.tight.coupling;

public class ComplexService {

	private Sort sortAlgorithm;

	public ComplexService(Sort sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}

	public void business(int[] array) {
		sortAlgorithm.sort(array);
	}

	public static void main(String[] args) {

		Sort bubbleSort = new BubbleSort();
		ComplexService business1 = new ComplexService(bubbleSort);
		business1.business(new int[0]);

		Sort quickSort = new QuickSort();
		ComplexService business2 = new ComplexService(quickSort);
		business2.business(new int[0]);
	}

}
