**Hippodrome (Simulation Project)**

A simple Java project that simulates horse races (hippodrome). This application demonstrates OOP design, logging with file rotation, and comprehensive unit testing using JUnit and Mockito. It does not require a database or external setup — just clone and run.


### Quick Start

**Requirements:**

* Java 18+
* Maven

**Run steps:**

1. Clone the project:

   ```bash
   git clone https://github.com/your-username/J-hippodrome.git
   ```
2. Open the project in IntelliJ IDEA or another IDE.
3. Build the project with Maven:

   ```bash
   mvn clean install
   ```
4. Run the application:

   ```bash
   mvn exec:java
   ```

> ⚠️ Some tests may not run on Java 23 due to library incompatibilities.



### Project Structure

```
J-hippodrome/
├── src/
│   ├── main/
│   │   ├── java/com/hippodrome/...
│   │   └── resources/
│   └── test/
│       └── java/com/hippodrome/...
├── logs/
│   └── hippodrome.log
├── pom.xml
└── README.md
```


### Technologies Used

* Java 18+
* Maven
* JUnit 5
* Mockito
* Log4j2 (RollingFileAppender)
* OOP, static mocking


### Testing

* Uses **JUnit 5** and **Mockito** for unit testing
* Full coverage for the following classes:

  * `Horse` (validation, movement logic)
  * `Hippodrome` (handling list of horses, selecting a winner)
* Tests are located in: `src/test/java`
* Note: Some tests may fail on Java 23 due to incompatibility with certain libraries


### Logging

* Logs are stored in the `logs/hippodrome.log` file
* Configured with file rotation:

  * A new log file is created every day
  * Log files older than 7 days are automatically deleted


### What I Learned

* Practiced writing parameterized and exception-based unit tests
* Gained experience using Mockito and `MockedStatic` for mocking static methods
* Learned to configure Log4j2 for file rotation and cleanup
* Improved understanding of OOP by implementing encapsulated horse race logic
* Worked with assertions and structured test coverage for constructor and method behaviors
