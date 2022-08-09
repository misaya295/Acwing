/**
给定一个 n×m 的二维整数数组，用来表示一个迷宫，数组中只包含 0 或 1，其中 0 表示可以走的路，1 表示不可通过的墙壁。

最初，有一个人位于左上角 (1,1) 处，已知该人每次可以向上、下、左、右任意一个方向移动一个位置。

请问，该人从左上角移动至右下角 (n,m) 处，至少需要移动多少次。

数据保证 (1,1) 处和 (n,m) 处的数字为 0，且一定至少存在一条通路。

输入格式
第一行包含两个整数 n 和 m。

接下来 n 行，每行包含 m 个整数（0 或 1），表示完整的二维数组迷宫。

输出格式
输出一个整数，表示从左上角移动至右下角的最少移动次数。

数据范围
1≤n,m≤100
输入样例：
5 5
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
输出样例：
8
*/


#include <iostream>
#include <algorithm> //pair<int, int>
#include <cstring>   //memset(d, -1, sizeof d)

using namespace std;

const int N  = 110;
int n,m;

//g[][] 存迷宫数值，d[][] 存每个点到起点的距离 
int d[N][N];
int g[N][N];
pair<int, int> q[N*N]; //用数组来模拟队列, 数组的类型是int型二元组存坐标              

int bfs()
{
    int hh=0; //hh是对头
    int tt= 0; //tt是队尾
    q[0] = {0, 0};    //把起点(0, 0)入队, q数组是pair类型的队列
    memset(d,-1,sizeof d);//把所有距离初始化为-1.memset函数,<cstring>, memset(数组名, 把内容都置为-1, 数组大小)
    d[0][0] = 0; //(0,0)为起点所以距离为0

    int dx[4] = {-1,0,1,0};
    int dy[4] = {0,1,0,-1};
                            
    
    while(hh <= tt)
    {
        auto t = q[hh++]; //取出对头
        
        //遍历向量开始搜索
        for(int i= 0;i < 4;i++)
        {
            int x = t.first + dx[i];
            int y = t.second + dy[i];
            if(x  >= 0 && x < n && y >= 0 && y < m &&  g[x][y]==0  && d[x][y] == -1) //不越界，不走重复路径
            {
                d[x][y] = d[t.first][t.second]+1; //将原路径的距离加上
                q[++tt] = {x,y}; //把符合条件的坐标加到队尾
                
            }//依次看t周围可经过的四个点,如果满足条件,就上下左右的顺序依次进队,一层一层的找
            
        }
        
        
        
    }
    return d[n-1][m-1];
    
    
    
}

int main()
{
    
    cin >> n >> m;
    
    for(int i=0;i< n;i++)
        for(int j=0;j < m;j++)
            cin >> g[i][j];
    
    
    
    
    cout << bfs() << endl;
    return 0;
    
    
}