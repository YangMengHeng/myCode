#include <iostream>
#include <string>
using namespace std;

/*
算法题目：递增三元组
问题描述：
	在数列 a[1], a[2], …, a[n] 中，如果对于下标 i, j, k
	满足 0<i<j<k<n+1 且 a[i]<a[j]<a[k]，则称 a[i], a[j], a[k]
	为一组递增三元组，a[j]为递增三元组的中心.
	给定一个数列，请问数列中有多少个元素可能是递增三元组的中心.
输入：
	输入的第一行包含一个整数 n。
	第二行包含 n 个整数 a[1], a[2], …, a[n]，相邻的整数间用空格分隔，
	表示给定的数列.
输出：
	输出一行包含一个整数，表示答案.
样例输入：
	5
	1 2 5 3 5
样例输出：
	2
*/

int *number;
int n, ans = 0;
bool checkTripleIncrease(int t);

int main()
{
	scanf("%d", &n);
	number = new int[n];
	for(int i = 0; i < n; i ++)
		scanf("%d", &number[i]);
	for(int i = 1; i < n - 1; i++)
		if(checkTripleIncrease(i)) ans++;
	printf("%d", ans);

	return 0;
}

bool checkTripleIncrease(int t)
{
	bool haveLess, haveGreat;

	haveLess = haveGreat = 0;
	for(int i = 0; i < t; i++)
		if(number[i] < number[t])
		{
			haveLess = 1;
			break;
		}
	for(int i = t + 1; i < n; i++)
		if(number[i] > number[t])
		{
			haveGreat = 1;
			break;
		}
	if(haveLess && haveGreat) return true;

	return false;
}