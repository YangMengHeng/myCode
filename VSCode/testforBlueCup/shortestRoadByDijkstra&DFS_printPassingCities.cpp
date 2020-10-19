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
	有n个城市m条道路（n<1000, m<10000)，
	每条道路有个长度，请找到从起点s到终点t的最短距离和经过的城市名。
输入：
	输入包含多组测试数据。
	每组第一行输入四个数，分别为n，m，s，t。
	接下来m行，每行三个数，分别为两个城市名和距离。
输出：
	每组输出占两行。
	第一行输出起点到终点的最短距离。
	第二行输出最短路径上经过的城市名，如果有多条最短路径，
	输出字典序最小的那条。若不存在从起点到终点的路径，
	则输出“can't arrive”。
样例输入：
	3 3 1 3
	1 3 3
	1 2 1
	2 3 1
样例输出：
	2
	1 2 3
*/

struct node {
	int v, w;
	node(int _v, int _w) :v(_v), w(_w) {};
};
vector<node> sides[maxv];
int n, m, s, t, d[maxv], pre[maxv];
bool vis[maxv] = { false };
void Dijkstra(int start);
void DFS(int v);

int main()
{
	while (~scanf("%d %d %d %d", &n, &m, &s, &t))
	{
		for (int i = 1; i <= n; i++)
			sides[i].clear();
		for (int i = 0; i < m; i++)
		{
			int u, v, w;
			scanf("%d %d %d", &u, &v, &w);
			sides[u].push_back(node(v, w));
			sides[v].push_back(node(u, w));
		}
		Dijkstra(s);
		if (d[t] == INF)
			printf("can't arrive\n");
		else
		{
			printf("%d\n", d[t]);
			DFS(t);
			printf("\n");
		}
	}

	return 0;
}

void Dijkstra(int start)
{
	fill(d, d + maxv, INF);
	fill(vis, vis + maxv, false);
	d[start] = 0;
	for (int i = 1; i <= n; i++)
		pre[i] = i;
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
			if (!vis[v])
			{
				if (d[u] + w < d[v])
				{
					d[v] = d[u] + w;
					pre[v] = u;
				}
				else if (d[u] + w == d[v] && u < pre[v])
					pre[v] = u;
			}
		}
	}
}

void DFS(int v)
{
	if (v == s)
	{
		printf("%d ", v);
		return;
	}
	DFS(pre[v]);
	printf("%d ", v);
}