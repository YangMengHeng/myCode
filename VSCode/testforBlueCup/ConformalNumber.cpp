#include <iostream>
using namespace std;

#define maxlength 101

/*
算法题目：守型数
问题描述：
	守形数是这样一种整数，它的平方的低位部分等于它本身。
	比如25的平方是625，低位部分是25，因此25是一个守形数。
	编一个程序，判断N是否为守形数.
输入：
	输入包括1个整数N，2<=N<100
输出：
	可能有多组测试数据，对于每组数据，
	输出"Yes!”表示N是守形数。
	输出"No!”表示N不是守形数。
样例输入：
	6
	11
样例输出：
	Yes!
	No!
*/

int resultNumbers[maxlength] = {0}, resultCounts = 0;
int handleNumber, handleSquare;

int main(void)
{
	int flag;

	while(scanf("%d", &handleNumber) != EOF)
	{
		flag = 1;
		handleSquare = handleNumber * handleNumber;
		while(handleNumber && handleSquare)
		{
			int cmp1 = handleNumber % 10;
			int cmp2 = handleSquare % 10;
			if(cmp1 != cmp2)
			{
				resultNumbers[resultCounts++] = 2;
				flag = 0;
				break;
			}
			handleNumber /= 10;
			handleSquare /= 10;
		}
		if(flag != 0) resultNumbers[resultCounts++] = 1;
	}
	for(int i = 0; i < resultCounts; i++)
	{
		if(resultNumbers[i] == 1) printf("Yes!\n");
		else printf("No!\n");
	}

	return 0;
}
