#include <iostream>
#include <queue>
#include <vector>
using namespace std;

#define maxLength 1001

/*
算法题目：序列计数问题
问题描述：
	小明想知道，满足以下条件的正整数序列的数量：
	第一项为 n；
	第二项不超过 n；
	从第三项开始，每一项小于前两项的差的绝对值。
	请计算，对于给定的 n，有多少种满足条件的序列
输入：
	输入一行包含一个整数 n。
输出：
	输出一个整数，表示答案。答案可能很大，请输出答案除以10000的余数
样例输入：
	4
样例输出：
	7
样例说明:
	4 1
	4 1 1
	4 1 2
	4 2
	4 2 1
	4 3
	4 4
*/

int n, ans, rotateSign, t;

int main()
{
	scanf("%d", &n);
	ans = n;
	for(int i = 1; i < n; i++)
	{
		t = n - i - 1;
		if(t > 0)
			ans += t;
	}
	printf("%d\n", ans);

	return 0;
}