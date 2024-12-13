#include <cassert>
#include <iostream>
#include <vector>

#include "../utils/utils.h"

class Solution {
 public:
  void bubble_sort(std::vector<int>& nums) {  // Time: O(n²) Space: O(1)
    for (int i = nums.size() - 1; i > 0; --i) {
      for (int j = 0; j < i; ++j) {
        if (nums[j + 1] < nums[j]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
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
