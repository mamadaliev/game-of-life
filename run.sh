#!/bin/bash
javac -sourcepath src -classpath lib/stdlib-package.jar -d out src/mamadaliev/Run.java
java -classpath out:lib/stdlib-package.jar mamadaliev.Run
