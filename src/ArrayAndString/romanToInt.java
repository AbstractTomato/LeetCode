package ArrayAndString;


/**
 * 给定一个罗马数字，将其转换成整数。
 */
public class romanToInt {
    public int romanToInt(String s){
        int sum = 0;
        int preNum = getValue(s.charAt(0));

        for (int i = 1; i < s.length(); i++){
            int num = getValue(s.charAt(i));

            if (num > preNum){
                sum -= preNum;
            }else {
                sum += preNum;
            }

            preNum = num;
        }
        sum += preNum;

        return sum;
    }

    private int getValue(char c){
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

}
