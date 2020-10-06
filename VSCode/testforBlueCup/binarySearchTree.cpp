#include <iostream>
#include <algorithm>
#include <string>
#include <cstdio>
#include <string.h>
using namespace std;

/*
算法题目：二叉搜索树
问题描述：
	判断两序列是否为同一二叉搜索树序列
输入：
	开始一个数n，(1<=n<=20) 表示有n个需要判断，n= 0 的时候输入结束。
	下去一行是一个序列，序列长度小于10，包含(0~9)的数字，没有重复数字，
	根据这个序列可以构造出一颗二叉搜索树。
	接下去的n行有n个序列，每个序列格式跟第一个序列一样，
	请判断这两个序列是否能组成同一颗二叉搜索树。
输出：
	如果序列相同则输出YES，否则输出NO
样例输入：
	6
	45021
	12045
	54120
	45021
	45012
	21054
	50412
	0
样例输出：
	NO
	NO
	YES
	NO
	NO
	NO
*/

struct binaryTree
{
	int data;
	binaryTree* lchild;
	binaryTree* rchild;
}bT[21];
int n, pos, num;
char tmp[21][11], por[11], ior[11];
binaryTree* createBT();
void preorder(binaryTree* root, char* searchList);
void inorder(binaryTree* root, char* searchList);
binaryTree* insert(binaryTree* bt, int data);

int main(void)
{
	while (scanf("%d", &n) != EOF && n != 0)
	{
		pos = num = 0;
		scanf("%s", &tmp[0]);
		binaryTree* root = NULL;
		for (int i = 0; i < strlen(tmp[0]); i++)
		{
			int t = tmp[0][i] - 48;
			if (t == 0)
				t += 65;
			root = insert(root, t);
		}
		num = 0;
		preorder(root, por);
		por[num] = '\0';
		num = 0;
		inorder(root, ior);
		ior[num] = '\0';
		for (int i = 1; i <= n; i++)
		{
			char t1[11], t2[11];
			binaryTree* node = NULL;
			pos = 0;

			scanf("%s", &tmp[i]);
			if (tmp[i][0] != tmp[0][0])
			{
				printf("NO\n");
				continue;
			}
			for (int k = 0; k < strlen(tmp[i]); k++)
			{
				int t = tmp[i][k] - 48;
				if (t == 0)
					t += 65;
				node = insert(node, t);
			}
			num = 0;
			preorder(node, t1);
			t1[num] = '\0';
			num = 0;
			inorder(node, t2);
			t2[num] = '\0';
			if (strcmp(t1, por) == 0 && strcmp(t2, ior) == 0)
				printf("YES\n");
			else
				printf("NO\n");
		}
	}

	return 0;
}

binaryTree* createBT()
{
	bT[pos].lchild = bT[pos].rchild = NULL;
	bT[pos].data = -1;

	return &bT[pos++];
}

void preorder(binaryTree* root, char* searchList)
{
	searchList[num++] = root->data;
	if (root->lchild != NULL)
		preorder(root->lchild, searchList);
	if (root->rchild != NULL)
		preorder(root->rchild, searchList);
}

void inorder(binaryTree* root, char* searchList)
{
	if (root->lchild != NULL)
		inorder(root->lchild, searchList);
	searchList[num++] = root->data;
	if (root->rchild != NULL)
		inorder(root->rchild, searchList);
}

binaryTree* insert(binaryTree* bt, int data)
{
	int t = data;
	int t2;

	if (t == 65) t = 0;
	if (bt == NULL)
	{
		bt = createBT();
		bt->data = data;

		return bt;
	}
	if (bt != NULL)
	{
		t2 = bt->data;
		if (t2 == 65) t2 = 0;
	}
	if (t > t2)
		bt->rchild = insert(bt->rchild, data);
	else
		bt->lchild = insert(bt->lchild, data);

	return bt;
}