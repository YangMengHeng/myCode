#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>
#include <cmath>
#include <string.h>
#include <limits.h>
using namespace std;

typedef long long int ll;

const int maxv = 110;
const ll INF = 1000000000;

/*
算法题目：最小生成树-prim算法
问题描述：
	某In an episode of the Dick Van Dyke show, little Richie
	connects the freckles on his Dad's back to form a picture
	of the Liberty Bell. Alas, one of the freckles turns out
	to be a scar, so his Ripley's engagement falls through.
	Consider Dick's back to be a plane with freckles at
	various (x,y) locations. Your job is to tell Richie how
	to connect the dots so as to minimize the amount of ink used.
	Richie connects the dots by drawing straight lines between pairs,
	possibly lifting the pen between lines. When Richie is
	done there must be a sequence of connected lines from any
	freckle to any other freckle.
输入：
	The first line contains 0 < n <= 100, the number of freckles on
	Dick's back. For each freckle,
	a line follows; each following line contains two real numbers
	indicating the (x,y) coordinates of the freckle.
输出：
	Your program prints a single real number to two decimal
	places: the minimum total length of ink lines that can
	connect all the freckles.
样例输入：
	3
	2723.62 7940.81
	8242.67 11395.00
	4935.54 6761.32
	9
	10519.52 11593.66
	12102.35 2453.15
	7235.61 10010.83
	211.13 4283.23
	5135.06 1287.85
	2337.48 2075.61
	6279.72 13928.13
	65.79 1677.86
	5324.26 125.56
	0
样例输出：
	8199.56
	32713.73
*/
struct node {
	ll x, y;
	node(ll _x, ll _y) :x(_x), y(_y) {};
};
vector<node> nodes;
int n;
ll minLength, d[maxv], G[maxv][maxv];
bool vis[maxv];
void prim();
ll dataHandle(char s[]);
ll computeDistance(node &n1, node &n2);

int main()
{
	while (scanf("%d", &n) != EOF && n != 0)
	{
		fill(G[0], G[0] + maxv * maxv, INF);
		for (int i = 0; i < n; i++)
		{
			ll x, y;
			char t1[101], t2[101];
			scanf("%s %s", t1, t2);
			x = dataHandle(t1);
			y = dataHandle(t2);
			node Node = node(x, y);
			nodes.push_back(Node);
		}
		for(int i = 0; i < n; i++)
			for(int k = 0; k < n; k++)
			{
				if(k <= i) continue;
				else G[i][k] = G[k][i] = computeDistance(nodes[i], nodes[k]);
			}
		prim();
		printf("%.2lf\n", (minLength + 1) / 100.0);
	}

	return 0;
}

void prim()
{
	fill(d, d + maxv, INF);
	fill(vis, vis + maxv, false);
	d[0] = minLength = 0;
	for (int i = 0; i < n; i++)
	{
		int u = -1;
		ll min = INF;
		for (int j = 0; j < n; j++)
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
		for (int v = 0; v < n; v++)
		{
			if (!vis[v] && G[u][v] < d[v])
				d[v] = G[u][v];
		}
	}
}

ll computeDistance(node &n1, node &n2)
{
	ll x1 = n1.x, x2 = n2.x, y1 = n1.y, y2 = n2.y;
	ll verticalDis, horionDis, distance;

	if (x1 == x2)
		distance = fabs(y1 - y2);
	else if (y1 == y2)
		distance = fabs(x1 - x2);
	else
	{
		verticalDis = fabs(y1 - y2);
		horionDis = fabs(x1 - x2);
		distance = (ll)sqrt((ll)pow(verticalDis, 2) + (ll)pow(horionDis, 2));
	}

	return distance;
}

ll dataHandle(char s[])
{
	int len = strlen(s), i, j, m;
	ll data = 0;

	for (i = 0; i < len; i++)
		if (s[i] == '.') break;
	for (j = m = 0; j < len - 1; j++)
	{
		if (m == i) m++;
		data += (ll)pow(10, i - j + 1) * (s[m++] - 48);
	}

	return data;
}