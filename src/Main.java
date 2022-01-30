
public class Main {

	public static void main(String[] args) {
		int[] arr1d = new int[] {
				0,0,0,0,0,0,2,0,0,
				0,8,0,0,0,7,0,9,0,
				6,0,2,0,0,0,5,0,0,
				0,7,0,0,6,0,0,0,0,
				0,0,0,9,0,1,0,0,0,
				0,0,0,0,2,0,0,4,0,
				0,0,5,0,0,0,6,0,3,
				0,9,0,4,0,0,0,7,0,
				0,0,6,0,0,0,0,0,0,
		};
		Sudoku sudoku = new Sudoku(arr1d);
		sudoku.printPuzzle();
		System.out.println(sudoku.checkIfSolved());
		if (!sudoku.solve()) System.out.println("Unsolvable");
		sudoku.printPuzzle();
		System.out.println(sudoku.checkIfSolved());
	}

}
