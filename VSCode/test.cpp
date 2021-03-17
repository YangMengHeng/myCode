#include <iostream>
#include <algorithm>
#include <cstdio>
#include <string>
using namespace std;

/*
算法题目：28.实现strStr()(LeetCode)
问题描述：
	给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
输入：
	给定两个字符串，一个haystack字符串一个needle字符串。
输出：
	在 haystack 字符串中找出 needle 字符串出现的第一个位置。
样例输入：
	"hello"
	"ll"
	"mississipi"
	"issip"
样例输出：
	2
	4
*/

int strStr(string haystack, string needle);

int main(void)
{
	string s1, s2;

	cin >> s1 >> s2;
	int len = strStr(s1, s2);
	cout << len;
	cout << endl;

	return 0;
}

int strStr(string haystack, string needle)
{
	int pos = 0, num1 = needle.size(), num2, len = 0;
	string s = haystack;

	if (!needle.size())
		return 0;
	while (1)
	{
		num2 = s.size();
		if (num2 < num1)
			return -1;
		pos = s.find_first_of(needle[0]);
		if (pos != string::npos)
		{
			int j = 1;
			len += pos;

			for (; j < num1; j++)
			{
				char c = s[pos + j];
				if (c != needle[j])
				{
					s = s.substr(pos + 1, num2);
					len++;
					break;
				}
			}
			if (j == num1)
				return len;
		}
		else
			return -1;
	}
}