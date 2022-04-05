class Solution {
    public int romanToInt(String s) {
        int result = 0, buf = 0;
        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);

            switch (c) {
                case 'I':
                    if (buf >= 10) {
                        result += buf;
                        buf = 0;
                    }
                    buf++;
                    break;
                case 'V':
                    if (buf == 1) {
                        result += 4;
                        buf = 0;
                    } else {
                        result += 5;
                    }
                    break;
                case 'X':
                    if (buf == 1) {
                        result += 9;
                        buf = 0;
                    } else {
                        if (buf >= 100) {
                            result += buf;
                            buf = 0;
                        }
                        buf += 10;
                    }
                    break;
                case 'L':
                    if (buf == 10) {
                        result += 40;
                        buf = 0;
                    } else {
                        result += 50;
                    }
                    break;
                case 'C':
                    if (buf == 10) {
                        result += 90;
                        buf = 0;
                    } else {
                        buf += 100;
                    }
                    break;
                case 'D':
                    if (buf == 100) {
                        result += 400;
                        buf = 0;
                    } else {
                        result += 500;
                    }
                    break;
                case 'M':
                    if (buf == 100) {
                        result += 900;
                        buf = 0;
                    } else {
                        result += 1000;
                    }
                    break;
            }
        }
        return result + buf;
    }
}