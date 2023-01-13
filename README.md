# Java Exercises

## Pre-requisites

Please make sure you have Java 8 or higher version and also maven installed in your machine.

## How to run the exercises?

### Please follow the steps listed below:

1. Clone the repo by running: git clone git@github.com:jdmagnani/java-exercises.git

2. Go to the root folder, java-exercises

3. Run mvn clean install

4. Navigate to the target folder (where the jar's are generated)

5. run the commands

Exercise1 - PrintNumbersSequence:

```
java -cp exercices-0.0.1-SNAPSHOT-jar-with-dependencies.jar br.com.java.exercises.PrintNumbersSequence
```

Exercise2 - ParseJsonData:


```
java -cp exercices-0.0.1-SNAPSHOT-jar-with-dependencies.jar br.com.java.exercises.ParseJsonData <optional-countries-json-file-path>
```
In case of any file path passed, the class will use the default one under `src/main/resources/countries.json`.

## Brief explanation about the exercise classes

In this repo, you'll find two main Java classes:

[PrintNumbersSequence](https://github.com/jdmagnani/java-exercises/blob/main/src/main/java/br/com/java/exercises/PrintNumbersSequence.java)

This class has the purpose to solve the following problem desribed below:

- Write or describe an algorithm that prints the whole integer numbers to the console, start from the number 1, and print all numbers going up to the number 100.However, when the number is divisible by 3, do not print the number, but print the word 'Visual'. If the number is divisible by 5, do not print the number, but print 'Nuts'. And for all numbers divisible by both (eg: the number 15) the same, but print 'Visual Nuts'.

- This class uses a custom created class called Elements witch implements a custom Iterator.next() method to do the verification if the given nunmber is divided by 3,5 or both and summarizes the result.


[ParseJsonData](https://github.com/jdmagnani/java-exercises/blob/main/src/main/java/br/com/java/exercises/ParseJsonData.java)

This class has the purpose to solve the following problem desribed below:

- Image you have a set of data in JSON, describing official languages spoken by countries, as such:


```
[
	{
		"country": "US",
		"languages": ["en"]
	},
	{
		"country": "BE",
		"languages": ["nl","fr","de"]
	}
]
```

- Create a class that will parse the JSON and provide the following data:
1. returns the number of countries in the world
2. finds the country with the most official languages, where they officially speak German (de).
3. counts all the official languages spoken in the listed countries.
4. finds the country with the highest number of official languages.
5. finds the most common official language(s), of all countries. 

- In this class, I'm using the Jackson parser library to be able to parse the JSON and generate the report with the five items listed above.

