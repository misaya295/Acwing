package com.misaya295.class2;

import java.util.*;


/*
一共有 n 个数，编号是 1∼n，最开始每个数各自在一个集合中。

现在要进行 m 个操作，操作共有两种：

M a b，将编号为 a 和 b 的两个数所在的集合合并，如果两个数已经在同一个集合中，则忽略这个操作；
Q a b，询问编号为 a 和 b 的两个数是否在同一个集合中；
输入格式
第一行输入整数 n 和 m。

接下来 m 行，每行包含一个操作指令，指令为 M a b 或 Q a b 中的一种。

输出格式
对于每个询问指令 Q a b，都要输出一个结果，如果 a 和 b 在同一集合内，则输出 Yes，否则输出 No。

每个结果占一行。

数据范围
1≤n,m≤105
输入样例：
4 5
M 1 2
M 3 4
Q 1 2
Q 1 3
Q 3 4
输出样例：
Yes
No
Yes
 */
public class MergeSets {

    static int n;
    static int m;
    static int N = (int)1e5+10;
    static int p[] = new int[N];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        for(int i=1;i<= n;i++) p[i] = i;
        while(m --> 0)
        {
            String s = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(s.contains("M")) {p[find(a)] = find(b);}
            else
            {
                if(find(a) == find(b)) {System.out.println("Yes");}
                else{
                    System.out.println("No");
                }
            }

        }

    }


    static int find(int x)
    {

        if(p[x] != x) p[x]=find(p[x]);
        return p[x];
    }



}