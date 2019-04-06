# Conway's Game of Life
Version: 0.2<br>

[![License](https://img.shields.io/badge/license-MIT-brightgreen.svg)](https://mit-license.org/)
[![JDK](https://img.shields.io/badge/JDK-%3E%3D%201.8-d36e6e.svg?style=flat-circle)](https://docs.oracle.com/javase/8/docs/)
<br>

1. [Task](#task)
2. [How to run?](#how-to-run)
3. [Algorithm](#algorithm)
4. [Demo](#demo)
<br>

## Task
Create the [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life) application with the [stdlib](https://introcs.cs.princeton.edu/java/stdlib/) library.
<br>
<br>

## How to run?
<b>1. With bash/bat files:</b>

Run ``compile.sh`` to compile and run ``run.sh`` to run for *nix.<br>
Run ``compile.bat`` to compile and run ``run.bat`` to run for Windows.
<br>
<br>

<b>2. With CLI:</b>
<br>

Compile using
```
javac -sourcepath src -classpath lib/stdlib-package.jar -d out src/mamadaliev/GameRunner.java
```

Run using
```
java -classpath out:lib/stdlib-package.jar mamadaliev.GameRunner
```
<br>

## UML Diagram
<img src="https://i.ibb.co/t34WZGT/uml.png">
<br>

## Algorithm
<b>Life:</b>
neighbors = 3 OR neighbors = 2 AND life cell

<b>Dead:</b>
neighbors = (-ထ; 2) ∪ (2; 3) ∪ (3; +ထ) OR neighbors = 2 AND dead cell
<br>
<br>

## Demo
<img src="https://i.ibb.co/S5xhXmG/gol.gif">
<br>

## Change Log
A change log for the entire project can be found under [CHANGELOG.md](https://github.com/mamadaliev/game-of-life/blob/master/CHANGELOG.md).
<br>

## Contribute
For any problems, comments, or feedback please create an issue [here on GitHub](https://github.com/mamadaliev/game-of-life/issues).
<br>

## Licence
Game of Life is released under the [MIT license](https://en.wikipedia.org/wiki/MIT_License).
