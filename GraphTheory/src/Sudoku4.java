
import java.util.HashMap;

public class Sudoku4 {

	int grid[][] = {

			{ 2, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			/*
			 * {3, 0, 0, 0, 0, 8, 4, 0, 0}, {5, 2, 0, 0, 0, 0, 0, 0, 0}, {0, 8, 7, 0, 0, 0,
			 * 0, 3, 1}, {0, 0, 3, 0, 1, 0, 0, 8, 0}, {9, 0, 0, 0, 6, 3, 0, 0, 5}, {0, 5, 0,
			 * 0, 9, 0, 6, 0, 0}, {1, 3, 0, 0, 0, 0, 2, 5, 0}, {0, 0, 0, 0, 0, 0, 0, 7, 4},
			 * {0, 0, 0, 2, 0, 6, 3, 0, 0}
			 * 
			 */
	};

	HashMap<Integer, String> posis = new HashMap<Integer, String>();

	public boolean isAllowed(int val, int index) {
		String e = posis.get(index);
		String arr[] = e.split(",");
		int row = Integer.parseInt(arr[0]);
		int col = Integer.parseInt(arr[1]);

		if (isPresentInBlock(val, row, col) || isPresentInColumn(val, row) || isPresentInRow(val, col)) return true;
		
		return false;
	}

	public void show() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean solve(int index) {

		if (isFull()) {
			show();
			return true;
		}
		for (int val = 1; val < 10; val++) {
			if (!isAllowed(val, index)) {
				assign(val, index);
				if (solve(index + 1)) {
					return true;
				}
			}

		}
		unassign(index);
		return false;
	}

	public void assign(int val, int index) {
		String e = posis.get(index);
		String arr[] = e.split(",");
		int row = Integer.parseInt(arr[0]);
		int col = Integer.parseInt(arr[1]);
		grid[row][col] = val;
	}

	public void unassign(int index) {
		String e = posis.get(index);
		String arr[] = e.split(",");
		int row = Integer.parseInt(arr[0]);
		int col = Integer.parseInt(arr[1]);
		grid[row][col] = 0;
	}

	public boolean isFull() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isPresentInRow(int val, int column) {
		for (int i = 0; i < 9; i++) {
			if (val == grid[i][column]) {
				return true;
			}
		}

		return false;
	}

	public boolean isPresentInColumn(int val, int row) {
		for (int i = 0; i < 9; i++) {
			if (val == grid[row][i]) {
				return true;
			}
		}

		return false;
	}

	public boolean isPresentInBlock(int val, int row, int column) {
		int i, j;

		if (row <= 2) {
			j = 0;
			if (column <= 2) {
				i = 0;
			} else if (column <= 5) {
				i = 3;
			} else {
				i = 6;
			}

		} else if (row <= 5) {
			j = 3;
			if (column <= 2) {
				i = 0;
			} else if (column <= 5) {
				i = 3;
			} else {
				i = 6;
			}

		} else {
			j = 6;
			if (column <= 2) {
				i = 0;
			} else if (column <= 5) {
				i = 3;
			} else {
				i = 6;
			}

		}

		for (int k = i; k < i + 3; k++) {
			for (int l = j; l < j + 3; l++) {
				if (val == grid[l][k]) {
					return true;
				}

			}
		}
		return false;
	}

	public static void main(String args[]) {
		try {
			Sudoku4 s = new Sudoku4();
			System.out.println("-----Start sudoku solver----");
			s.possibility();
			s.solve(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("--Solved--");
		}
	}

	public void possibility() {
		String e;
		int k = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == 0) {
					e = new String(i + "," + j);
					posis.put(k, e);
					k++;
				}
			}
		}

	}

}