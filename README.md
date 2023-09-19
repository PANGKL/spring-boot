# spring-boot

Maven Java Project:
mvn clean -> clear "target" folder
mvn compile -> compile java classes to .class (byte code) in target
mvn test -> (include compile), run all test cases
mvn package -> (include compile + test), generate jar in target folder
mvn install -> (include compile+test+package), copy jar to .m2 folder(local repository)

Maven Spring Boot Project:
mvn Spring-Boot:run -> Start up App Server(Web + App)

Runtime Occurrence
Step 1 : @SpringbootApplication(this file should be located on root directory)

Step 2 : @ComponentScan -> Find @Component(@Controller, @Service, @Repository, @Configuration)
Eg. AController.class, Bservice.class

Step 3 : new objects for AController.class & Bservice.class, put them into SpringConext
Step 3.1 : AController.class depends on Bservice.class(Because you @Autowired Bservice.class)
Auto discover which class obj implement that service interface
Step 3.2 : New Bservice.class first
Step 3.3 : It will find the object of Bservice from SpringContext in order to create the new object
of Acontroller(Inject Bservice object into AController object)

Tips;
Error SpringBoot start service

1. If not @Autowired 裝配 but have @Service, Controller method will heat null pointer exception
2. If 2 class object have @Service implement same interface. autowired 唔知裝配邊個,
   normally 1 inter 1 class
3. @Getmapping-> 面果度門（決定能唔能夠接觸到入面）
4. Object 無 state 先可 autowired 任意用
5. @RequestParam 可轉換 field 名
6. @PathVariable 可隱藏 field 名轉成 path
7. 通常入 prama 都是 String, but int 都可,implicty 有 programme 處理 data type validation
8. BeanCreator(start project 自動 intialize) 隨時被 class autoWired, if repeat dataType of @Beam, should be annotate(name = "") and @Qualifier
