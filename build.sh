#!/bin/sh

SOURCE_FILE="$1.cpp"


SOURCE_FILE_PATH=$(find . -type f -name "$SOURCE_FILE")

if [ -z "$SOURCE_FILE_PATH" ] ; then
  echo "Error: File $SOURCE_FILE not found"
  exit 1
fi

mkdir -p build
# Location of build file
EXECUTABLE_FILE=./build/main.exe
# compile the source code
clang++ -std=c++23 -ggdb -pedantic-errors -Wall -Weffc++ -Wextra  $SOURCE_FILE_PATH -o $EXECUTABLE_FILE  && $EXECUTABLE_FILE


if [ $? -eq 0 ]; then 
  echo "Program execution was successful!!";
else 
  echo "Unsuccessful program execution.";
  exit 1;
fi

# Removed flags
# -Werror
# -Wconversion -Wsign-conversion 