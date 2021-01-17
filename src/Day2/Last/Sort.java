package Day2.Last;

/*
 * 希尔排序
 * */
public class Sort {
    private int[] value;
    private int len;
    public int[] getValue() {
        return value;
    }
    public void setValue(int[] value) {
        this.value = value;
        this.len=value.length;
    }

    public Sort(){}

    public Sort(int[] value){
        this.value=value;
        this.len=value.length;
    }


    public Sort(String value){
        this.len=value.length();
        int[] values=new int[this.len];
        char[] c=value.toCharArray();
        for(int i=0;i<this.len;i++){
            values[i]=To_int(c[i]);
        }
        this.value=values;
    }

    public String doSort_S() {
        String s = "";
        int l = len;
        int group=l;
        //TODO:分组
        while ((group = group / 2) != 0) {
            for (int i = 0; i < group; i++) {
                //TODO:组内比较
                for (int j = i + group; j < l; j += group) {
                    //TODO:后移
                    if (value[j] <= value[j - group]) {
                        int temp = value[j];
                        int p = j - group;
                        while (p >= 0 && value[p] > temp) {
                            value[p + group] = value[p];
                            p -= group;
                        }
                        value[p + group] = temp;
                    }
                }
            }
        }
        for(int i=0;i<len;i++){
            s+=value[i];
        }
        return s;
    }

    public int[] doSort_I() {
        int l = len;
        int group=l;
        //TODO:分组
        while ((group = group / 2) != 0) {
            for (int i = 0; i < group; i++) {
                //TODO:组内比较
                for (int j = i + group; j < l; j += group) {
                    //TODO:后移
                    if (value[j] <= value[j - group]) {
                        int temp = value[j];
                        int p = j - group;
                        while (p >= 0 && value[p] > temp) {
                            value[p + group] = value[p];
                            p -= group;
                        }
                        value[p + group] = temp;
                    }
                }
            }
        }
        return value;
    }

    private int To_int(char c){
        switch (c){
            case '0':return 0;
            case '1':return 1;
            case '2':return 2;
            case '3':return 3;
            case '4':return 4;
            case '5':return 5;
            case '6':return 6;
            case '7':return 7;
            case '8':return 8;
            case '9':return 9;
            default:return -1;
        }
    }
}