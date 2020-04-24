1. Assignment-1:

b.  url : http://localhost:8080/bankNameById/{id}
example - //localhost:8080/bankNameById/1


c.  url : http://localhost:8080/bankAddressById/{id}
example - //localhost:8080/bankAddressById/1


d.  you can see all beans in console name as -BEAN 



2. Assignment-2

b. URL - http://localhost:8080/branchListByBankIdAndLocation/{bankId}-{location}
Example -  http://localhost:8080/branchListByBankIdAndLocation/3-BANGALORE


c.  URL - http://localhost:8080/allServicesByBank/{id}
Example - http://localhost:8080/allServicesByBank/2



3. Assignment-3:

http://localhost:8080/actuator/health


4. Assignment-4:

a.  URL- http://localhost:8080/index

b.  URL- http://localhost:8080/displayAll

c. URL- http://localhost:8080/display/<userid>
Example- http://localhost:8080/display/2


5. Assignment-5:

a. GET- http://localhost:8080/display/3
b. POST – http://localhost:8080//employee
 {
        "id": 10,
        "name": "aaru",
        "email": "aaru@gmail.com",
        "location": "address"
    }
 
 
 c. PUT – http://localhost:8080/employee
 {
        "id": 10,
        "name": "aaru",
        "email": "aaru@gmail.com",
        "location": "address"
    }
 d. DELETE - http://localhost:8080/delete/{id}
 Example- http://localhost:8080/delete/2
