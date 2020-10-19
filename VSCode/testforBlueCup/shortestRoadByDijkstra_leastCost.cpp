#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>
using namespace std;

const int maxv = 1010;
const int INF = 0x3fffffff;

/*
算法题目：最短路径-Dijkstra算法
问题描述：
	给你n个点，m条无向边，每条边都有长度d和花费p，给你起点s终点t，
	要求输出起点到终点的最短距离及其花费，
	如果最短距离有多条路线，则输出花费最少的。
输入：
	输入n,m，点的编号是1~n,然后是m行，每行4个数 a,b,d,p，
	表示a和b之间有一条边，且其长度为d，花费为p。
	最后一行是两个数 s,t;起点s，终点t。n和m为0时输入结束。
	(1<n<=1000, 0<m<100000, s != t)
输出：
	一行有两个数， 最短距离及其花费。
样例输入：
	3 2
	1 2 5 6
	2 3 4 5
	1 3
	0 0
样例输出：
	9 11
*/

struct node {
	int v, w, c;
	node(int _v, int _w, int _c) :v(_v), w(_w), c(_c) {};
};
vector<node> sides[maxv];
int n, m, s, t, d[maxv], cost[maxv];
bool vis[maxv];
void Dijkstra(int start);

int main()
{
	while (~scanf("%d %d", &n, &m) && n != 0 && m != 0)
	{
		for (int i = 1; i <= n; i++)
			sides[i].clear();
		for (int i = 0; i < m; i++)
		{
			int u, v, w, c;
			scanf("%d %d %d %d", &u, &v, &w, &c);
			sides[u].push_back(node(v, w, c));
			sides[v].push_back(node(u, w, c));
		}
		scanf("%d %d", &s, &t);
		Dijkstra(s);
		printf("%d %d\n", d[t], cost[t]);
	}

	return 0;
}

void Dijkstra(int start)
{
	fill(d, d + maxv, INF);
	fill(vis, vis + maxv, false);
	d[start] = 0;
	cost[start] = 0;
	for (int i = 1; i <= n; i++)
	{
		int u = -1, min = INF;
		for (int j = 1; j <= n; j++)
		{
			if (!vis[j] && d[j] < min)
			{
				u = j;
				min = d[j];
			}
		}
		if (u == -1) return;
		vis[u] = true;
		for (int j = 0; j < sides[u].size(); j++)
		{
			int v = sides[u][j].v;
			int w = sides[u][j].w;
			int c = sides[u][j].c;
			if (!vis[v] && w != INF)
			{
				if (d[u] + w < d[v])
				{
					d[v] = d[u] + w;
					cost[v] = cost[u] + c;
				}
				else if (d[u] + w == d[v] && cost[u] + c < cost[v])
					cost[v] = cost[u] + c;
			}
		}
	}
}