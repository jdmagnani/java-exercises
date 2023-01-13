# Java Exercises repo

## Pre-requisites

Please make sure you have Java 8 or higher version and also maven installed in your machine.

## How to run the exercises?

* Pelase follow the steps listed below:

1. Clone the repo by running: git clone git@github.com:jdmagnani/java-exercises.git

2. Go to the root folder, java-exercises

3. Run mvn clean install

4. Navigate to the target folder (where the jar's are generated)

5. run the command"

For example to run exercise 1 - PrintNumbersSequence:
``
java -cp exercices-0.0.1-SNAPSHOT-jar-with-dependencies.jar br.com.java.exercises.PrintNumbersSequence
``

In this repo, you'll find two main Java classes:

    *  PrintNumbersSequence: this class has the purpose to solve the following problem desribed below:
      Write or describe an algorithm that prints the whole integer numbers to the console, start from the number 1, and print all numbers going up to the number 100.
      However, when the number is divisible by 3, do not print the number, but print the word 'Visual'. 
      If the number is divisible by 5, do not print the number, but print 'Nuts'. And for all numbers divisible by both (eg: the number 15) the same, but print 'Visual Nuts'.

    This class uses a custom created class called Elements witch implements a custom Iterator.next() method to do the verification if the given nunmber is divided by 3,5 or both and summarizes the result.

    To run this example, once you 

