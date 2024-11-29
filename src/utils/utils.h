#ifndef UTILS_H
#define UTILS_H

#include <iostream>
#include <vector>

template <typename T>
void print_vector(const std::vector<T>& vec) {
  if (vec.empty()) {
    std::cout << "[ empty ]\n";
    return;
  }
  std::cout << "[ ";
  for (const auto& value : vec) {
    std::cout << value << " ";
  }
  std::cout << "]\n";
}

#endif
