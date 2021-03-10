#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;

/*
算法题目：合并两个有序链表
问题描述：
	将两个升序链表合并为一个新的 升序 链表并返回。
	新链表是通过拼接给定的两个链表的所有节点组成的。
输入：
	给定两个有序链表；
输出：
	合并后的有序链表；
样例输入：
	1 2 4
	1 2 3
样例输出：
	1 1 2 2 3 4
*/
struct ListNode {
	int val;
	ListNode *next;
	ListNode() : val(0), next(nullptr) {}
	ListNode(int x) : val(x), next(nullptr) {}
	ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* mergeTwoLists(ListNode* l1, ListNode* l2);

int main(void)
{
	ListNode *l1, *l2, *l3, *l4;
	int t;

	cin >> t;
	l1 = new ListNode(t);
	l3 = l1;
	while (cin >> t && t != 0)
	{
		l4 = new ListNode(t);
		l3->next = l4;
		l3 = l3->next;
	}
	cin >> t;
	l2 = new ListNode(t);
	l3 = l2;
	while (cin >> t && t != 0)
	{
		l4 = new ListNode(t);
		l3->next = l4;
		l3 = l3->next;
	}
	l3 = mergeTwoLists(l1, l2);
	while (l3 != NULL)
	{
		cout << l3->val << " ";
		l3 = l3->next;
	}
	cout << endl;

	return 0;
}

ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
	if (l1 == nullptr) {
		return l2;
	}
	else if (l2 == nullptr) {
		return l1;
	}
	else if (l1->val < l2->val) {
		l1->next = mergeTwoLists(l1->next, l2);
		return l1;
	}
	else {
		l2->next = mergeTwoLists(l1, l2->next);
		return l2;
	}
}