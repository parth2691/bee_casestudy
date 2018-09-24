Technologies Used in the Application
		Spring Boot,
		Hibernate,
		MySql,
		Tomcat JDBC Connection pooling library to implement the connection pool.



		
Assumptions
 There are 10 users present in the Database with Username user1,user2,.........,user10 with password "passwd".
 
 every user has an account with account number as BEECS01 for user1  and BEECS02 for user2 and so on.
 every account will have an initial Balance of 10000
 
 A new payee can be added from the existing customers only.

Future balace is calculated using simple interest.

For connection pooling i have used tomcat-jdbc library it comes as default with the spring-boot-starter-data-jpa.




URLs I/P and O/p for each and every functionality.

1) login and logout

http://localhost:8080/login    [post request]

I/P
{
    "username": "user1",
    "password": "passwd"
}

O/p
{
    "userId": 1,
    "username": "user1",
    "password": "passwd",
    "message": "User Logged In successfully",
    "status": true
}
Note: Incase some exception occurs or you enter the wrong credentials then in that case output will only show "message field as not null rest og the fields will be null"

http://localhost:8080/logout [Get request]

 2)Get the balance info
 
 You should be logged in otherwise you will get this output
 
 {
    "holderName": null,
    "balance": 0,
    "accountNumber": null,
    "message": "Session Expired please login"
}
 
 
 http://localhost:8080/getAccountDetails [Get]
 O/P
{
    "holderName": "User1 Name",
    "balance": 5000,
    "accountNumber": "BEECS01",
    "message": null
} 
 
 
 
 3) Add and delete payee.
 
 Payee can be only added from the existing list of users.
 
 http://localhost:8080/getUsers [GET] gives you the existing users list

[
    {
        "userId": 1,
        "username": "user1",
        "password": "passwd",
        "message": null,
        "status": true
    },
    {
        "userId": 2,
        "username": "user2",
        "password": "passwd",
        "message": null,
        "status": true
    },
...
]

	http://localhost:8080/getPayees [GET] username of the benificiary will be displayed in the benificiary field.
	
	
[
    {
        "payeeId": 1,
        "benificiary": "user2"
    },
    {
        "payeeId": 2,
        "benificiary": "user3"
    }
]

http://localhost:8080/savePayee/<username>  [GET]   if you try to add the existing users it will not allow

http://localhost:8080/deletePayee/<username>  [GET]


4) Before transfering fund to a user he should be registered as payee

http://localhost:8080/transcat [POST]

I/P
{
    "payeeName": "user2",
    "amount": "1000"
}

here amount 5000 will be tranfered to user2

O/P
{
    "holderName": "User1 Name",
    "balance": 9000,
    "accountNumber": "BEECS01",
    "message": "Transaction Completed!"
}
In Output message balance will be the updated one. In order to verify for user2 login as user2 and check

5)Calculate the future date

http://localhost:8080/calculateBalance/<future date in YYYY-MM-dd format> [GET]



In order to avoid the DB connection leak i have written the shutdown hook in the Main Function please refer to comments in the file SpringBootApp.java.



Running the Application

Inorder to run the application make sure Java8 and Maven are installed. MySQL is running.
create a db called bee.
Import the database dump bee.sql file
change the database password and username in application.properties
Run the code as normal spring boot Application
