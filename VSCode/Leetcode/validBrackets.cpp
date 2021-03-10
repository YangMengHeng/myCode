#include <iostream>
#include <algorithm>
#include <cstdio>
#include <string>
#include <unordered_map>
#include <stack>
using namespace std;

/*
算法题目：有效的括号
问题描述：
	给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
	有效字符串需满足：
	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
输入：
	给定一个字符串；
输出：
	true或者false；
样例输入：
	"()"
	"()[]{}"
	")["
	"([)]"
样例输出：
	true
	true
	false
	false
*/

int main(void)
{
	string s;
	unordered_map<char, char> pairs = {
			{')', '('},
			{']', '['},
			{'}', '{'}
	};

	getline(cin, s);
	int len = s.size();

	if (len % 2 != 0)
		cout << "false" << endl;

	stack<char> stk;
	for (char ch : s) {
		if (pairs.count(ch)) {
			if (stk.empty() || stk.top() != pairs[ch]) {
				return false;
			}
			stk.pop();
		}
		else {
			stk.push(ch);
		}
	}

	return stk.empty();
}