#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

/*
算法题目：迭代求实数立方根
问题描述：
	立方根的逼近迭代方程是 y(n+1) = y(n)*2/3 + x/(3*y(n)*y(n)),
    其中y(0)=x.求给定的x经过n次迭代后立方根的值.
输入：
	输入有多组数据。
    每组一行，输入x n.
输出：
	迭代n次后的立方根，double精度,保留小数点后面六位.
样例输入：
	4654684 1
    65461 23
样例输出：
	3103122.666667
    40.302088
*/

int main()
{
	int n, d;
	double x;
	vector<double> result;

	while (scanf("%d %d", &d, &n) != EOF)
	{
		x = (double)d;
		double temp = x;
		for (int i = 0; i < n; i++) temp = temp * 2 / 3 + x / (3 * temp * temp);
		result.push_back(temp);
	}
	for (vector<double>::iterator it = result.begin(); it < result.end(); it++)
		printf("%.6lf\n", *it);

	return 0;
}