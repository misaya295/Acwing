package com.misaya295.class2Datastructure;




/**
 * trie用来高效存储和查找字符串集合的数据结构
 维护一个字符串集合，支持两种操作：

 I x 向集合中插入一个字符串 x；
 Q x 询问一个字符串在集合中出现了多少次。
 共有 N 个操作，输入的字符串总长度不超过 105，字符串仅包含小写英文字母。

 输入格式
 第一行包含整数 N，表示操作数。

 接下来 N 行，每行包含一个操作指令，指令为 I x 或 Q x 中的一种。

 输出格式
 对于每个询问指令 Q x，都要输出一个整数作为结果，表示 x 在集合中出现的次数。

 每个结果占一行。

 数据范围
 1≤N≤2∗104
 输入样例：
 5
 I abc
 Q abc
 Q ab
 I ab
 Q ab
 输出样例：
 1
 0
 1
 */
import java.util.Scanner;
public class TrieStringStatistics {

    static String a="";
    static int N = (int) (1e5+10);
    static int[][]  son = new int[N][26];
    static int[] cnt = new int[N];
    static int idx = 0;

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n-- > 0) {
        String str = sc.next();
        char[] chars = sc.next().toCharArray();

        if (str.equals("I")) {

            insert(chars);
        } else {
            System.out.println( query(chars));
        }



    }


}

    private static int query(char[] next) {
        int p = 0;
        for(int i = 0; i < next.length; i++) {
            int u = next[i] - 'a';
            if (son[p][u] == 0) {
                return 0;
            }
            p  = son[p][u];


        }
        return cnt[p];



    }

    private static void insert(char[] next) {

        int p = 0;
        for (int i = 0; i < next.length; i++) {
            int u = next[i] - 'a';
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];


        }
        cnt[p]++;


    }


}
