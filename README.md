Implementing dynamic behavior

Build
1. Visitor
```shell
cd visitor && javac ./*.java && java Main
```
2. Aspect
```shell
cd aspectj && ./ajc -argfile ./sources.lst -cp ./aspectjrt.jar -source 13 && java -cp ./aspectjrt.jar:. Main
```

