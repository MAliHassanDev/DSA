#include <cassert>
#include <iostream>
#include <vector>

#include "../utils/utils.h"


/*
  Time Complexity
  - O(n²)
  Space Complexity
  - O(1)
  Steps
  - Worst:O(n²)
  - Average:O(n²/2)
  - Best:O(n²/2)
*/
class Solution {
 public:
  void bubble_sort(std::vector<int>& nums) {  // Time: O(n²) Space: O(1)
    int comparisons = 0;
    int swaps = 0;
    for (int i = nums.size() - 1; i > 0; --i) {
      for (int j = 0; j < i; ++j) {
        comparisons++;
        if (nums[j + 1] < nums[j]) {
          swaps++;
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }
    std::cout << "Comparisons: " << comparisons << " Swaps: " << swaps
              << " Total: " << swaps + comparisons << '\n';
  }
};

int main() {
  Solution sol;
  std::vector<int> nums = {1, 2, 4, 3, 5};
  sol.bubble_sort(nums);
  std::vector<int> result{1, 2, 3, 4, 5};
  assert("Should sort given vector in non-decreasing order" && nums == result);
}
