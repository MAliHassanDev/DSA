#include <cassert>
#include <iostream>
#include <vector>

/*
  Time Complexity
  - Worst:O(n²)
  - Average:O(n²)
  - Best:O(n)
  Space Complexity
  - O(1)
*/   
class Solution {
 public:
  void insertion_sort(std::vector<int>& vec) {
    int vecSize = (int)vec.size();
    for (int i = 1; i < vecSize; i++) {
      int temp = vec[i];
      int emptyBlock = i;
      while (emptyBlock > 0) {
        if (vec[emptyBlock - 1] < temp) break;
        vec[emptyBlock] = vec[emptyBlock - 1];
        emptyBlock--;
      }
      vec[emptyBlock] = temp;
    }
  }
};

int main() {
  Solution sol;
  std::vector<int> vec{5, 4, 3, 2, 1};
  sol.insertion_sort(vec);
  std::vector<int> result{1, 2, 3, 4, 5};
  assert("Should sort given vector in non-decreasing order" && vec == result);
}