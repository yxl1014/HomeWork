package Day3.StringToInt;

public class TO {
    private int SwitchInt(char a) {
        switch (a) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return 0;
        }
    }

    private int ToInt(String str) {
        int num = 0;
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            int z = SwitchInt(chars[i]);
            for (int j = 0; j < len - i - 1; j++) {
                z *= 10;
            }
            num += z;
        }
        return num;
    }

    public String To(String num1, String num2) {
        int n1 = ToInt(num1);
        int n2 = ToInt(num2);
        return String.valueOf(n1 * n2);
    }

    public static void main(String[] args) {
        TO t = new TO();
        System.out.println(t.To("10", "10"));
    }
}
