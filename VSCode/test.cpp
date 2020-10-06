#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>
using namespace std;

const int INF = INT32_MAX;
const int modify = 100000;

/*
算法题目：城市之间的最短路径-Dijkstra算法
问题描述：
	N个城市，标号从0到N-1，M条道路，
	第K条道路（K从0开始）的长度为2^K，求编号为0的城市到其他城市的最短距离。
输入：
	第一行两个正整数N（2<=N<=100）M(M<=500),表示有N个城市，M条道路，
	接下来M行两个整数，表示相连的两个城市的编号。
输出：
	N-1行，表示0号城市到其他城市的最短路，
	如果无法到达，输出-1，数值太大的以 MOD 100000的结果输出。
样例输入：
	4 3
	0 1
	1 2
	2 0
样例输出：
	1
	3
	-1
*/

struct Node {
	int v, w;
	Node(int a, int b) :v(a), w(b) {};
};
vector<Node> G[110];
int n, m, d[110], f[110];
bool vis[110] = { false };

int mod(int a, int b)
{
	int num = 1;
	while (b--) num = (num * a) % modify;
	return num;
}

int Find(int x)
{
	if (f[x] == x) return x;
	else return Find(f[x]);
}

void Dijkstra()
{
	fill(d, d + 110, INF);
	fill(vis, vis + 110, false);
	d[0] = 0;
	for (int i = 0; i < n; i++)
	{
		int u = -1, MIN = INF;
		for (int j = 0; j < n; j++) {
			if (!vis[j] && d[j] < MIN)
			{
				u = j;
				MIN = d[j];
			}
		}
		if (u == -1) return;
		vis[u] = true;
		for (int j = 0; j < G[u].size(); j++)
		{
			int v = G[u][j].v;
			if (!vis[v] && d[u] + G[u][j].w < d[v]) {
				d[v] = d[u] + G[u][j].w;
			}
		}
	}
}

int main()
{
	while (cin >> n >> m)
	{
		for (int i = 0; i < 110; i++)
		{
			G[i].clear();
			f[i] = i;
		}
		for (int k = 0; k < m; k++)
		{
			int u, v;
			cin >> u >> v;
			int Fu = Find(f[u]), Fv = Find(f[v]);
			if (Fu!=Fv) f[Fu] = Fv;
			else continue;
			G[u].push_back(Node(v, mod(2, k)));
			G[v].push_back(Node(u, mod(2, k)));
		}
		Dijkstra();
		for (int i = 1; i < n; i++)
		{
			if (d[i] == INF)
				printf("-1\n");
			else
				printf("%d\n", d[i] % modify);
		}
	}

	return 0;
}