class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        result[0] = 0;

        int length = 1, half = length / 2, cnt = 0;
        for (int i = 1, size = n + 1; i < size; i++) {
            if (cnt < half) {
                result[i] = result[i - half];
            } else {
                result[i] = result[i - half] + 1;
            }

            cnt++;
            if (cnt == length) {
                half = length;
                length += cnt;
                cnt = 0;
            }
        }

        return result;
    }
}