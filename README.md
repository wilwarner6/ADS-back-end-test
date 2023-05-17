# ADS-back-end-test
Jar file can be found in dist/

The first argument determines which application to run, "Shuffle", or "AddressBook".

To run the application jar, try the following commands:
```
java -jar ./dist/ADS-back-end-test.jar AddressBook ab.xml
java -jar ./dist/ADS-back-end-test.jar AddressBook converted.json
java -jar ./dist/ADS-back-end-test.jar AddressBook converted.xml
java -jar ./dist/ADS-back-end-test.jar Shuffle TOURNAMENT DINNER TOUINN
java -jar ./dist/ADS-back-end-test.jar Shuffle TOURNAMENT DINNER TOUDINN
```
This project was built using Ant. Dependency management is being handled using Ivy.
To build locally, update the "ivy.lib" and "kotlin.lib" paths to the correct paths for your machine in build.xml.

Unit tests can be run using ant:
```
ant test
```
To run the application using ant, try the following commands:
```
ant run -Darg0=Shuffle -Darg1=TOURNAMENT -Darg2=DINNER -Darg3=TOUDINN
ant run -Darg0=Shuffle -Darg1=TOURNAMENT -Darg2=DINNER -Darg3=TOUINN
ant run -Darg0=AddressBook -Darg1=ab.xml
ant run -Darg0=AddressBook -Darg1=converted.json
ant run -Darg0=AddressBook -Darg1=converted.xml
```

Other helpful ant commands:
```
ant clean
ant compile
ant jar
ant init
```
