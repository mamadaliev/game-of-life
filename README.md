# game-of-life
**v.1.0-dev**<br>

## Stack
- OpenJDK 11
- [Princeton StdLib](https://introcs.cs.princeton.edu/java/stdlib/)

## How to use?

#### Step 1
Clone repository.
```
git clone https://github.com/egnaf/game-of-life
```

#### Step 2
Compile classes.
```
javac -sourcepath src -classpath lib/stdlib-package.jar -d out src/mamadaliev/App.java
```

#### Step 3
Run application.
```
java -classpath out:lib/stdlib-package.jar mamadaliev.App
```

## License
This software is released under the [MIT](http://mitlicense.org) license.
