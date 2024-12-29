target_dir_path=./target/classes

mkdir -p $target_dir_path

javac -sourcepath src/main/java src/main/java/com/practice/app/Main.java -d $target_dir_path

java -cp $target_dir_path com/practice/app/Main