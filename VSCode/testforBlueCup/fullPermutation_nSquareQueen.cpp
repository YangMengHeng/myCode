#include <iostream>
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <cstring>
using namespace std;

#define maxLength 11

/*
算法题目：全排列处理n * n皇后问题(full permutation for n square Queen)
算法核心：
	递归
算法逻辑：
	利用全排列算法，将所有的排列方案数排列出来，若满足皇后排列问题的要求，则对应的排列方案数 + 1；
    需要注意的是，利用全排列算法的排列方案都是不同行不同列，我们只需要对对角线加以判断，相邻皇后
    之间若满足[行值_1 - 列值_2]的绝对值等于[列值_1 - 行值_2]的绝对值的条件则说明两个皇后在同一
    条对角线，故不满足问题解决要求，所以不能使解决方案数 + 1，反之满足 + 1；
算法实现：
    以下为全排列的算法实现
    {
        递归式：假设当前已经填好了排列数组的1 ~ index - 1 位数字，此时正准备填写index位数字，根据
        标志数组进行判断，若为false说明该数字已经填写过了，所以不能填写，进入下一次判断，直到填入一
        个数字，之后将填入的数字标志位置为true，接着去处理index + 1位，当递归完成时，再将标志数组位
        置为false，这是因为当递归完成时，相当于本次排列已经结束，可以输出了，所以要将之前改变的标志
        位复位；
        递归边界：当递归数达到n + 1时，说明此时已经将排列数组的1 ~ n位都已经填好了，此时可以把排列
        数组输出，表示生成了一个排列，然后直接return即可；
    }
    本题的算法实现需要在全排列的基础上作出递归边界的改进，递归边界仍然是表达式index == inputNumber + 1
    但内容有所改变，不再是输出排列数，而是进行判断当前排列是否满足解决问题要求，满足就使解决方案数 + 1，
    否则进行下一次排列；
*/

void permutation(int index);
int inputNumber, generatePermutation[maxLength], flagTable[maxLength] = { false }, permutationNumbers, answerCounts;

int main(void)
{
	while ((cin >> inputNumber) && inputNumber != 0 && inputNumber != EOF)
	{
        permutationNumbers = answerCounts = 0;
		permutation(1);
        cout << permutationNumbers << " " << answerCounts << endl;
	}

	return 0;
}

void permutation(int index)
{
	if (index == inputNumber + 1)
	{
		bool flag = true;
		for(int i = 1; i <= inputNumber; i++)
		{
			for(int k = i + 1; k <= inputNumber; k++)
				if(fabs(i - k) == fabs(generatePermutation[i] - generatePermutation[k])) flag = false;
		}
		if(flag) answerCounts++;
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