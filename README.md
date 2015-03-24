# hcp
EMR based on mexican standard NOM-004-SSA3 and medical clinic Leon Vannier requirements

To set up development enviroment:

1. Create mysql database:
mysql> create database homeopata charset="UTF8"
2. Import database schema and data
cmd> mysql -u <db-user-name> - p homeopata<homeopata.sql
3. Add com.mysql.jdbc.Driver.jar to Tomcat lib folder
4. Configure Tomcat context resource
<Resource 
		name="jdbc/homeopata" 
		type="javax.sql.DataSource" 
		auth="Container"
    	driverClassName="com.mysql.jdbc.Driver"
		maxActive="20" maxIdle="5" maxWait="10000"
		username="<db-user-name>" password="<db-user-pass>"
		url="jdbc:mysql://localhost/homeopata?useUnicode=true&amp;characterEncoding=UTF-8" />
This step is optional for development since local context project file is included
