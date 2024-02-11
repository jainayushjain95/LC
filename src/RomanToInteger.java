public class RomanToInteger {


    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int solution = 0;
        for(int i = 0;i < s.length(); i++) {
            char c = s.charAt(i);
            if(!isSpecialChar(c) || i == s.length() - 1) {
                solution += getMapping(c);
            } else {
                if(c == 'I') {
                    if(s.charAt(i + 1) == 'V') {
                        solution += 4;
                        i++;
                    } else if(s.charAt(i + 1) == 'X') {
                        solution += 9;
                        i++;
                    } else {
                        solution += getMapping(c);
                    }
                } else if(c == 'X') {
                    if(s.charAt(i + 1) == 'L') {
                        solution += 40;
                        i++;
                    } else if(s.charAt(i + 1) == 'C') {
                        solution += 90;
                        i++;
                    } else {
                        solution += getMapping(c);
                    }
                } else if(c == 'C') {
                    if(s.charAt(i + 1) == 'D') {
                        solution += 400;
                        i++;
                    } else if(s.charAt(i + 1) == 'M') {
                        solution += 900;
                        i++;
                    } else {
                        solution += getMapping(c);
                    }
                }
            }
        }
        return solution;
    }


    public boolean isSpecialChar(char c) {
        return c == 'I' || c == 'X' || c == 'C';
    }

    public int getMapping(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}