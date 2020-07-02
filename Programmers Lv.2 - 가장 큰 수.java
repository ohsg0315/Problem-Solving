import java.util.*;

public class Test {
	public String solution(int[] numbers) {
		ArrayList<String> arrList = new ArrayList<>();

		for (int buf : numbers)
			arrList.add(Integer.toString(buf));

		Collections.sort(arrList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		if (arrList.get(0).equals("0"))
			return "0";

		StringBuilder sb = new StringBuilder();
		for (String buf : arrList)
			sb.append(buf);

		return sb.toString();
	}

	public static void main(String[] args) {
		int[] a = { 3, 30, 34, 5, 9 };
		Test test = new Test();
		System.out.println(test.solution(a));
	}
}
