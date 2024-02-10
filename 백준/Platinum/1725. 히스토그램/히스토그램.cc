#include <stack>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int N;
vector<int> v(100005);
stack<int> st;
int answer;

int main(){
	cin >> N;
	for (int i = 1; i <= N; i++){
		int t; cin >> t;
		v[i] = t;
	}
	st.push(0);
	for (int i = 1; i <= N + 1; i++){
		while (!st.empty() && v[st.top()] > v[i]){
			int c = st.top();
			st.pop();
			answer = max(v[c] * (i - 1 - st.top()), answer);
		}
		st.push(i);
	}
	printf("%d\n", answer);
	return 0;
}