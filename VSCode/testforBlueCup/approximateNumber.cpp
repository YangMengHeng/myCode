#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

/*
算法题目：约数的个数
问题描述：
	输入n个整数,依次输出每个数的约数的个数。
输入：
	输入的第一行为N，即数组的个数(N<=1000)
	接下来的1行包括N个整数，其中每个数的范围为(1<=Num<=1000000000)
	当N=0时输入结束。
输出：
	可能有多组输入数据，对于每组输入数据，
	输出N行，其中每一行对应上面的一个数的约数的个数。
样例输入：
	6
	1 4 6 8 10 12
	0
样例输出：
	1
	3
	4
	4
	4
	6
*/

int n, t, tmp[1010], num;
vector<int> result;

int main()
{
	while (scanf("%d", &n) != EOF && n != 0)
	{
		for(int i = 0; i < n; i++)
			scanf("%d", &tmp[i]);
		for(int j = 0; j < n; j++)
		{
			t = (int)sqrt(1.0 * tmp[j]);
			num  = 0;
			for(int i = 1; i <= t; i++)
				if(tmp[j] % i == 0) num += 2;
			if(t * t == tmp[j]) num--;
			result.push_back(num);
		}
		for(int i = 0; i < result.size(); i++)
			printf("%d\n", result[i]);
		result.clear();
	}

	return 0;
}