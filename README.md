# springboot-petclinic
Petclinic Sample application to showcase Spring Boot features

### To run OwnerControllerIT integration test from an editor
* Activate test profile using system variable -Dspring.profiles.active=test
* Or activate using env flag SPRING_PROFILES_ACTIVE=test
* It uses H2 memory DB

### To run OwnerControllerContTest from an editor
* Activate test profile using system variable -Dspring.profiles.active=test-cont
* Or activate using env flag SPRING_PROFILES_ACTIVE=test-cont
* Make sure data.sql and schema.sql files are present under test\resources to create scheam and data


### when using maven to execute unit tests
* Activate profile using system variable -Dspring.profiles.active=test-cont
* Or activate using env flag SPRING_PROFILES_ACTIVE=test-cont
* It executes both unit tests and testcontainer tests.


 


