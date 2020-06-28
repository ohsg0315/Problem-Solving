import java.util.*;

public class Test {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++)
        	hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 1) + 1);
        
        for(String type : hm.keySet())
        	answer *= hm.get(type);
        
        return answer - 1;
    }
    
	public static void main(String[] args) {
		Test test = new Test();
	}
}
