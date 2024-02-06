#include <bits/stdc++.h>

using namespace std;

const int maxn = 3e3+10;
const int dx[4] = {1, -1, -1, 1};
const int dy[4] = {1, 1, -1, -1};
const int dcx[4] = {0, -1, -1, 0};
const int dcy[4] = {0, 0, -1, -1};
const int cchar[4] = {'\\', '/', '\\', '/'};

int n, m;
long long dis[maxn][maxn];
string s[maxn];
bool marked[maxn][maxn];
deque<pair<int, int>> d;

bool check(int i, int j){
 return i > -1 && j > -1 && i <= n && j <= m;
}

int main(){
 cin >> n >> m;
 pair<int, int> st, t;
 cin >> st.first >> st.second >> t.first >> t.second;

 for (int i = 0; i < n; i++)
  cin >> s[i];

 if (((st.first + st.second) & 1) != (((t.first+t.second) & 1))){
  cout << -1 << endl;
  return 0;
 }

 for (int i = 0; i <= n; i++) {
  for (int j = 0; j <= m; j++)
   dis[i][j] = 10000000;
 }

 dis[st.first][st.second] = 0;

 d.push_back(st);
 while (!d.empty()){
  auto v = d.front();
  d.pop_front();
  if (marked[v.first][v.second])
   continue;
  marked[v.first][v.second] = true;
  for (int i = 0; i < 4; i++){
   int tx = v.first + dx[i], ty = v.second + dy[i], cx = v.first + dcx[i], cy = v.second + dcy[i];
   if (check(tx, ty) && !marked[tx][ty]){
    if (s[cx][cy] == cchar[i]){
     dis[tx][ty] = min(dis[tx][ty], dis[v.first][v.second]);
     d.push_front(make_pair(tx, ty));
    }
    else {
     dis[tx][ty] = min(dis[tx][ty], dis[v.first][v.second] + 1);
     d.push_back(make_pair(tx, ty));
    }
   }
  }
 }

 cout << dis[t.first][t.second] << endl;
 return 0;
}
