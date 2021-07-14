package Day5;

import java.util.ArrayList;
import java.util.List;

public class Yi {
    public static void main(String[] args) {
        //执行结束不了，猜测常量池满了或者常量池检索时间过长，无法继续执行
        String str = "abc";
        char[] arr = {'a', 'b', 'c'};
        String str2 = new String(arr);
        str2 = str2.intern();
        //System.out.println(str == str2);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000000; i++) {
            list.add(String.valueOf(i).intern());
        }
        /*Constant pool:
   #1 = Methodref          #12.#42        // java/lang/Object."<init>":()V
   #2 = String             #43            // abc
   #3 = Class              #44            // java/lang/String
   #4 = Methodref          #3.#45         // java/lang/String."<init>":([C)V
   #5 = Methodref          #3.#46         // java/lang/String.intern:()Ljava/lang/String;
   #6 = Class              #47            // java/util/ArrayList
   #7 = Methodref          #6.#42         // java/util/ArrayList."<init>":()V
   #8 = Integer            1000000000
   #9 = Methodref          #3.#48         // java/lang/String.valueOf:(I)Ljava/lang/String;
  #10 = InterfaceMethodref #49.#50        // java/util/List.add:(Ljava/lang/Object;)Z
  #11 = Class              #51            // Day5/Yi
  #12 = Class              #52            // java/lang/Object
  #13 = Utf8               <init>
  #14 = Utf8               ()V
  #15 = Utf8               Code
  #16 = Utf8               LineNumberTable
  #17 = Utf8               LocalVariableTable
  #18 = Utf8               this
  #19 = Utf8               LDay5/Yi;
  #20 = Utf8               main
  #21 = Utf8               ([Ljava/lang/String;)V
  #22 = Utf8               i
  #23 = Utf8               I
  #24 = Utf8               args
  #25 = Utf8               [Ljava/lang/String;
  #26 = Utf8               str
  #27 = Utf8               Ljava/lang/String;
  #28 = Utf8               arr
  #29 = Utf8               [C
  #30 = Utf8               str2
  #31 = Utf8               list
  #32 = Utf8               Ljava/util/List;
  #33 = Utf8               LocalVariableTypeTable
  #34 = Utf8               Ljava/util/List<Ljava/lang/String;>;
  #35 = Utf8               StackMapTable
  #36 = Class              #25            // "[Ljava/lang/String;"
  #37 = Class              #44            // java/lang/String
  #38 = Class              #29            // "[C"
  #39 = Class              #53            // java/util/List
  #40 = Utf8               SourceFile
  #41 = Utf8               Yi.java
  #42 = NameAndType        #13:#14        // "<init>":()V
  #43 = Utf8               abc
  #44 = Utf8               java/lang/String
  #45 = NameAndType        #13:#54        // "<init>":([C)V
  #46 = NameAndType        #55:#56        // intern:()Ljava/lang/String;
  #47 = Utf8               java/util/ArrayList
  #48 = NameAndType        #57:#58        // valueOf:(I)Ljava/lang/String;
  #49 = Class              #53            // java/util/List
  #50 = NameAndType        #59:#60        // add:(Ljava/lang/Object;)Z
  #51 = Utf8               Day5/Yi
  #52 = Utf8               java/lang/Object
  #53 = Utf8               java/util/List
  #54 = Utf8               ([C)V
  #55 = Utf8               intern
  #56 = Utf8               ()Ljava/lang/String;
  #57 = Utf8               valueOf
  #58 = Utf8               (I)Ljava/lang/String;
  #59 = Utf8               add
  #60 = Utf8               (Ljava/lang/Object;)Z

        * */
    }
}
