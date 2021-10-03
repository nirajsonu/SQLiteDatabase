# SQLiteDatabase
This project helpful to understand inbuild Relational database Sqlite for Android and have all the insert,delete,upadate,select,create operations.

SqliteDatbase is a light weight Relational database developed for small system like mobile developement.<br>
It is store inside user phone Many compines are using SQLite.<br>
It is useful when client is offline,taking backups storing the data.<br>

<B>Steps to use SQLiteDatabase<B>
------------------------------------
1)Create a POJO class.<br>
2)Create a class that extends SQLiteOpenHelper<br>
3)Define table name,columns name
4)write logig for insert,delete,update,select,create.
  
There are two important methods:<br>
onCreate<br>
It invoked when 1st time creating the database.<br>

OnUpgrade<br>
It invoked when you changed the database version.<br>
  


