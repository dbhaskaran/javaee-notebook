# javaee-notebook

A collection of java application that were build while learning Java EE concepts from various online courses and books.

### Pre-requisite
- JDK
- Eclipse
- Docker
- MySQL
- MySQLWorkbench

```bash
$ docker run -d --name mysql_java -p 3306:3306 -v /Users/mysql:/var/lib/mysql -e 'MYSQL_ROOT_NAME=root' -e 'MYSQL_ROOT_PASSWORD=tiger' mysql:5.7.24
$ docker exec -it mysql_java bash
$ mysql -uroot -p
```
### Project Index
| Project        | Reference    |
| ------------- |:-------------:|
| [simple-todoapp](https://github.com/dbhaskaran/javaee-notebook/tree/master/simple-todoapp)| [Java Servlets and JSP - Build Java EE(JEE) app in 25 Steps](https://www.udemy.com/learn-java-servlets-and-jsp-web-application-in-25-steps) |
| x      | x     |
| x | x      |