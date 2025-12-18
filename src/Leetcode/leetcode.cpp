
#include <iostream>

int findGreatestNumber(int* array, int size) {
  if (size == 1) return array[0];
  int greatestNumber = array[0];
  for (int i = 1; i < size; i++) {
    if (array[i] > greatestNumber) greatestNumber = array[i];
  }
  return greatestNumber;
}

int main() {
  int arraySize = 5;
  int array[arraySize] = {5, 8, 4, 2, 2};
  int greatestNumber = findGreatestNumber(array, arraySize);
  std::cout << "Greatest Number: " << greatestNumber << '\n';
}
