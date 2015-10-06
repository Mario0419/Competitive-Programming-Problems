#include <iostream>
#include <string>
#include <vector>
#include <set>
using namespace std;

class Monster{
  
  public:
    string name;
    int health;
    
    
};

bool operator<(const Monster &A, const Monster &B){
      return A.health < B.health;
    }
int main(){

  while(1){
    int N;
    cin >> N;
    if(N == 0) break;

    set<Monster> v;
    
    for(int i = 0; i < N; i++){
      Monster m;
      cin >> m.name;
      cin >> m.health;
      v.insert(m);
    }
    
    for(set<Monster>::iterator i = v.begin(); i != v.end(); ++i){
      cout << i->name << endl;
    }
    cout << endl;
  }
  return 0;
}
