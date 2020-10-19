#include <iostream>
#include <string>
using namespace std;

/*
算法题目：数字9
问题描述：
	在1至2019中，有多少个数的数位中包含数字9？
	注意，有的数中的数位中包含多个9，这个数只算一次.
	例如，1999这个数包含数字9，在计算时只是算一个数.
输入：
	无
输出：
	输出数量即可
样例输入：
	无
样例输出：
	无
*/

const int N = 2019;
bool checkNine(int t);

int main()
{
	int ans = 0;

	for(int i = 0; i <= N; i++) if(checkNine(i)) ans++;
	printf("%d", ans);

	return 0;
}

bool checkNine(int t)
{
	char temp[5];

	sprintf(temp, "%d", t);
	string s(temp);
	// while(t)
	// {
	// 	int a = t % 10;
	// 	if(a == 9)
	// 		return true;
	// 	t /= 10;
	// }

	// return false;
	return s.find('9') != string::npos;
}