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
  - Best:O(n²/2)
  - Average:O(n²/2)
  - Worst:O(n²)
*/
class Solution {
 public:
  void bubble_sort(std::vector<int>& nums) {  // Time: O(n²) Space: O(1)
    size_t unsorted_until_index = nums.size() - 1;
    bool sorted = false;
    while (sorted == false) {
      sorted = true;
      for (size_t i = 0; i < unsorted_until_index; ++i) {
        int current_num = nums[i];
        int next_num = nums[i + 1];
        if (current_num > next_num) {
          nums[i] = next_num;
          nums[i + 1] = current_num;
          sorted = false;
        }
      }
    }
  }
};

int main() {
  Solution sol;
  std::vector<int> nums = {5, 4, 3, 2, 1};
  sol.bubble_sort(nums);
  std::vector<int> result{1, 2, 3, 4, 5};
  assert("Should sort given vector in non-decreasing order" && nums == result);
}
