#include <iostream>
#include <vector>
using namespace std;

#define maxLength 1001

/*
算法题目：Least Common Multiple
问题描述：
	The least common multiple (LCM) of a set of positive integers
	is the smallest positive integer which is divisible by all the numbers
	in the set. For example, the LCM of 5, 7 and 15 is 105.
输入：
	Input will consist of multiple problem instances.
	The first line of the input will contain a single integer indicating the number
	of problem instances. Each instance will consist of a single line of
	the form m n1 n2 n3 ... nm where m is the number of integers in the set
	and n1 ... nm are the integers.
	All integers will be positive and lie within the range of a 32-bit integer.
输出：
	For each problem instance, output a single line containing the corresponding LCM.
	All results will lie in the range of a 32-bit integer.
样例输入：
	2
	2 3 5
	3 4 6 12
样例输出：
	15
	12
*/

int n, m, ans, t;
vector<int> result;
int gcb(int a, int b);
int lcm(int a, int b);

int main()
{
	scanf("%d", &n);
    while(n--)
	{
        scanf("%d", &m);
        ans=1;
        for(int i = 1; i <= m; i++){
            scanf("%d", &t);
            ans=lcm(ans, t);
        }
        result.push_back(ans);
    }
	for(int i = 0; i < result.size(); i++)
		printf("%d\n", result[i]);

	return 0;
}

int gcb(int a, int b)
{
	return b ? gcb(b, a % b) : a;
}

int lcm(int a, int b)
{
	return a / gcb(a, b) * b;
}