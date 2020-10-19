#include <iostream>
#include <algorithm>
#include <string>
#include <cstdio>
#include <string.h>
using namespace std;

/*
算法题目：通信系统
问题描述：
	某市计划建设一个通信系统。按照规划，这个系统包含若干端点，
	这些端点由通信线缆链接。消息可以在任何一个端点产生，并且只能通过线缆传送。
	每个端点接收消息后会将消息传送到与其相连的端点，除了那个消息发送过来的端点。
	如果某个端点是产生消息的端点，那么消息将被传送到与其相连的每一个端点。
	为了提高传送效率和节约资源，要求当消息在某个端点生成后，其余各个端点均能接收到消息，
	并且每个端点均不会重复收到消息。
	现给你通信系统的描述，你能判断此系统是否符合以上要求吗？
输入：
	测输入包含多组测试数据。每两组输入数据之间由空行分隔。
	每组输入首先包含2个整数N和M，N（1<=N<=1000）表示端点个数，
	M（0<=M<=N*(N-1)/2）表示通信线路个数。
	接下来M行每行输入2个整数A和B（1<=A，B<=N），
	表示端点A和B由一条通信线缆相连。两个端点之间至多由一条线缆直接相连，
	并且没有将某个端点与其自己相连的线缆。
	当N和M都为0时，输入结束。
输出：
	对于每组输入，如果所给的系统描述符合题目要求，则输出Yes，否则输出No。
样例输入：
	4 3
	1 2
	2 3
	3 4

	3 1
	2 3

	0 0
样例输出：
	Yes
	No
*/

int n, m, tmp[1001], sign, cnt;
bool root[1001];
void init();
void combine(int a, int b);
int searchRoot(int x);

int main(void)
{
	while (scanf("%d %d", &n, &m) != EOF && n != 0 && m != 0)
	{
		int a, b;
		init();
		for (int i = 0; i < m; i++)
		{
			scanf("%d %d", &a, &b);
			combine(a, b);
		}
		if (cnt == n && sign == 1)
			printf("Yes\n");
		else
			printf("No\n");
	}

	return 0;
}

void init()
{
	sign = 1;
	cnt = 1;
	for (int i = 1; i <= n; i++)
	{
		root[i] = false;
		tmp[i] = i;
	}
}

void combine(int a, int b)
{
	int faA = searchRoot(a);
	int faB = searchRoot(b);

	if (faA != faB)
	{
		tmp[faA] = faB;
		cnt++;
	}
	else
		sign = 0;
}

int searchRoot(int x)
{
	int z = x;
	while (x != tmp[x])
		x = tmp[x];
	while (z != tmp[z])
	{
		int a = z;
		z = tmp[z];
		tmp[a] = x;
	}

	return x;
}