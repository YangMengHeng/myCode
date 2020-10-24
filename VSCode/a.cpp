#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;

#define maxlength 1000

int n, ans;
int Fibonacci(int n);

int main(void)
{
	while (scanf("%d", &n) != EOF)
	{
		ans = Fibonacci(n);
		printf("%d\n", ans);
	}

	return 0;
}

int Fibonacci(int n)
{
	int t[3] = { 0, 1, 1 }, i; // 斐波那契数列前三项为0, 1, 1

	if (n > 2)
	{
		for (i = 3; i <= n; i++)
			t[i % 3] = t[(i + 1) % 3] + t[(i + 2) % 3];
		i--;
	}
	else
		i = n;

	return t[i % 3];
}