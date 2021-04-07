#include <iostream>
#include <algorithm>
#include <cstdio>
#include <string>
using namespace std;

/*
算法题目：12.整数转罗马数字(LeetCode)
问题描述：
	给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
输入：
	给定一个整数num.
	1 <= num <= 3999
输出：
	转换后的罗马数字
样例输入：
	3
	4
	9
	58
	1994
样例输出：
	"III"
	"IV"
	"IX"
	"LVIII"
	"MCMXCIV"
*/

string intToRoman(int num);
string romaNumbers[13] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
int values[13] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

int main(void)
{
	int num;

	cin >> num;
	string s = intToRoman(num);
	cout << s << endl;

	return 0;
}

string intToRoman(int num)
{
	string s;

	for (int i = 0; i < 13; i++)
		while (num >= values[i])
		{
			num -= values[i];
			s += romaNumbers[i];
		}

	return s;
}