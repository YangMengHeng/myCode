#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;

/*
算法题目：大整数排序
问题描述：
	对N个长度最长可达到1000的数进行排序
输入：
	输入第一行为一个整数N，(1<=N<=100)。
	接下来的N行每行有一个数，数的长度范围为1<=len<=1000。
	每个数都是一个正数，并且保证不包含前缀零。
输出：
	可能有多组测试数据，对于每组数据，
	将给出的N个数从小到大进行排序，输出排序后的结果，每个数占一行
样例输入：
	4
	123
	1234
	12345
	23450
样例输出：
	123
	1234
	2345
	12345
*/

struct node{
    char str[1100];
    int len;
}num[110];

bool cmp(node a,node b){
    if(a.len != b.len) return a.len < b.len;
    else return strcmp(a.str, b.str) < 0;
}

int main(void)
{
    int n;

    while(scanf("%d",&n)!=EOF)
	{
    	for(int i=0;i<n;i++)
		{
        	scanf("%s",num[i].str);
        	num[i].len=strlen(num[i].str);
        }
        	sort(num,num+n,cmp);
        	for(int i=0;i<n;i++){
            	printf("%s\n",num[i].str);
        }
    }

    return 0;
}