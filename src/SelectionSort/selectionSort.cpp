#include <cassert>
#include <iostream>
#include <vector>

class Solution {
 public:
  void selection_sort(std::vector<int>& vec) { // Time: O(n²) Space: O(1)
    int vecSize = (int)vec.size();
    for (int i = 0; i < vecSize - 1; i++) {
      int lowest = i;
      for (int j = i + 1; j < vecSize; j++) {
        if (vec[j] < vec[i]) {
          lowest = j;
        }
      }
      if (lowest != i) {
        int temp = vec[i];
        vec[i] = vec[lowest];
        vec[lowest] = temp;
      }
    }
  }
};

int main() {
  Solution sol;
  std::vector<int> nums = {5, 4, 3, 2, 1};
  sol.selection_sort(nums);
  std::vector<int> result{1, 2, 3, 4, 5};
  assert("Should sort given vector in non-decreasing order" && nums == result);
}