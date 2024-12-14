#include <cassert>
#include <iostream>
#include <vector>

/*
  Time Complexity
  - O(n²)
  Space Complexity
  - O(1)
  Steps
  - Worst:O(n²/2)
  - Average:O(n²/2)
  - Best:O(n²/2)
*/
class Solution {
 public:
  void selection_sort(std::vector<int>& vec) { 
    int vecSize = (int)vec.size();
    int comparisons = 0;
    int swaps = 0;
    for (int i = 0; i < vecSize - 1; i++) {
      int lowest = i;
      for (int j = i + 1; j < vecSize; j++) {
        comparisons++;
        if (vec[j] < vec[i]) {
          lowest = j;
        }
      }
      if (lowest != i) {
        swaps++;
        int temp = vec[i];
        vec[i] = vec[lowest];
        vec[lowest] = temp;
      }
    }
    std::cout << "Comparisons: " << comparisons << " Swaps: " << swaps
              << " Total: " << swaps + comparisons << '\n';
  }
};

int main() {
  Solution sol;
  std::vector<int> nums = {1, 2, 3, 4, 5};
  sol.selection_sort(nums);
  std::vector<int> result{1, 2, 3, 4, 5};
  assert("Should sort given vector in non-decreasing order" && nums == result);
}