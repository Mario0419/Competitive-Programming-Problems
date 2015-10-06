

// To execute C++, please define "int main()"
#include <iostream>
#include <string>
using namespace std;
 
 
 int R, C;
 bool inbounds(char **arr, int x, int y){
   if(x < 0 || x >= R || y < 0 || y >= C)
     return false;
   if(arr[x][y] == '#')
     return false;
   return true;
 }
 bool dfs(char **arr, int x, int y, int fx, int fy, bool **visited){   
   if(!inbounds(arr, x, y))
     return false;
   
   if(x == fx && y == fy)
     return true;
   
   if(visited[x][y] == true)
 		return false;
 	visited[x][y] = true;

   bool ans = false;
   
    ans |= dfs(arr, x + 1, y, fx, fy, visited);
    ans |= dfs(arr, x - 1, y, fx, fy, visited);
    ans |= dfs(arr, x, y + 1, fx, fy, visited);
    ans |= dfs(arr, x, y - 1, fx, fy, visited);
   
   return ans;
   
 }
 
 
 int main(){
   int TestCases;
   cin >> TestCases;
 
   for(int cse = 0; cse < TestCases; cse++){
     
  
     cin >> R >> C;
     char **arr = new char*[R];
     
     int sx, sy, fx, fy;
     for(int i = 0; i < R; i++){
       arr[i] = new char[C];
       for(int j = 0; j < C; j++){
         cin >> arr[i][j];
         if(arr[i][j] == 'P'){
           sx = i;
           sy = j;
         }
         if(arr[i][j] == 'C'){
           fx = i;
           fy = j;
         }
       }
     }

     bool **visited = new bool*[R];
     for(int i = 0; i < R; i++){
     	visited[i] = new bool[C];
     	for(int j = 0; j < C; j++)
     		visited[i][j] = false;
     }
     
     if(dfs(arr, sx, sy, fx, fy, visited)){
       cout << "yes" << endl;
     }else
       cout << "no" << endl;
     
     
     
     
   }
   return 0;
}

/*

4
2 2
P#
#C
2 2
P_
C_
8 7
__P____
####_##
_____#_
_____#C
##_###_
_____#_
___#_#_
___#___
5 7
__P____
####_##
_____#_
_____#C
##_###_

*/