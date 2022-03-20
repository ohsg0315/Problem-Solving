class Solution {
    private int compareArray(int target, int[] first, int[] second) {
        int result = 0;
        for (int i = 0, length = first.length; i < length; i++) {
            if (first[i] != target) {
                if (second[i] != target) {
                    return -1;
                }
                result++;
            }
        }
        return result;
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[][] number = new int[2][7];

        for (int i = 0, length = tops.length; i < length; i++) {
            number[0][tops[i]]++;
            number[1][bottoms[i]]++;
        }

        for (int i = 1, length = tops.length; i < 7; i++) {
            if (number[0][i] + number[1][i] >= length) {
                return number[0][i] > number[1][i] ? compareArray(i, tops, bottoms) : compareArray(i, bottoms, tops);
            }
        }

        return -1;
    }
}