## Optimistic-locking-jpa-springboot
	
	Optimistic locking is one way of handling concurrent write operations in database table. 
	In Pessimistic locking the lock is held untill transaction is committed. 
	Optimistic locking allows multiple transactions to take place, but only one transaction will succeed, 
	others will fail. 
	So failed transaction are processed again by incrementing the version number. 
	
To know more about version number, optimistic locking take a look at this page
	
[@Version and Optimistic Locking](http://www.byteslounge.com/tutorials/jpa-entity-versioning-version-and-optimistic-locking)
	
 
#### Games table
---------------
 
	Id primary key with auto increment
	Name not null
	Price not null
	Version for optimistic locking
	

> using 'MYSQL' database to store the table. Run the gamesql.sql file for initial table setup
	
### Find and update operations to test the locking
------------------------------------------------
1. Find game by id

	> http://localhost:8080/Games/find/1


2. Update game entry

	> http://localhost:8080/Games/update?id=1&name=AOE&price=1500

 

	
