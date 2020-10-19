#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;

#define maxlength 1000

/*
算法题目：Fibonacci by DP
问题描述：
	The Fibonacci Numbers{0,1,1,2,3,5,8,13,21,34,55...} are defined by the recurrence:
	F0=0 F1=1 Fn=Fn-1+Fn-2,n>=2
	Write a program to calculate the Fibonacci Numbers.
输入：
	Each case contains a number n
	and you are expected to calculate Fn.(0<=n<=30) 。
输出：
	For each case, print a number Fn
	on a separate line,which means the nth Fibonacci Number.
样例输入：
	1
样例输出：
	1
*/

int dp[maxlength], n, ans;
int Fibonacci(int n);

int main(void)
{
	dp[0] = 0, dp[1] = 1;
	for(int i = 2; i < maxlength; i++)
			dp[i] = -1;
	while(scanf("%d", &n) != EOF)
	{
		ans = Fibonacci(n);
		printf("%d\n", ans);
	}

	return 0;
}

int Fibonacci(int n)
{
	if(dp[n] != -1)
		return dp[n];
	else
	{
		dp[n] = Fibonacci(n - 1) + Fibonacci(n - 2);
		return dp[n];
	}
}