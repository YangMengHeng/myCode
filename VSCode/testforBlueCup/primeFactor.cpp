#include <iostream>
#include <cmath>
using namespace std;

#define maxLength 10010
/*
算法题目：质因数的个数
问题描述：
	求正整数N(N>1)的质因数的个数。
	相同的质因数需要重复计算。如120=2*2*2*3*5，共有5个质因数。
输入：
	可能有多组测试数据，每组测试数据的输入是一个正整数N，(1<N<10^9)。
输出：
	对于每组数据，输出N的质因数的个数
样例输入：
	120
	200
样例输出：
	5
	5
*/
int n, num;
int primeTable[maxLength], primeCounts = 0;
bool primeSign[maxLength] = { 0 };
void findPrimeTable();

int main()
{
	findPrimeTable();
	while (scanf("%d", &n) != EOF)
	{
		num = 0;
		int sqr = (int)sqrt(1.0 * n);
		for (int i = 0; i < primeCounts && primeTable[i] <= sqr; i++)
		{
			while(n % primeTable[i] == 0)
			{
				n /= primeTable[i];
				num++;
			}
			if(n == 1) break;
		}
		if(n != 1)
			num++;
		printf("%d\n", num);
	}

	return 0;
}

void findPrimeTable()
{
	for(int i = 2; i < maxLength; i++)
	{
		if(primeSign[i] == false)
		{
			primeTable[primeCounts++] = i;
			for(int j = i + i; j < maxLength; j += i)
				primeSign[i] = true;
		}
	}
}