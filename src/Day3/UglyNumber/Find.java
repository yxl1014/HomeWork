package Day3.UglyNumber;

public class Find {
    private int[] ints = null;

    private boolean isUgly(int num) {
        while (true) {
            if (num == 1 || num == 2 || num == 3 || num == 5) {
                return true;
            }
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
    }

    public Find() {
        init(100);
    }

    private void init(int len) {
        ints = new int[len];
        int j = 0;
        for (int i = 1; j < len; i++) {
            if (isUgly(i)) {
                ints[j] = i;
                j++;
            }
        }
    }

    public void find(int len) {
        if (len <= ints.length) System.out.println(ints[len - 1]);
        else {
            init(len);
            System.out.println(ints[len - 1]);
        }
    }

    public void findall(int len) {
        if (len <= ints.length) {
            for (int i = 0; i < len; i++) {
                System.out.print(ints[i] + " ");
            }
            System.out.println();
        } else {
            init(len);
            for (int i = 0; i < len; i++) {
                System.out.print(ints[i] + " ");
            }
            System.out.println();
        }

    }
}
