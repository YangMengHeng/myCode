#include <iostream>
#include <algorithm>
#include <cstdio>
#include <string>
#include <istream>
using namespace std;

/*
算法题目：58.最后一个单词的长度(LeetCode)
问题描述：
	给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0。
	单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
输入：
	给定一个仅有空格和字母的字符串。
	1 <= s.length <= 10^4
	s 仅由英文字母和空格 ' ' 组成
输出：
	最后一个单词的长度值
样例输入：
	"hello world"
	"a "
样例输出：
	5
	1
*/

int lengthOfLastWord(string s);


int main(void)
{
	int t;
	string s;

	getline(cin, s);
	t = lengthOfLastWord(s);
	cout << t << endl;

	return 0;
}

int lengthOfLastWord(string s)
{
	/* 执行用例用时较慢的方法，但内存消耗更小 */
	int num = 0, i;

	for (i = s.size() - 1; i >= 0 && s[i] == ' '; i--);
	for (; i >= 0 && s[i] != ' '; i--)
		num++;

	return num;

	/* 执行用例用时更快的方法，但内存消耗更大
	int len = s.size(), num = 0;

		if (s[len - 1] == ' ')
			if (len == 1)
				return 0;
			else
			{
				int j, n = 0;
				for (j = len - 1; j >= 0 && s[j] == ' '; j--)
					n++;
				len = len - n;
			}

		for (int i = len - 1; i >= 0 && s[i] != ' '; i--)
			num++;

		return num;
	*/
}