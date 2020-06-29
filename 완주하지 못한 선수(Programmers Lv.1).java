import java.util.*;

public class Test {

	// 정렬 후 값 비교
	public String solution(String[] participant, String[] completion) {
		int arrLen = completion.length;

		Arrays.sort(completion);
		Arrays.sort(participant);

		for (int i = 0; i < arrLen; i++) {
			if (!participant[i].equals(completion[i]))
				return participant[i];
		}
		return participant[arrLen];
	}

	// 해쉬맵 이용 (속도 더 빠름)
	public String solution2(String[] participant, String[] completion) {
		HashMap<String, Integer> hm = new HashMap<>();

		for (String player : participant)
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion)
			hm.put(player, hm.get(player) - 1);

		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			if (entry.getValue() != 0)
				return entry.getKey();
		}
		return "";
	}

	public static void main(String[] args) {
		String[] a = { "mislav", "stanko", "mislav", "ana" };
		String[] b = { "stanko", "ana", "mislav" };

		Test test = new Test();
		System.out.println(test.solution(a, b));
	}
}
