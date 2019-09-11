package tight.coupling;

public class ComplexService {

	private SortAlgorithm sortAlgorithm;

	public ComplexService(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}

	public void business(int[] array) {
		sortAlgorithm.sort(array);
	}

	public static void main(String[] args) {

		SortAlgorithm bubbleSort = new BubbleSortAlgorithm();
		ComplexService business1 = new ComplexService(bubbleSort);
		business1.business(new int[0]);

		SortAlgorithm quickSort = new QuickSortAlgorithm();
		ComplexService business2 = new ComplexService(quickSort);
		business2.business(new int[0]);
	}

}
