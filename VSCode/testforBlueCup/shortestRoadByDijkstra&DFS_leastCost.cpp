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
	int v, w;
	node(int _v, int _w) :v(_v), w(_w) {};
};
vector<node> sides[maxv];
vector<int> pre[maxv], tmpPath;
int n, m, s, t, d[maxv], minCost = INF, cost[maxv][maxv];
bool vis[maxv];
void Dijkstra(int start);
void DFS(int v);

int main()
{
	while (scanf("%d %d", &n, &m) != EOF && n != 0 && m != 0)
	{
		for (int i = 1; i <= n; i++)
			sides[i].clear();
		fill(cost[0], cost[0] + maxv * maxv, INF);
		for (int i = 0; i < m; i++)
		{
			int u, v, w, c;
			scanf("%d %d %d %d", &u, &v, &w, &c);
			sides[u].push_back(node(v, w));
			sides[v].push_back(node(u, w));
			cost[u][v] = c;
			cost[v][u] = c;
		}
		scanf("%d %d", &s, &t);
		Dijkstra(s);
		DFS(t);
		printf("%d %d\n", d[t], minCost);
	}

	return 0;
}

void Dijkstra(int start)
{
	fill(d, d + maxv, INF);
	fill(vis, vis + maxv, false);
	d[start] = 0;
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
					pre[v].clear();
					pre[v].push_back(u);
				}
				else if (d[u] + w == d[v])
					pre[v].push_back(u);
			}
		}
	}
}

void DFS(int v)
{
	if (v == s)
	{
		int tmpCost = 0;
		tmpPath.push_back(v);
		for (int i = tmpPath.size() - 1; i > 0; i--)
		{
			int id = tmpPath[i], nextID = tmpPath[i - 1];
			tmpCost += cost[id][nextID];
		}
		if (tmpCost < minCost)
			minCost = tmpCost;
		tmpPath.pop_back();

		return;
	}
	tmpPath.push_back(v);
	for (int i = 0; i < pre[v].size(); i++)
		DFS(pre[v][i]);
	tmpPath.pop_back();
}