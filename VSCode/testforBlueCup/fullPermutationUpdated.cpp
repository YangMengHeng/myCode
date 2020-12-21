#include <iostream>
#include <vector>
using namespace std;

/*
算法题目：给定序列的全排列
问题描述：
	给定一个没有重复数字的序列，返回其所有可能的全排列。
输入：
	给定一个多元素的整形数组；
输出：
	这个整形数组所有可能的排列；
样例输入：
	1 2 3
样例输出：
	1 2 3
    1 3 2
    2 1 3
    2 3 1
    3 1 2
    3 2 1
*/

vector<vector<int>> permutation(vector<int> nums);
void showResult(vector<vector<int>> res);
void generatePermutation(vector<vector<int>> &res, vector<int> &nums, vector<int> &temp, vector<bool> &used, int usedNums);

int main(void)
{
	vector<vector<int>> result;
	vector<int> inputNumVec;
	int inputNumber;

	while ((cin >> inputNumber) && inputNumber != EOF)
		inputNumVec.push_back(inputNumber);
	result = permutation(inputNumVec);
	showResult(result);

	return 0;
}

void showResult(vector<vector<int>> res)
{
	for (int i = 0; i < res.size(); i++)
		for (int k = 0; k < res[i].size(); k++)
		{
			if (k + 1 != res[i].size())
				cout << res[i][k] << " ";
			else
				cout << res[i][k] << endl;
		}
}

vector<vector<int>> permutation(vector<int> nums)
{
	vector<vector<int>> res;
	if (nums.size() == 0)
		return res;
	vector<bool> usedNumSign(nums.size(), false);
	vector<int> tmp;
	generatePermutation(res, nums, tmp, usedNumSign, 0);

	return res;
}

void generatePermutation(vector<vector<int>> &res, vector<int> &nums, vector<int> &temp, vector<bool> &used, int usedNums)
{
	if (usedNums == nums.size())
	{
		res.push_back(temp);
		return;
	}
	for (int i = 0; i < nums.size(); i++)
	{
		if (!used[i])
		{
			used[i] = true;
			temp.push_back(nums[i]);
			generatePermutation(res, nums, temp, used, usedNums + 1);
			used[i] = false;
			temp.pop_back();
		}
	}
}