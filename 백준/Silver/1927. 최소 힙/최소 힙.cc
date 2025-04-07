#include <iostream>
#include <string>
#include <algorithm>
#include <stdio.h>
#include <vector>
#include <queue>

using namespace std;
priority_queue<int,vector<int>,greater<int> > least;


int main(){
	int N; 
	scanf("%d",&N);
	
	while(N--){
		int integer;
		scanf("%d",&integer);
		
		if(integer>0){
			least.push(integer);
		}
		else if(!least.empty()){
			printf("%d\n",least.top());
			least.pop();
		}
		else{
			printf("0\n");
		}
			
		}
	}