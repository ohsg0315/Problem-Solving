class Solution {
    public int compareVersion(String version1, String version2) {
        String[] versionArr1 = version1.split("\\.");
        String[] versionArr2 = version2.split("\\.");

        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == versionArr1.length && index2 == versionArr2.length) {
                return 0;
            }
            else if (index1 == versionArr1.length) {
                if (Integer.parseInt(versionArr2[index2]) == 0) {
                    index2++;
                    continue;
                }
                return -1;

            } else if (index2 == versionArr2.length) {
                if (Integer.parseInt(versionArr1[index1]) == 0) {
                    index1++;
                    continue;
                }
                return 1;
            }

            int one  = Integer.parseInt(versionArr1[index1]);
            int two  = Integer.parseInt(versionArr2[index2]);

            if (one != two) {
                return Integer.compare(one, two);
            }

            index1++;
            index2++;
        }
    }
}