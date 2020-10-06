#include <iostream>
using namespace std;

#define maxlength 1000001

/*
算法题目：求第k大数
问题描述：
	给定一个长度为n（1≤n≤1,000,000）的无序正整数序列，以及另一个数k（1≤k≤1,000,000）
	（关于第k大的数：例如序列{1,2,3,4,5,6}中第3大的数是4。）
输入：
	第一行两个正整数m,n。
	第二行为n个正整数。
输出：
	第k大的数。
样例输入：
	6 3
	1 2 3 4 5 6
样例输出：
	4
*/

int numbers[maxlength];
int  n, k;
void merge(int changeNumber[], int left1, int right1, int left2, int right2);
void mergeSort(int changeNumber[], int left, int right);

int main(void)
{
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++) scanf("%d", &numbers[i]);
	mergeSort(numbers, 0, n - 1);
	k--;
	for (int i = n - 2; i >= 0; i--)
	{
		if (k == 0)
		{
			printf("%d", numbers[i + 1]);
			break;
		}
		if (numbers[i] != numbers[i + 1]) k--;
	}

	return 0;
}

void merge(int changeNumber[], int left1, int right1, int left2, int right2)
{
	int i = left1, j = left2;
	int temp[101], index = 0;

	while (i <= right1 && j <= right2)
	{
		if (changeNumber[i] < changeNumber[j]) temp[index++] = changeNumber[i++];
		else temp[index++] = changeNumber[j++];
	}
	while (i <= right1) temp[index++] = changeNumber[i++];
	while (j <= right2) temp[index++] = changeNumber[j++];
	for (int k = 0; k < index; k++) changeNumber[left1 + k] = temp[k];
}

void mergeSort(int changeNumber[], int left, int right)
{
	if (left < right)
	{
		int mid = (left + right) / 2;
		mergeSort(changeNumber, left, mid);
		mergeSort(changeNumber, mid + 1, right);
		merge(changeNumber, left, mid, mid + 1, right);
	}
}