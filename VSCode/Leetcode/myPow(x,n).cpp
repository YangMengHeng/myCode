#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;

/*
算法题目：50.Pow(x, n)(LeetCode)
问题描述：
	实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
输入：
	给定底数x和指数n。
	-100.0 < x < 100.0
	-2^31 <= n <= 2^(31-1)
	-10^4 <= xn <= 10^4
输出：
	pow函数计算后的最终结果值
样例输入：
	2.0 10
	2.1 3
	2.0 -2
样例输出：
	1024.0
	9.261
	0.25
*/

double myPow(double x, int n);
double quickMul(double x, long long int N);


int main(void)
{
	int n;
	double x, s;

	cin >> x >> n;
	s = myPow(x, n);
	cout << s << endl;

	return 0;
}

double myPow(double x, int n)
{
	long long int N = n;

	if (x == 0.0)
		return 0.0;
	if (n == 0 || x == 1.0)
		return 1;
	if (x == -1.0)
		return (n % 2) ? -1.0 : 1.0;

	return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
}

double quickMul(double x, long long int N)
{
	// 迭代
	/*double ans = 1.0;

	while (N > 0)
	{
		if (N % 2)
			ans *= x;
		x *= x;
		N /= 2;
	}

	return ans;*/
	// 迭代结束

	// 递归
	if (N == 0)
		return 1.0;
	double y = quickMul(x, N / 2);

	return (N % 2) ? y * y * x : y * y;
	// 递归结束
}