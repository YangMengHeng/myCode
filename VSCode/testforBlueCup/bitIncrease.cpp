#include <iostream>
#include <string>
using namespace std;

/*
算法题目：数位递增的数
问题描述：
	一个正整数如果任何一个数位不大于右边相邻的数位，则称为一个数位递增的数，
	例如1135是一个数位递增的数，而1024不是一个数位递增的数.
	给定正整数 n，请问在整数 1 至 n 中有多少个数位递增的数？
输入：
	输入的第一行包含一个整数 n。
输出：
	输出一行包含一个整数，表示答案。
样例输入：
	30
样例输出：
	26
*/

bool checkIncrease(int t);

int main()
{
	int ans = 0, n;
cmd /c .\"test.exe"
	scanf("%d", &n);
	for(int i = 1; i <= n; i++)
		if(checkIncrease(i)) ans++;
	printf("%d", ans);

	return 0;
}

bool checkIncrease(int t)
{
	char temp[8];

	sprintf(temp, "%d", t);
	string s(temp);
	for(int i = 1; i < s.size(); i++)
		if(s[i - 1] > s[i]) return false;

	return true;
}