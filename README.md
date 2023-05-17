# ADS-back-end-test
Jar file can be found in dist/

To run the application, try the following commands:
```
java -jar ./dist/ADS-back-end-test.jar ab.xml
java -jar ./dist/ADS-back-end-test.jar converted.json
java -jar ./dist/ADS-back-end-test.jar converted.xml
java -jar ./dist/ADS-back-end-test.jar TOURNAMENT DINNER TOUINN
java -jar ./dist/ADS-back-end-test.jar TOURNAMENT DINNER TOUDINN
```
This project was built using Ant. Dependency management is being handled using Ivy.
To build locally, update the "ivy.lib" and "kotlin.lib" paths to the correct paths for your machine in build.xml.
