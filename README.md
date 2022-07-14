# Sql data in a GUI format

This app is my attempt at a GUI application using the Javafx framework.

It is a simple application that provides the user a login screen,to sign-in to the local mysql server to select the different databases,their respective tables and the data stored in the tables in an interactive environment.

This was made using the Java as the backend and Scene Builder as the frontend with some css styling.

# Importing the project

I am using a maven build structure for this project.

To import the project, open it in IntelliJ IDEA and provide the Mysql Connector Module. To do so, download Mysql Connector [Here](https://www.mysql.com/products/connector/). Then navigate to 

> File -> Project Structure -> Modules -> Add(The "+" Icon above the list of modules) -> 1 JARs or Directories.. 

Then provide the path of the Mysql Connector. Click Apply and close.

# Screenshots of the application

![Login Screen](https://i.imgur.com/vhSljJH.png)

![Databases Shown](https://i.imgur.com/WRxSp1A.png)

![Table Data](https://i.imgur.com/T3HcQu4.png)