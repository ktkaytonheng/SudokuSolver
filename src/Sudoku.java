
public class Sudoku {
	int[][] puzzle;
	
	public Sudoku() {
		this.puzzle = new int[9][9];
	}
	
	public Sudoku(int[] arr1d) { 
		this.puzzle = new int[9][9];
		int arrPtr = 0;
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				this.puzzle[i][j] = arr1d[arrPtr];
				arrPtr++;
			}
		}
	}
	
	public Sudoku(int[][] arr2d) {
		this.puzzle = new int[9][9];
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				this.puzzle[i][j] = arr2d[i][j];
			}
		}
	}
	
	public void printPuzzle() {
		int vcounter = 0;
		int hcounter = 0;
		System.out.println("-------------------------");
		for (int i=0; i<9; i++) {
			System.out.print("| ");
			for (int j=0; j<9; j++) {
				System.out.print(this.puzzle[i][j] + " ");
				if (vcounter == 2) {
					vcounter = 0;
					System.out.print("| ");
					continue;
				}
				vcounter++;
			}
			System.out.println();
			if (hcounter == 2) {
				hcounter = 0;	
				System.out.println("-------------------------");
				continue;
			}
			hcounter++;
		}
	}
	
	public void updateCell(int row, int col, int val) {
		if (row >= 9 || col >= 9) {
			System.out.println("Row or col must be 1-9");
			return;
		}
		this.puzzle[row-1][col-1] = val;
	}
	
	public void fillPuzzleWithOnes() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				this.puzzle[i][j] = 1;
			}
		}
	}
	
	public void fillPuzzleWithZeroes() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				this.puzzle[i][j] = 0;
			}
		}
	}
	
	private boolean isValInRow(int row, int col, int val) {
		for (int i=0; i<9; i++) {
			if (i == col) continue;
			if (this.puzzle[row][i] == val) return true;
		}
		return false;
	}
	
	private boolean isValInCol(int row, int col, int val) {
		for (int i=0; i<9; i++) {
			if (i == row) continue;
			if (this.puzzle[i][col] == val) return true;
		}
		return false;
	}
	
	private boolean isValInBox(int row, int col, int val) {
		int boxRow = row - row % 3;
		int boxCol = col - col % 3;
		for (int i=boxRow; i<boxRow+3; i++) {
			for (int j=boxCol; j<boxCol+3; j++) {
				if (i == row && j == col) continue;
				if (this.puzzle[i][j] == val) return true;
			}
		}
		return false;
	}
	
	private boolean isValidPlacement(int row, int col, int val) {
		return !isValInRow(row, col, val) &&
				!isValInCol(row, col, val) &&
				!isValInBox(row, col, val);
	}
	
	public boolean checkIfSolved() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (this.puzzle[i][j] == 0) return false;
				if (!this.isValidPlacement(i, j, this.puzzle[i][j])) return false;
			}
		}
		return true;
	}
	
	public boolean solve() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (this.puzzle[i][j] == 0) {
					for (int numToTry=1; numToTry<=9; numToTry++) {
						if (this.isValidPlacement(i, j, numToTry)) {
							this.puzzle[i][j] = numToTry;
							if (solve()) return true;
							else this.puzzle[i][j] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}
}
