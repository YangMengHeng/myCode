#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
#include <cstdio>
#include <string.h>
using namespace std;

#define maxlength 100000

/*
算法题目：哈弗曼树
问题描述：
	在通讯领域，经常需要将需要传送的文字转换成由二进制字符组成的字符串。
	在实际应用中，由于总是希望被传送的内容总长尽可能的短，
	如果对每个字符设计长度不等的编码，
	且让内容中出现次数较多的字符采用尽可能短的编码，
	则整个内容的总长便可以减少。另外，
	需要保证任何一个字符的编码都不是另一个字符的编码前缀，
	这种编码成为前缀编码。
输入：
	输入的第一行包含一个正整数n，表示共有n个字符需要编码。其中n不超过100。
	第二行中有n个用空格隔开的正整数，分别表示n个字符的权值。
输出：
	共n行，每行一个字符串，表示对应字符的赫夫曼编码
样例输入：
	8
	5 29 7 8 14 23 3 11
样例输出：
	0110
	10
	1110
	1111
	110
	00
	0111
	010
*/

int n, heap[maxlength];
void heapSort(int t[]);
void downAdjust(int low, int high);
void creatHeap();

int main(void)
{
    while (scanf("%d", &n) != EOF)
    {
        for (int i = 1; i <= n; i++)
            scanf("%d", &heap[i]);
        heapSort(heap);
        for(int i = 1; i <= n; i++)
            printf("%d ", heap[i]);
        printf("\n");
    }

    return 0;
}

void heapSort(int t[])
{
    creatHeap();
    for(int i = n; i > 1; i--)
    {
        swap(heap[i], heap[1]);
        downAdjust(1, i - 1);
    }
}

void downAdjust(int low, int high)
{
    int i = low;
    int j = 2 * i;

    while(j <= high)
    {
        if(j + 1 <= high && heap[j + 1] > heap[j])
            j++;
        if(heap[j] > heap[i])
        {
            swap(heap[i], heap[j]);
            i = j;
            j = 2 * i;
        }
        else break;
    }
}

void creatHeap()
{
    for(int i = n / 2; i >= 1; i--)
        downAdjust(i, n);
}