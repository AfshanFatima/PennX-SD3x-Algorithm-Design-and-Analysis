#!/bin/sh
# copy source to test directory
echo "Copying code to test/ directory"
cp ~/workspace/submit/Arbitrage.java .
cp ~/workspace/submit/MST.java .
cp ~/workspace/submit/MyTests.java .

# delete the .class files (if they exist?)
if [ -e Arbitrage.class ]; then
    rm Arbitrage*.class
fi
if [ -e MST.class ]; then
    rm MST*.class
fi
if [ -e MyTests.class ]; then
    rm MyTests.class
fi

# compile their code
echo "Attempting to compile your code"
javac Arbitrage.java
javac MST.java
javac -cp .:hamcrest.jar:junit.jar MyTests.java

# did it compile?
if [ $? -ne 0 ]; then 
    echo "uh oh didn't compile"
    exit 1; 
fi
echo "Successfully compiled code"
# made it here, run the JUnit tests
echo "Running unit tests"
echo
echo "Outputting results of each test case to results.txt"
java -cp .:hamcrest.jar:junit.jar TestRunner $1

echo
echo "Deleting extra files"
rm Arbitrage*.class
rm MST*.class
rm MyTests.class
rm Arbitrage.java
rm MST.java
rm MyTests.java
rm Weighted*.class