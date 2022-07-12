package com.misaya295.class2;


/**
 * 给定一个模式串 S，以及一个模板串 P，所有字符串中只包含大小写英文字母以及阿拉伯数字。
 * <p>
 * 模板串 P 在模式串 S 中多次作为子串出现。
 * <p>
 * 求出模板串 P 在模式串 S 中所有出现的位置的起始下标。
 * <p>
 * 输入格式
 * 第一行输入整数 N，表示字符串 P 的长度。
 * <p>
 * 第二行输入字符串 P。
 * <p>
 * 第三行输入整数 M，表示字符串 S 的长度。
 * <p>
 * 第四行输入字符串 S。
 * <p>
 * 输出格式
 * 共一行，输出所有出现位置的起始下标（下标从 0 开始计数），整数之间用空格隔开。
 * <p>
 * 数据范围
 * 1≤N≤105
 * 1≤M≤106
 * 输入样例：
 * 3
 * aba
 * 5
 * ababa
 * 输出样例：
 * 0 2
 */


import java.io.*;
public class KmpString {
    private static int[] nxt = new int[100010];
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int n = Integer.valueOf(reader.readLine());
        String p = " " + reader.readLine();
        int m = Integer.valueOf(reader.readLine());
        String s = " " + reader.readLine();

        for(int i = 2, j = 0; i <= n; i++) {
            while(j != 0 && p.charAt(j+1) != p.charAt(i)) j = nxt[j];
            if(p.charAt(j+1) == p.charAt(i)) j++;
            nxt[i] = j;
        }

        for(int i = 1, j = 0; i <= m; i++) {
            while(j != 0 && p.charAt(j+1) != s.charAt(i)) j = nxt[j];
            if(p.charAt(j+1) == s.charAt(i)) j++;
            if(j == n) { //成功
                j = nxt[j]; //可能后面还有其他满足的情况，继续匹配
                log.write(i-n + " ");
            }
        }

        log.flush();    // 关闭输入输出流
        reader.close();
        log.close();
    }
}


