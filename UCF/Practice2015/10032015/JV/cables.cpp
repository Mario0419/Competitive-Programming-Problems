#include <iostream>
#include <set>
#include <cmath>
#include <vector>
#include <iomanip>
#include <cstdio>
#include <algorithm>
using namespace std;

class Edge{
  
  public:
    int s, f;
    double distance;
  
};

class DisjointSet{
  public:
    int *parent;
    
    DisjointSet(int N){
      parent = new int[N];
      for(int i = 0; i < N; i++)
      	parent[i] = i;
    }
  
    int find(int f){
      return (f == parent[f]) ? f : find(parent[f]);
    }
  
    void unionDJ(int n1, int n2){
      int p1 = find(n1);
      while(n2 != parent[n2]){
      	int temp = parent[n2];
        parent[n2] = p1;
        n2 = temp;
      }
      parent[n2] = p1;
    }
};

class Vertex{
  public:
    int x;
    int y;
    
    double distance(const Vertex &other){
      return hypot(x-other.x, y-other.y);
    }
};



bool operator<(const Edge &A, const Edge &B){
  return A.distance < B.distance;
}
int main(){

  while(1){
    
    int N;
    cin >> N;
    if(N == 0) break;
    
    DisjointSet dj(N);
    vector<Edge> e;
    vector<Vertex> v;
    for(int i = 0; i < N; i++){
      Vertex temp;
      cin >> temp.x >> temp.y;
      v.push_back(temp);
    }
    
    for(int i = 0; i < N-1; i++){
      for(int j = i + 1; j < N; j++){
        
        Edge tempE;
        tempE.s = i;
        tempE.f = j;
        tempE.distance = v[i].distance(v[j]);
        e.push_back(tempE);
      }
    }
    sort(e.begin(), e.end());
    double total = 0.0;
    int count = 0;
    vector<Edge>::iterator t = e.begin();
    while(count < N - 1){
      
      if(dj.find(t->s) == dj.find(t->f))
        continue;
      dj.unionDJ(t->s, t->f);
      total += t->distance;
      ++t;
      count++;
      
    }
    
 
    printf("%.2lf\n", total);
    
  }
  return 0;
}


/*


4
0 0
0 10
10 0
10 10
2
0 0
10 10
0


*/