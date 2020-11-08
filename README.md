# COVIDSafe
This is a repository for ELEC5619 project.
As the Covid-19 has become a global health crisis, the demands of the innovative technologies on public health surges. This project provides a WebApp to serve doctors who need to detect and monitor the condition of patients, as well as, patients who are required to keep updating the medical information.

# The main features includes:
## Doctor:
### Account Management for Doctor
1. Register: the system should allow doctor to register
2. Login: common login page with option to switch role (doctor or patient)
3. View & change profile page: list the user information such as ID, name, gender, avatar, with a button available to change profile
4. Logout: a button in main pages which enables the user to logout
### Appointment Management for Doctor
1. Appointment page: a place where doctors can view the list of incoming appointment requests with details
2. Confirm Appointment: doctors can confirm an appointment.
3. Cancel Appointment: doctors can cancel an appointment.
### Monitoring for Patients’ Conditions
#### Patient List
doctor can view a list of patients which shows ID, name, gender, age, state, and quarantining duration. Doctors can also add new patients or remove existing patients.
#### Patient Detail
1. Basic information: doctor can view a list of the basic information about the patient including ID, first name, last name, gender, height, weight, phone number, full address, and emergency contact.
2. Medical details
4. Table of conditions: doctor can view data visualization of conditions
5. Others: doctor can view other information including last test time, isolation time, temperature change
6. Notify a patient to make an appointment with the doctor: if the doctor thinks it is necessary to have an appointment, he/she can click a button in the page which will send a notification email to the patient.
## Patient:
### Account Management for Patient
1. Register：All patients are required to register for an account with name, gender, age, height, weight, phone number, email address, emergency contacts, and other pertinent information before they intend to be tested.
2. Login：The login feature allows patients to login the system. Patients need to provide their email address and corresponding password. After logging in, patients can make appointments and other functions.
3. View & Change profile page: All registered patients will have a personal information screen where they can check their ID and the information they have previously filled in when they registered at any time. If any information is found to be incorrectly filled in, it can be changed here.
4. Logout: Patients can logout from the website at any time.
### Appointment Management for Patient
1. Request Appointment: Patients can schedule an appointment for nucleic acid testing as often as they need or schedule a meeting with their doctor if there are any unexpected circumstances that need to be confirmed in person.
2. Cancel Pending Appointment: If a previously scheduled time conflicts, the patient can actively cancel prior to the appointment and wait to schedule the next time.
### Daily check-in
1. Temperature: Patients are required to take the temperature every day according to the method taught at the hospital and upload it to the specified area on their own.
3. Physical condition: In addition to basic information, patients are asked to answer the following questions about their health on a daily basis:
  * Did patients feel like vomiting the last day?
  * Did patients feel cold the last day?
  * Did patients feel dizzy the last day?
  * Did patients feel nauseous the last day?
  * Did patients have running noses the last day?
  * Did patients have any shortness of breath the last day?
  
# Guid to Run the Project

1. Configure database connection information 

~~~java
server.port=8080

spring.datasource.url = jdbc:mysql://localhost:3306/COVIDSafe
spring.datasource.username = username
spring.datasource.password = password
spring.datasource.driverClassName = com.mysql.cj.jdbc.Driver

spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto = update
spring.jpa.database-platform = org.hibernate.dialect.MySQL5Dialect
~~~

2. Start the back-end program

~~~
$ javac COVIDSafe/src/main/java/com/magic/COVIDSafeApplication.java
$ java COVIDSafe/src/main/java/com/magic/COVIDSafeApplication
~~~

3. Start the front-end program

~~~
$ cd student
$ yarn start
~~~

# File Structure

