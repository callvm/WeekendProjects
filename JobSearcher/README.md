## Command line job searching tool

This is a command line tool built in Java, which will automatically search the internet for a job / location that you're looking for. The program will traverse all results offered by Google and compile their descriptions into a text file. Finally, the program will analyze the results and display the statistics to you.

The project is compiled using Maven, and takes search terms as command line arguments.

### Compiling

I used NetBeans 11 for this project, but you should be able to compile it from any IDE. You will need Maven installed:

```https://maven.apache.org/download.cgi```

Then, from the command line, run the following inside the project folder.

```mvn clean package```

A jar with dependencies will be built in the /target folder.

### Example usage

```java -jar jobSearcher.java software developer johannesburg```

