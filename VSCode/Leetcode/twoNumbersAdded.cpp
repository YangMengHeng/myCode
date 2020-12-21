/*
算法题目：两数相加
问题描述：
	给出两个 非空 的链表用来表示两个非负的整数。
    其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
输入：
	(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：
    7 -> 0 -> 8
样例解释：
    342 + 465 = 807
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int increasementSign = 0;
		ListNode* l3, *l4;

		l3 = new ListNode();
		l4 = l3;
		while (l1 != nullptr || l2 != nullptr)
		{
			int t1 = l1 ? l1->val : 0;
			int t2 = l2 ? l2->val : 0;

			t1 += t2 + increasementSign;
			increasementSign = t1 / 10;

			l4->next = new ListNode(t1 % 10);
			l4 = l4->next;

			if(l1)
				l1 = l1->next;
			if(l2)
				l2 = l2->next;
		}
		if(increasementSign > 0)
			l4->next = new ListNode(increasementSign);
		l3 = l3->next;

		return l3;
    }
};