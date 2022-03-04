class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) {
            return 0;
        }

        double[][] glasses = new double[query_row + 1][];
        for (int i = 0; i <= query_row; i++) {
            glasses[i] = new double[i + 1];
        }


        int row = 0;
        glasses[row][0] = poured;

        while (query_row > row++ && poured-- > 0) {
            for (int i = 0; i <= row; i++) {
                if (i == 0 || i == row) {
                    glasses[row][i] = Math.max(0, (glasses[row - 1][0] - 1) / 2);
                }else {

                    glasses[row][i] = Math.max(0, (glasses[row - 1][i - 1] - 1) / 2) + Math.max(0, (glasses[row - 1][i] - 1) / 2);;
                }
            }
        }
        return Math.min(1, glasses[query_row][query_glass]);
    }
}