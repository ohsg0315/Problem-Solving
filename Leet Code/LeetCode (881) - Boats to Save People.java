import java.util.Arrays;

class Solution {
    //O(NlogN)
    public int numRescueBoats(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);

        int low = 0, high = people.length - 1;
        while (low <= high) {
            if (people[low] + people[high] <= limit) {
                low++;
                high--;
            } else {
                high--;
            }
            result++;
        }
        return result;
    }

    //O(N + M)
    public int numRescueBoats(int[] people, int limit) {
        int result = 0;
        int[] weight = new int[limit + 1];
        for(int person: people){
            weight[person]++;
        }

        int low = 0, high = limit;

        while(low <= high){
            if (weight[low] <= 0) {
                low++;
                continue;
            } else if (weight[high] <= 0) {
                high--;
                continue;
            } else if (low + high <= limit) {
                weight[low]--;
                weight[high]--;
            } else {
                weight[high]--;
            }
            result++;
        }
        return result;
    }
}