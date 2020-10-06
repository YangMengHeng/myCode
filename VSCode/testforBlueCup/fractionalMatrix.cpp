#include <iostream>
#include <vector>
using namespace std;

#define maxLength 1001

/*
算法题目：分数矩阵
问题描述：
	我们定义如下矩阵：
	1/1 1/2 1/3
	1/2 1/1 1/2
	1/3 1/2 1/1
	矩阵对角线上的元素始终是1/1，对角线两边分数的分母逐个递增。
	请求出这个矩阵的总和。
输入：
	输入包含多组测试数据。每行给定整数N（N<50000），表示矩阵为N*N。当N=0时，输入结束
输出：
	输出答案，结果保留2位小数
样例输入：
	1
	2
	3
	4
	0
样例输出：
	1.00
	3.00
	5.67
	8.83
*/

int n, t;
vector<double> result;

/*
	本题关键就是理解对称矩阵的特点，
	上下三角矩阵实际上只用算一边就可以了
	不然很容易导致超时错误！
	11 12 13 14 15
	12 11 12 13 14
	13 12 11 12 13
	14 13 12 11 12
	15 14 13 12 11
 */

int main()
{
	while (scanf("%d", &n) != EOF && n != 0)
	{
		double sum = n;
		for (int i = n - 1, j = 2; i > 0; i--,j++) 
			sum += i / (double)j * 2;
		result.push_back(sum);
	}
	for (int i = 0; i < result.size(); i++)
		printf("%.2lf\n", result[i]);

	return 0;
}