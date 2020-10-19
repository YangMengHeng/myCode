#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>
using namespace std;

const int maxv = 110;
const int INF = 0x3fffffff;

/*
算法题目：最小生成树-prim算法
问题描述：
	某省调查乡村交通状况，得到的统计表中列出了任意两村庄间的距离。
	省政府“畅通工程”的目标是使全省任何两个村庄间都可以实现公路交通
	（但不一定有直接的公路相连，只要能间接通过公路可达即可），
	并要求铺设的公路总长度为最小。请计算最小的公路总长度。
输入：
	测试输入包含若干测试用例。每个测试用例的第1行给出村庄数目N ( < 100 )；
	随后的N(N-1)/2行对应村庄间的距离，
	每行给出一对正整数，分别是两个村庄的编号，
	以及此两村庄间的距离。为简单起见，村庄从1到N编号。
	当N为0时，输入结束，该用例不被处理。
输出：
	对每个测试用例，在1行里输出最小的公路总长度。
样例输入：
	8
	1 2 42
	1 3 68
	1 4 35
	1 5 1
	1 6 70
	1 7 25
	1 8 79
	2 3 59
	2 4 63
	2 5 65
	2 6 6
	2 7 46
	2 8 82
	3 4 28
	3 5 62
	3 6 92
	3 7 96
	3 8 43
	4 5 28
	4 6 37
	4 7 92
	4 8 5
	5 6 3
	5 7 54
	5 8 93
	6 7 83
	6 8 22
	7 8 17
	0
样例输出：
	82
*/

struct node {
	int v, w;
	node(int _v, int _w) :v(_v), w(_w) {};
};
vector<node> sides[maxv];
int n, m, minLength, d[maxv];
bool vis[maxv];
void prim();

int main()
{
	while (scanf("%d", &n) != EOF && n != 0)
	{
		m = n * (n - 1) / 2;
		for (int i = 1; i <= n; i++)
			sides[i].clear();
		for (int i = 0; i < m; i++)
		{
			int u, v, w;
			scanf("%d %d %d", &u, &v, &w);
			sides[u].push_back(node(v, w));
			sides[v].push_back(node(u, w));
		}
		prim();
		printf("%d\n", minLength);
	}

	return 0;
}

void prim()
{
	fill(d, d + maxv, INF);
	fill(vis, vis + maxv, false);
	d[1] = minLength = 0;
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
		minLength += d[u];
		for (int j = 0; j < sides[u].size(); j++)
		{
			int v = sides[u][j].v;
			int w = sides[u][j].w;
			if (!vis[v] && w < d[v])
				d[v] = w;
		}
	}
}