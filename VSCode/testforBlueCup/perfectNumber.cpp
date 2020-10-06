#include <iostream>
#include <vector>
using namespace std;

/*
算法题目：完数
问题描述：
	求1-n内的完数，所谓的完数是这样的数，它的所有因子相加等于它自身，
	比如6有3个因子1,2,3,1+2+3=6，那么6是完数。即完数是等于其所有因子相加和的数。
输入：
	测试数据有多组，输入n，n数据范围不大。
输出：
	对于每组输入,请输出1-n内所有的完数。
	如有案例输出有多个数字，用空格隔开，输出最后不要有多余的空格。
样例输入：
	6
样例输出：
	6
*/

int n, t, tmp;
vector<int> result;

int main()
{
	while (scanf("%d", &n) != EOF)
	{
		for (int i = 6; i <= n; i++)
		{
			t = i / 2;
			tmp = 1;
			for (int k = 2; k <= t; k++)
			{
				if (i % k == 0)
					tmp += k;
			}
			if (tmp == i)
				result.push_back(tmp);
		}
		t = result.size();
		for (int i = 0; i < t; i++)
		{
			if (i + 1 == t) printf("%d\n", result[i]);
			else printf("%d ", result[i]);
		}
		result.clear();
	}

	return 0;
}