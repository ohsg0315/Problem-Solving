import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int needs;
	private static boolean flag;
	private static int[][] board;
	private static StringBuilder sb;

	private static boolean isRight(int r, int c, int value) {

		// 행, 열 검사
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == value || board[i][c] == value)
				return false;
		}

		// 3 X 3 블록 검사
		int blockR = (r / 3) * 3, blockC = (c / 3) * 3;
		for (int i = blockR; i < blockR + 3; i++) {
			for (int j = blockC; j < blockC + 3; j++) {
				if (board[i][j] == value)
					return false;
			}
		}
		return true;
	}

	private static void find(int cnt, int r, int c) {
		if (cnt == needs) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]).append(' ');
				}
				sb.setCharAt(sb.length() - 1, '\n');
			}
			flag = true;
			return;
		}

		// 0이 아닌 수
		if (board[r][c] != 0) {
			if (c == 8)
				find(cnt, r + 1, 0);
			else
				find(cnt, r, c + 1);
		}

		// 0 이면 수를 채운다
		else {
			for (int i = 1; i < 10; i++) {
				if (isRight(r, c, i)) {
					board[r][c] = i;

					if (c == 8)
						find(cnt + 1, r + 1, 0);
					else
						find(cnt + 1, r, c + 1);

					board[r][c] = 0;
				}

				// 종료 플래그
				if (flag)
					return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		board = new int[9][9];
		sb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(tokenizer.nextToken());

				if (board[i][j] == 0)
					needs++;
			}
		}
		find(0, 0, 0);
		System.out.print(sb.toString());
	}
}
