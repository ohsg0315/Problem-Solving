class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder result = new StringBuilder();

        int z = k / 26;
        k %= 26;

        while (k < n - z) {
            z--;
            k += 26;
        }

        for (int i = 0; i < z; i++) {
            result.append('z');
            n--;
        }

        while (n > 0 && k > 0) {
            int weight = k - n + 1;
            n--;
            k -= weight;

            char c = (char) (weight + 'a' - 1);
            result.append(c);

        }

        return result.reverse().toString();
    }
}