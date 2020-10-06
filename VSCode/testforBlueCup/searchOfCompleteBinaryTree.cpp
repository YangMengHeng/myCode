#include <iostream>
#include <algorithm>
#include <vector>
#include <string.h>
#include <cmath>
using namespace std;

/*
算法题目：树的查找
问题描述：
	有一棵树，输出某一深度的所有节点，有则输出这些节点，无则输出EMPTY。该树是完全二叉树
输入：
	输入有多组数据。
	每组输入一个n(1<=n<=1000)，然后将树中的这n个节点依次输入，再输入一个d代表深度
输出：
	输出该树中第d层得所有节点，节点间用空格隔开，最后一个节点后没有空格
样例输入：
	5
	1 2 3 4 5
	7
	7
	1 2 3 4 5 6 7
	2
	0
样例输出：
	EMPTY
	2 3
*/

int n, d, tmp[1000];

int main(void)
{
	while (scanf("%d", &n) != EOF && n != 0)
	{
		for (int i = 0; i < n; i++)
			scanf("%d", &tmp[i]);
		scanf("%d", &d);
		int leaves;
		int upperNodes = pow(2, d) - 1;
		int lowerNodes = pow(2, d - 1) - 1;
		if (lowerNodes >= n)
		{
			printf("EMPTY\n");
			continue;
		}
		leaves = upperNodes - lowerNodes;
		for (int i = lowerNodes; leaves != 0; i++, leaves--)
		{
			printf("%d", tmp[i]);
			if (leaves != 1)
				printf(" ");
			else
				printf("\n");
		}
	}

	return 0;
}