#include <iostream>
#include <algorithm>
#include <math.h>
#include <stdlib.h>
#include <time.h>
using namespace std;

/*
算法题目：快速排序
问题描述：
	输入n个整数，用快速排序的方法进行排序
	【样例输入】
	5
	12
	18
	14
	13
	16
	【样例输出】
	12
	13
	14
	16
	18
算法核心：
	快速排序算法
算法逻辑：
	快速排序的核心思想是分治，不断的对范围内的某一个元素进行排序
	要求是这个被选中的元素左侧是都比他小的元素，右侧是都比他大的
	元素，选中的元素排好后，将他左右两侧再分别进行相同操作的排序
	这样的话，排序到最后最后一个元素就会在他该在的位置这样就排好
	序了。
	总结如下：
	（1）调整序列中的元素，任意选中一个元素，使当前序列被选中的
	元素在调整后满足左侧所有元素均小于该元素，右侧所有元素均大于
	该元素；
	（2）对该元素的左侧右侧分别进行如（1）的调整，直到当前调整区
	间不超过1.
算法实现：
	主要包括三个模组，第一个是读入数据模块，存储至全局数组numbers
	第二个模块是快速排序模块，利用内核调整函数partition进行区间
	调整，本次采用的是递归算法，便于理解快速排序
	第三个模块是输出模块，输出调整后的数组
	需要注意的是，快速排序有很多种方式，最基础的方式是默认每次都
	选中数组最左侧的元素进行排序，但我们还可以优化！
	可以采用生成随机数的方式选中本次递归调整的元素是哪个，但这种
	方法也存在缺陷，因为随机数底层实现是生成[0, RAND_MAX]范围内
	的整数，而RAND_MAX这个常量是定义在<stdlib.h>这个头文件中的
	每台计算机可能有所不同，不会超过10W，所以针对一些特定的大数
	题目时，比如调整区间范围是[a, b]，而 a和 b可能大于RAND_MAX，
	我们可以优化采用另一种方式，比例系数的方法，先用rand
	函数生成一个[0, RAND_MAX]范围内的整数，然后用这个随机数除以
	RAND_MAX，这样就会得到一个[0, 1]范围内的浮点数，只需要用这
	个浮点数乘以(b - a)，再加上a即可，即
	(int)(round(1.0*rand()/RAND_MAX*(b-a)+a));
	相当于这个浮点数就是[a, b]范围内的比例位置.
*/

int numbers[5001];
int temp, i, j, numberCounts;
int partition(int changeNumber[], int left, int right);
void scanNumbers();
void quickSort(int changeNumber[], int left, int right);
void showResult();
void swap(int &number1, int &number2);

int main(void)
{
	srand((unsigned)time(NULL));
	scanNumbers();
	quickSort(numbers, 0, numberCounts - 1);
	showResult();

	return 0;
}

void swap(int &number1, int &number2)
{
	int t = number1;
	number1 = number2;
	number2 = t;
}

void scanNumbers()
{
	scanf("%d", &numberCounts);
	for(int i = 0; i < numberCounts; i++) scanf("%d", &numbers[i]);
}

void showResult()
{
	for(int i = 1; i <= numberCounts; i++)
	{
		printf("%d", numbers[i - 1]);
		if(i % 8 == 0) printf("\n");
		else printf(" ");
	}
}

int partition(int changeNumber[], int left, int right)
{
	int randNumber = (round(1.0*rand() / RAND_MAX * (right - left) + left));
	swap(changeNumber[left], changeNumber[randNumber]);

	/*
		下面这一部分是基础快速排序的调整区间部分，若是不采用随机数的方式
		，默认选中最左侧元素进行调整，那么删掉上面部分即可
	 */
	temp = changeNumber[left];
	while(left < right)
	{
		while(left < right && changeNumber[right] > temp) right--;
		changeNumber[left] = changeNumber[right];
		while(left < right &&  changeNumber[left] < temp) left++;
		changeNumber[right] = changeNumber[left];
	}
	changeNumber[left] = temp;

	return left;
}

void quickSort(int changeNumber[], int left, int right)
{
	if(left < right)
	{
		int pos = partition(numbers, left, right);
		quickSort(numbers, left, pos - 1);
		quickSort(numbers, pos + 1, right);
	}
}