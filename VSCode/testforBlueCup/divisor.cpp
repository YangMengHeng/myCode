#include <iostream>
using namespace std;

/*
算法题目：约数个数
问题描述：
	1200000有多少个约数（只计算正约数）。
输入：
	无
输出：
	输出约数数量即可
样例输入：
	无
样例输出：
	无
*/

int main()
{
	const int N = 1200000;
	int ans = 0;

	for(int i = 1; i * i < N; i++)
	{
		if(N % i == 0)
		{
			if(N % i == i) ans++;
			else ans += 2;
		}
	}
	printf("%d", ans);

	return 0;
}