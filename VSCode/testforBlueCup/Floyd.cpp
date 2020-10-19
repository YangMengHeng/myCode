#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;

const int maxv = 50;
const int INF = 1000000000;

/*
算法题目：最短路径-Floyd算法
问题描述：
	在带权有向图G中，求G中的任意一对顶点间的最短路径问题，
	也是十分常见的一种问题。
	解决这个问题的一个方法是执行n次迪杰斯特拉算法，
	这样就可以求出每一对顶点间的最短路径，执行的时间复杂度为O(n3)。
	而另一种算法是由弗洛伊德提出的，
	时间复杂度同样是O(n3)，但算法的形式简单很多。
输入：
	输入的第一行包含2个正整数n和s，表示图中共有n个顶点，且源点为s。
	其中n不超过50，s小于n。
	以后的n行中每行有n个用空格隔开的整数。
	对于第i行的第j个整数，如果大于0，
	则表示第i个顶点有指向第j个顶点的有向边，且
	权值为对应的整数值；如果这个整数为0，
	则表示没有i指向j的有向边。当i和j相等的时候，保证对应的整数为0。
输出：
	共有n行，每行有n个整数，表示源点至每一个顶点的最短路径长度。
	如果不存在从源点至相应顶点的路径，输出-1。
	对于某个顶点到其本身的最短路径长度，输出0。
	请在每个整数后输出一个空格，并请注意行尾输出换行。
样例输入：
	4
	0 3 0 1
	0 0 4 0
	2 0 0 0
	0 0 1 0
样例输出：
	0 3 2 1
	6 0 4 7
	2 5 0 3
	3 6 1 0
*/

int n, t, dis[maxv][maxv];
void Floyd();

int main(void)
{
	scanf("%d", &n);
	fill(dis[0], dis[0] + maxv * maxv, INF);
	for (int i = 0; i < n; i++)
	{
		dis[i][i] = 0;
		for (int j = 0; j < n; j++)
		{
			scanf("%d", &t);
			if (t != 0)
				dis[i][j] = t;
		}
	}
	Floyd();
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (dis[i][j] == INF)
				dis[i][j] = -1;
			if (j + 1 == n)
				printf("%d\n", dis[i][j]);
			else
				printf("%d ", dis[i][j]);
		}
	}

	return 0;
}

void Floyd()
{
	for (int i = 0; i < n; i++)
	{
		for (int k = 0; k < n; k++)
		{
			for (int j = 0; j < n; j++)
			{
				if (dis[k][i] != INF && dis[i][j] != INF &&
					dis[k][i] + dis[i][j] < dis[k][j])
					dis[k][j] = dis[k][i] + dis[i][j];
			}
		}
	}
}