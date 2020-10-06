#include <iostream>
#include <algorithm>
#include <math.h>
using namespace std;

#define maxLength 11

/*
算法题目：全排列(full permutation)
算法核心：
	递归
算法逻辑：
	统计全排列方案数，定义一个标志数组标记参与排列的数字，全排列是把1 ~ n这n个整数按某个顺序摆放；
	所以我们可以利用递归实现按字典序从小到大的顺序输出1 ~ n的全排列，也就是将全排列分解成若干个
	小问题，“输出以1开头的全排列”， “输出以2开头的全排列”.....“输出以n开头的全排列”；
	在此，我们设定一个标志数组标记排列数，设定一个数组存放当前的排列；
算法实现：
	递归式：假设当前已经填好了排列数组的1 ~ index - 1 位数字，此时正准备填写index位数字，根据
	标志数组进行判断，若为false说明该数字已经填写过了，所以不能填写，进入下一次判断，直到填入一
	个数字，之后将填入的数字标志位置为true，接着去处理index + 1位，当递归完成时，再将标志数组位
	置为false，这是因为当递归完成时，相当于本次排列已经结束，可以输出了，所以要将之前改变的标志
	位复位；
	递归边界：当递归数达到n + 1时，说明此时已经将排列数组的1 ~ n位都已经填好了，此时可以把排列
	数组输出，表示生成了一个排列，然后直接return即可；
*/

void permutation(int index);
int inputNumber, generatePermutation[maxLength], flagTable[maxLength] = { false }, permutationNumbers;

int main(void)
{
	while ((cin >> inputNumber) && inputNumber != 0 && inputNumber != EOF)
	{
        permutationNumbers = 0;
		permutation(1);
        cout << permutationNumbers << endl;
	}

	return 0;
}

void permutation(int index)
{
	if (index == inputNumber + 1)
	{
		for (int i = 1; i <= inputNumber; i++) printf("%d", generatePermutation[i]);
		printf("\n");
        permutationNumbers++;
		return;
	}
	for (int k = 1; k <= inputNumber; k++)
	{
		if (flagTable[k] == false)
		{
			generatePermutation[index] = k;
			flagTable[k] = true;
			permutation(index + 1);
			flagTable[k] = false;
		}
	}
}