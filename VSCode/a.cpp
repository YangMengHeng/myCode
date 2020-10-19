#include <iostream>
#include <cstdio>
#include <cmath>
#include <string>
#include <algorithm>
#include <map>
#include <vector>
using namespace std;

using namespace std;
const int maxn = 100052;
typedef long long int qq;
vector<int> s[maxn];
int n, m, t;

bool f(int x) {
	if (s[x].size() == 0)
		return 0;
	bool ret = 0;
	int now = 2;
	for (int i = 1; i < s[x].size(); i++) {
		now = max(0, now - (s[x][i] - s[x][i - 1] - 1));
		if (now <= 3) ret = 0;
		now += 2;
		if (now > 5) ret = 1;
	}
	now = max(0, now - (t - s[x][s[x].size() - 1]));
	if (now <= 3) ret = 0;
	return ret;
}
int main() {
	scanf("%d%d%d", &n, &m, &t);
	while (m--) {
		int ts, id;
		scanf("%d%d", &ts, &id);
		s[id].push_back(ts);
	}
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		if (f(i) == true)ans++;
	}
	printf("%d\n", ans);
	return 0;
}

