import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String simplifyPath(String path) {
        List<String> list = Arrays.stream(path.split("/"))
                .filter(s -> s.length() > 0)
                .collect(Collectors.toList());

        int index = 0;

        while (0 <=index && index < list.size()) {
            String s = list.get(index);

            switch (s) {
                case ".":
                    list.remove(index);
                    break;
                case "..":
                    list.remove(index--);
                    if (index >= 0) {
                        list.remove(index);
                    }else {
                        index = 0;
                    }
                    break;
                default:
                    index++;
                    break;
            }
        }

        StringBuilder result = new StringBuilder().append('/');
        for (String s : list) {
            result.append(s).append('/');
        }

        if (result.length() > 1) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}