#include <iostream>
#include <vector>
using namespace std;

#define maxLength 100010

/*
算法题目：素数
问题描述：
	输入一个整数n(2<=n<=10000)，
	要求输出所有从1到这个整数之间(不包括1和这个整数)个位为1的素数，如果没有则输出-1
输入：
	输入有多组数据。
	每组一行，输入n。
输出：
	输出所有从1到这个整数之间(不包括1和这个整数)
	个位为1的素数(素数之间用空格隔开，最后一个素数后面没有空格)，如果没有则输出-1
样例输入：
	70
样例输出：
	11 31 41 61
*/

int n, tmp = 2, t;
bool primeSign[maxLength] = { 0 };
vector<int> result, primeTable;
void findPrimeTable();

int main()
{
	while (scanf("%d", &n) != EOF)
	{
		findPrimeTable();
		if(result.size() == 0)
			printf("-1\n");
		for (int i = 0; i < result.size() && result[i] < n; i++)
		{
			if(result[i + 1] >= n)
			{
				printf("%d\n", result[i]);
				break;
			}
			if(i + 1 == result.size())
				printf("%d\n", result[i]);
			else
				printf("%d ", result[i]);
		}
	}

	return 0;
}

void findPrimeTable()
{
	for (int i = tmp; i < maxLength; i++)
	{
		if (primeSign[i] == false)
		{
			if (i >= n)
			{
				tmp = i;
				break;
			}
			primeTable.push_back(i);
			for (int j = i + i; j < maxLength; j += i)
				primeSign[j] = true;
			t = i % 10;
			if(t == 1)
				result.push_back(i);
		}
	}
}