import java.util.*;

public class Test {
	public String[] solution(String[] strings, int n) {
		ArrayList<String> arrList = new ArrayList<>(Arrays.asList(strings));

		// Comparator 구현 -> n번째가 같다면 사전 순 배열
		Collections.sort(arrList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (o1.charAt(n) == o2.charAt(n)) {
					return o1.compareTo(o2);
				}
				return o1.charAt(n) - o2.charAt(n);
			}
		});
		return arrList.toArray(new String[strings.length]);
	}

	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.solution(new String[] { "sun", "bed", "car" }, 1));
	}
}
