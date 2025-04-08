#include <iostream>
#include <string>
#include <algorithm>
#include <stdio.h>
#include <vector>
#include <queue>

using namespace std;
priority_queue<int,vector<int>,greater<int> > card;

int main(){
	priority_queue <int, vector <int>, greater <int> > pq;
	int N, sum=0; cin >> N;
	while(N--){
		int tmp; cin >> tmp;
		pq.push(tmp);
	}
	while(pq.size()!= 1){
		int first = pq.top();
		pq.pop();
		int second = pq.top();
		pq.pop();
		sum += first+second;
		
		pq.push(first+second);
	}
	printf("%d\n",sum);
}