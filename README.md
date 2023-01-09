# YouthWork

这是仿照[work](https://github.com/ss098/work) 制作出的收集文件并打包工具，用于收集青年大学习截图等
<br />
原项目后端语言采用PHP,本项目为java
## Getting Started Guide ##

### Configuration requirements before development ###

1. JDK 1.8
2. Mysql 8.0
3. Maven 3.6.3
4. Tomact 9.0.70

### **technology involved** ###

1. Servlet4
2. Vue3

### **Installation Steps** ##


1. Clone the repo

```sh
git clone https://github.com/Clevermis/YouthWork.git
```

### **Deploy** ###

1. Create a database named **`youth`** and Execute the **`youth.sql`** file

```sh
CREATE DATABASE youth DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
```
```sh
source youth.sql
```

2. Download all dependent libraries of **`pom.xml`**
```sh
mvn -f pom.xml dependency:copy-dependencies
```

3. If you execute the project on `Windows`, then modify the **`PLATFORM_VERSION`** in **`UploadImgServlet.java`**
```sh
public final static boolean PLATFORM_VERSION = false;
```

4. Configure **`Tomcat`**
```sh
URL: http://localhost:8080/youth
Application context: /
```


### **Maintain** ###

1.Clean up all data in the project

```sh
rm -rf  static/imgs/*
```

### **How to get involved in open source projects** ###

Contributing makes the open source community a great place to learn, inspire, and create. Any contribution you make is **much appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request




