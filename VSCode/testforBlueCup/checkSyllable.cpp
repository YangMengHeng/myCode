#include <iostream>
#include <string>
using namespace std;

/*
算法题目：音节判断
问题描述：
	小明对类似于 hello 这种单词非常感兴趣，这种单词可以正好分为四段，
	第一段由一个或多个辅音字母组成，第二段由一个或多个元音字母组成，
	第三段由一个或多个辅音字母组成，第四段由一个或多个元音字母组成。
	给定一个单词，请判断这个单词是否也是这种单词，如果是请输出yes，否则请输出no.
	元音字母包括 a, e, i, o, u，共五个，其他均为辅音字母。
输入：
	输入一行，包含一个单词，单词中只包含小写英文字母.
输出：
	输出答案，或者为yes，或者为no.
样例输入：
	lanqiao
	world
样例输出：
	yes
	no
*/

char inChar[101];
bool checkSyllable(string t);
bool checkSyllableByStringMethod(string t);

int main()
{
	scanf("%s", inChar);
	string s(inChar);
	if (checkSyllableByStringMethod(s))
		printf("yes\n");
	else printf("no\n");

	return 0;
}

bool checkSyllable(string t)
{
	int nextPos, f1, f2;

	if (t.size() < 4) return false;
	nextPos = f1 = f2 = -1;
	for (int i = 0; i < t.size(); i++)
	{
		if (t[i] == 'a' || t[i] == 'e' || t[i] == 'i' || t[i] == 'o' || t[i] == 'u')
		{
			nextPos = i;
			break;
		}
	}
	if (nextPos == -1) return false;
	for (int i = nextPos + 1; i < t.size(); i++)
	{
		if (t[i] != 'a' && t[i] != 'e' && t[i] != 'i' && t[i] != 'o' && t[i] != 'u')
		{
			nextPos = i;
			f1 = i;
			break;
		}
	}
	if (f1 == -1) return false;
	for (int i = nextPos + 1; i < t.size(); i++)
	{
		if (t[i] == 'a' || t[i] == 'e' || t[i] == 'i' || t[i] == 'o' || t[i] == 'u')
		{
			nextPos = i;
			f2 = i;
			break;
		}
	}
	if (f2 == -1) return false;
	for (int i = nextPos + 1; i < t.size(); i++)
	{
		if (t[i] != 'a' && t[i] != 'e' && t[i] != 'i' && t[i] != 'o' && t[i] != 'u')
			return false;
	}

	return true;
}

bool checkSyllableByStringMethod(string t)
{
	const string yuanYin = "aeiou";

	if (t.size() < 4) return false;
	int index1 = t.find_first_of(yuanYin, 0);
	if (index1 == 0 || index1 == string::npos) return false;

	int index2 = t.find_first_not_of(yuanYin, index1 + 1);
	if (index2 == t.size() - 1 || index2 == string::npos) return false;

	int index3 = t.find_first_of(yuanYin, index2 + 1);
	if (index3 == string::npos) return false;
	if (index3 - 1 != t.find_last_not_of(yuanYin)) return false;

	return true;
}