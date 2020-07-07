import java.util.*;

public class Test {
	public String solution(int a, int b) {
		int[] month = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] day = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
		int cnt = 0;

		// 1월 1일 ~ 목표 전 달까지 일 수 계산
		for (int i = 0; i < a; i++) {
			cnt += month[i];
		}
		// 해당 달 날짜 계산
		cnt += b;
		
		return day[cnt % 7];
	}

	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.solution(5, 24));
	}
}
