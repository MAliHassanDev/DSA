#include <cassert>
#include <iostream>
#include <vector>

/*
  Time Complexity
  - O(n²)
  Space Complexity
  - O(1)
  Steps
  - Worst:O(n²)
  - Average:O(n²/2)
  - Best:O(n)
*/
class Solution {
 public:
  void insertion_sort(std::vector<int>& vec) {
    int vecSize = (int)vec.size();
    int swaps = 0;
    int comparisons = 0;
    for (int i = 1; i < vecSize; i++) {
      int temp = vec[i];
      int emptyBlock = i;
      while (emptyBlock > 0) {
        comparisons++;
        if (vec[emptyBlock - 1] < temp) break;
        swaps++;
        vec[emptyBlock] = vec[emptyBlock - 1];
        emptyBlock--;
      }
      vec[emptyBlock] = temp;
    }
    std::cout << "Comparisons: " << comparisons << " Swaps: " << swaps
              << " Total: " << swaps + comparisons << '\n';
  }
};

int main() {
  Solution sol;
  std::vector<int> vec{1, 2, 3, 4, 5};
  sol.insertion_sort(vec);
  std::vector<int> result{1, 2, 3, 4, 5};
  assert("Should sort given vector in non-decreasing order" && vec == result);
}