#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;

const int maxv = 50;
const int INF = 1000000000;

/*
算法题目：最短路径-Dijkstra算法
问题描述：
	在带权有向图G中，给定一个源点v，
	求从v到G中的其余各顶点的最短路径问题，叫做单源点的最短路径问题。
	在常用的单源点最短路径算法中，迪杰斯特拉算法是最为常用的一种，
	是一种按照路径长度递增的次序产生最短路径的算法。
输入：
	输入的第一行包含2个正整数n和s，表示图中共有n个顶点，且源点为s。
	其中n不超过50，s小于n。
	以后的n行中每行有n个用空格隔开的整数。
	对于第i行的第j个整数，如果大于0，
	则表示第i个顶点有指向第j个顶点的有向边，且
	权值为对应的整数值；如果这个整数为0，
	则表示没有i指向j的有向边。当i和j相等的时候，保证对应的整数为0。
输出：
	只有一行，共有n-1个整数，表示源点至其它每一个顶点的最短路径长度。
	如果不存在从源点至相应顶点的路径，输出-1。
	请注意行尾输出换行。
样例输入：
	4 1
	0 3 0 1
	0 0 4 0
	2 0 0 0
	0 0 1 0
样例输出：
	6 4 7
*/

int n, s, t, G[maxv][maxv], d[maxv];
bool vis[maxv] = {false};
void Dijkstra(int start);

int main(void)
{
	scanf("%d %d", &n, &s);
	fill(G[0], G[0] + maxv * maxv, INF);
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
		{
			scanf("%d", &t);
			if(t != 0)
				G[i][j] = t;
		}
	Dijkstra(s);
	t = 0;
	for (int i = 0; i < n - 1; i++, t++)
	{
		if (d[t] == 0)
			t++;
		if(d[t] == INF)
			d[t] = -1;
		if (i + 1 != n - 1)
			printf("%d ", d[t]);
		else
			printf("%d\n", d[t]);
	}

	return 0;
}

void Dijkstra(int start)
{
	fill(d, d + maxv, INF);
	d[start] = 0;
	for(int i = 0; i < n; i++)
	{
		int u = -1, min = INF;
		for(int k = 0; k < n; k++)
		{
			if(vis[k] == false && d[k] < min)
			{
				u = k;
				min = d[k];
			}
		}
		if(u == -1) return;
		vis[u] = true;
		for(int j = 0; j < n; j++)
		{
			if(vis[j] == false && G[u][j] != INF && d[u] + G[u][j] < d[j])
				d[j] = d[u] + G[u][j];
		}
	}
}