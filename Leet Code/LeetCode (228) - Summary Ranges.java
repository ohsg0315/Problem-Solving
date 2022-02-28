import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int start = 0, before = 0;
        boolean isNew = true;
        for (int number : nums) {
            if (!isNew && number - before != 1) {
                isNew = true;

                if (start == before) {
                    result.add(Integer.toString(start));
                } else {
                    result.add(start + "->" + before);
                }
            }

            if (isNew) {
                start = number;
                isNew = false;
            }

            before = number;
        }
        if (start == before) {
            result.add(Integer.toString(start));
        } else {
            result.add(start + "->" + before);
        }

        return result;
    }
}