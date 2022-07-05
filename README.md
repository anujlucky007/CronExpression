# Cron Expression Parser


The script was developed in java and Gradle was used for building and unit testing.
only dependency is junit.


### Building the script
You will need at least Gradle and JDK 11 to build and run the script.

From the project root, do `gradle clean build` :
```bash
$ gralde clean build
..
BUILD SUCCESSFUL in 2s
..
```

### Running the script
execute according to specs:

```bash
 $ gradle run --args '"0 0 1,2,3,15 * 1-5 /usr/bin/find"'

> Task :app:run
Minutes        0
Hour           0
Day of month   1 2 3 15
Month          1 2 3 4 5 6 7 8 9 10 11 12
Day of week    1 2 3 4 5
Command        /usr/bin/find

BUILD SUCCESSFUL in 787ms
2 actionable tasks: 1 executed, 1 up-to-date
```

