package com.misaya295.class2Datastructure;



/*

在给定的 N 个整数 A1，A2……AN 中选出两个进行 xor（异或）运算，得到的结果最大是多少？

输入格式
第一行输入一个整数 N。

第二行输入 N 个整数 A1～AN。

输出格式
输出一个整数表示答案。

数据范围
1≤N≤105,
0≤Ai<231
输入样例：
3
1 2 3
输出样例：
3
 */
import java.util.Scanner;
public class MaxXor {

    static int N = (int) (1e5 + 10);
    static int M = 3000000;

    static int idx = 0;
    static int[] a = new int[N];
    static int[][] son = new int[M][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            insert(a[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,query(a[i]));
        }

        System.out.println(res);




    }

    private static int query(int x) {
        int p = 0;
        int res = 0;

        for (int i = 30; i >= 0; i--) {
            int s = x >> i & 1;
            int sp = s == 0 ? 1 : 0;

            if (son[p][sp] != 0) {
                res += 1 << i;
                p = son[p][sp];
            } else {
                p = son[p][s];
            }
        }

        return res;
    }

    private static void insert(int x) {
        int p = 0;
        for(int i = 30; i >=0; i--) {
            int s = x >> i & 1;
            if (son[p][x >> i & 1] == 0) {
                son[p][x >> i & 1] = ++idx;
            }
            p = son[p][x >> i & 1];
        }

    }
}
