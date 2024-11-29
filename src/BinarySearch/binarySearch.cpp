#include <cmath>
#include <iostream>
#include <vector>
#include <cassert>

class Solution {
 public:
  int binary_search(std::vector<int>& nums, int target) {
    int left = 0;
    int right = nums.size() - 1;
    int result = -1;
    while (left <= right) {
      int mid = floor(left + (right - left) / 2);
      if (nums[mid] == target) {
        result = mid;
        break;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }
};


int main() {
  Solution sol;
  std::vector<int> nums = {1, 2, 3, 4, 5};
  int target = 4;
  int result = sol.binary_search(nums, target);
  assert("Result should be 3" && result == 3);
}
