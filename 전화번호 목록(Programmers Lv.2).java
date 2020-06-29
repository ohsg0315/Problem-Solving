import java.util.*;

public class Test {
	public boolean solution(String[] phone_book) {
		for (String pre : phone_book) {
			for (String tp : phone_book) {
				if (pre.equals(tp))
					continue;
				
				if (tp.startsWith(pre))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] a = { "mislav", "stanko", "mislav", "ana" };
		String[] b = { "stanko", "ana", "mislav" };

		Test test = new Test();
		System.out.println(test.solution(a));
	}
}
