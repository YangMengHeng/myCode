#include <iostream>
#include <algorithm>
#include <cstdio>
#include <string.h>
using namespace std;

#define maxlength 5001

/*
算法题目：最长回文字符串
问题描述：
	输入一个字符串，求出其中最长的回文子串。子串的含义是：
	在原串中连续出现的字符串片段。回文的含义是：正着看和倒着看相同。
	如abba和yyxyy。在判断回文时，应该忽略所有标点符号和空格，
	且忽略大小写，但输出应保持原样（在回文串的首部和尾部不要输出多余字符）。
	输入字符串长度不超过5000，且占据单独的一行。
	应该输出最长的回文串，如果有多个，输出起始位置最靠左的。
输入：
	一行字符串，字符串长度不超过5000。
输出：
	字符串中的最长回文子串。
样例输入：
	Confuciuss say:Madam,I'm Adam.
样例输出：
	Madam,I'm Adam
*/

int dp[maxlength][maxlength] = { 0 }, t[maxlength], n, j = 0, res;
char A[maxlength], B[maxlength];

int main(void)
{
	fgets(A, 5001, stdin);
	n = strlen(A) - 1;
	for (int i = 0; i < n; i++)
	{
		if (isalpha(A[i]) || isdigit(A[i]))
		{
			if (isalpha(A[i]))
				B[j] = toupper(A[i]);
			else
				B[j] = A[i];
			t[j++] = i;
		}
	}
	n = strlen(B);
	for (int i = 0; i < n - 1; i++)
	{
		dp[i][i] = 1;
		if (B[i] == B[i + 1])
		{
			dp[i][i + 1] = 1;
			res = 2;
		}
	}
	dp[n - 1][n - 1] = 1;

	int maxi = 0, maxj = 0;

	for (int L = 3; L <= n; L++)
	{
		for (int j = n - 1; j - L + 1 >= 0; j--)
		{
			int i = j - L + 1;
			if (B[i] == B[j] && dp[i + 1][j - 1] == 1)
			{
				dp[i][j] = 1;
				res = L;
				maxi = i;
				maxj = j;
			}
		}
	}
	int maxij = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = n - 1; j >= 0; j--)
		{
			if (dp[i][j] == 1 && (j - i) > maxij)
			{
				maxi = i;
				maxj = j;
				maxij = (j - i);
			}
		}
	}
	for (int i = t[maxi]; i <= t[maxj]; i++)
		printf("%c", A[i]);
	printf("\n");

	return 0;
}