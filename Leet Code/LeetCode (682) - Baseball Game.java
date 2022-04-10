class Solution {
    public int calPoints(String[] ops) {
        int result = 0, index = 0;
        int[] arr = new int[ops.length];

        for (String s : ops) {
            switch (s) {
                case "+":
                    int sum = arr[index - 1] + arr[index - 2];
                    arr[index++] = sum;
                    break;
                case "D":
                    int doubleNum = arr[index - 1] * 2;
                    arr[index++] = doubleNum;
                    break;
                case "C":
                    arr[--index] = 0;
                    break;
                default:
                    arr[index++] = Integer.parseInt(s);
            }
        }

        for (int num : arr) {
            result += num;
        }

        return result;
    }
}