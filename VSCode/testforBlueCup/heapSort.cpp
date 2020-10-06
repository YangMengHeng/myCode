#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
#include <cstdio>
#include <string.h>
using namespace std;

#define maxlength 100000

/*
算法题目：哈弗曼树
问题描述：
	在通讯领域，经常需要将需要传送的文字转换成由二进制字符组成的字符串。
	在实际应用中，由于总是希望被传送的内容总长尽可能的短，
	如果对每个字符设计长度不等的编码，
	且让内容中出现次数较多的字符采用尽可能短的编码，
	则整个内容的总长便可以减少。另外，
	需要保证任何一个字符的编码都不是另一个字符的编码前缀，
	这种编码成为前缀编码。
输入：
	输入的第一行包含一个正整数n，表示共有n个字符需要编码。其中n不超过100。
	第二行中有n个用空格隔开的正整数，分别表示n个字符的权值。
输出：
	共n行，每行一个字符串，表示对应字符的赫夫曼编码
样例输入：
	8
	5 29 7 8 14 23 3 11
样例输出：
	0110
	10
	1110
	1111
	110
	00
	0111
	010
*/

struct binaryTree
{
	int data;
	int parent;
	int lchild;
	int rchild;

	binaryTree()
	{
		data = parent = lchild = rchild = -1;
	}
};
vector<binaryTree> node;
binaryTree creatTree(int data, int parent);
binaryTree* combineTree(binaryTree* a, binaryTree* b);
int n, num[100];


int main(void)
{
	scanf("%d", &n);
	for(int i = 0; i < n; i++)
		scanf("%d", &num[i]);
	for(int i = 0; i < n - 2; i++)
	{
		int min1 = i + 1, min2 = i + 2;
		for(int j = i; j < i + 2; j++)
		{
			if(num[j] < num[min1] && num[j] < num[min2])
				min1 = j;
			else if((num[j] < num[min1] && num[j] > num[min2])
			|| (num[j] < num[min2] && num[j] > num[min1]))
				min2 = j;
			else
			{
				if(num[min1] > num[min2])
					swap(min1, min2);
				break;
			}
		}
		node.push_back(creatTree());
	}

	return 0;
}