#include <iostream>
using namespace std;

int n, ans;
int Fibonacci(int n);

int main(void)
{
	while(scanf("%d", &n) != EOF)
	{
		ans = Fibonacci(n);
		printf("%d\n", ans);
	}

	return 0;
}

int Fibonacci(int n)
{
	if(n == 1 || n == 0) return n;
    else return Fibonacci(n - 1) + Fibonacci(n - 2);
}