~~~
.
├── COVIDSafe.iml
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── magic
│   │   │           ├── Bean
│   │   │           │   └── UserResponse.java
│   │   │           ├── COVIDSafeApplication.java
│   │   │           ├── config
│   │   │           │   └── CorsConfig.java
│   │   │           ├── controller
│   │   │           │   ├── DoctorController.java
│   │   │           │   ├── PatientController.java
│   │   │           │   └── UserController.java
│   │   │           ├── dao
│   │   │           │   ├── AppointmentDao.java
│   │   │           │   ├── DoctorDao.java
│   │   │           │   ├── PatientDao.java
│   │   │           │   └── StateDao.java
│   │   │           ├── domain
│   │   │           │   ├── Appointment.java
│   │   │           │   ├── Doctor.java
│   │   │           │   ├── Patient.java
│   │   │           │   └── State.java
│   │   │           └── service
│   │   │               ├── DoctorService.java
│   │   │               ├── PatientService.java
│   │   │               ├── UserService.java
│   │   │               └── impl
│   │   │                   ├── DoctorServiceImpl.java
│   │   │                   ├── PatientServiceImpl.java
│   │   │                   └── UserServiceImpl.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   │           └── test.html
│   └── test
│       └── java
│           └── com
│               └── magic
│                   └── COVIDSafeApplicationTests.java
├── target
│   ├── classes
│   │   ├── application.properties
│   │   ├── com
│   │   │   └── magic
│   │   │       ├── Bean
│   │   │       │   └── UserResponse.class
│   │   │       ├── COVIDSafeApplication.class
│   │   │       ├── config
│   │   │       │   └── CorsConfig.class
│   │   │       ├── controller
│   │   │       │   ├── DoctorController.class
│   │   │       │   ├── PatientController.class
│   │   │       │   └── UserController.class
│   │   │       ├── dao
│   │   │       │   ├── AppointmentDao.class
│   │   │       │   ├── DoctorDao.class
│   │   │       │   ├── PatientDao.class
│   │   │       │   └── StateDao.class
│   │   │       ├── domain
│   │   │       │   ├── Appointment.class
│   │   │       │   ├── Doctor.class
│   │   │       │   ├── Patient.class
│   │   │       │   └── State.class
│   │   │       └── service
│   │   │           ├── DoctorService.class
│   │   │           ├── PatientService.class
│   │   │           ├── UserService.class
│   │   │           └── impl
│   │   │               ├── DoctorServiceImpl.class
│   │   │               ├── PatientServiceImpl.class
│   │   │               └── UserServiceImpl.class
│   │   └── templates
│   │       └── test.html
│   ├── generated-sources
│   │   └── annotations
│   ├── generated-test-sources
│   │   └── test-annotations
│   └── test-classes
│       └── com
│           └── magic
│               └── COVIDSafeApplicationTests.class
└── tree.txt
~~~

# Implementation
## Views

In the choice of front-end framework, we choose react framework for faster running speed and better cross browser compatibility. According to the final presentation we want, we designed four pages,  login, register, doctor and patients. In doctor and patient, there are related interfaces with functions such as modifying personal information and viewing appointment. Each front-end interface may involve functions that call the corresponding interface of back-end encapsulation.

## Controllers

According to the content of our project, we divided the controller into three parts, patient controller, doctor controller and a user controller that abstracts similar functions from the first two. For each controller, we have designed a corresponding service layer. The controller is mainly used to connect the data from the front end and define the specific type of input and output. Service layer is the concrete function implementation of controller layer, which realizes the specific function logic required, and is the core point of the back-end. The Dao layer serves the service layer and provides the logic of data operation. The integration of these forms the main logic of the back end.

## DAO

Dao layer is mainly for data operations, including the addition, deletion, modification and query of data in the database. For the four tables in the database, each has a corresponding Dao layer interface. Give service to the methods in the service layer. We inherit these interfaces from the parent class JpaRepository to use its functions like searching in the databese by the key id. In this way, it can save a lot of data related function writing and improve the development efficiency. At the beginning of the project, in order to facilitate testing and continuously optimize the database design, we set the spring.jpa.generate-ddl parameter to true. In this way, we don't need to create the specific table in the database at the beginning, just run the program and it will automatically  generate the corresponding tables. Also, any futher changes will refactor to the database. 

## Tests

The connection between the front end and the back end is in strict accordance with the interface document specified in advance,  in order to facilitate the implementation of this process, we introduced the specification of swagger. In this way, the interface function can be tested with the help of swagger. You can visit this by logging into this [Swagger](http://localhost:8080/swagger-ui.html#/)  in your browser. In this, we can simulate different front-end input observations and test the corresponding output results.

<img src="/Users/yaoyuan/Library/Application Support/typora-user-images/image-20201109012555076.png" alt="image-20201109012555076" style="zoom: 50%;" />

# Dependencies

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.4.RELEASE</version>
        <relativePath/> 
    </parent>
    <groupId>com.magic</groupId>
    <artifactId>spring-test-2</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>spring-test-2</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.5.0</version>
        </dependency>

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.5.0</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.8</version>
        </dependency>

        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.12</version>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```


