# IBS-rest service Servlet homework №1

http://localhost:8080/newServlet_war_exploded/ - домашняя страница

![image](https://user-images.githubusercontent.com/92450565/170820527-7fd70650-65ad-49ef-ae68-915405b41ee7.png)

##

# Через Postman:

GET - http://localhost:8080/newServlet_war_exploded/get?id=0 (либо использовать ID юезера, чтобы найти его)

![image](https://user-images.githubusercontent.com/92450565/170819995-f8280199-2ed2-43ad-a713-0428b539853f.png)

##

POST - http://localhost:8080/newServlet_war_exploded/add

{
    "name": "Natasha",
    "surname": "Aleksandrova",
    "salary": 12345
}

![image](https://user-images.githubusercontent.com/92450565/170820257-c8f28926-fb6b-43e9-bdf0-f799b47a7acd.png)

##

PUT - http://localhost:8080/newServlet_war_exploded/put

{ 
    "id": 2, 
    "name": "Tolya",
    "surname": "Meshkov", 
    "salary": 12345
}

![image](https://user-images.githubusercontent.com/92450565/170820315-41b39c5f-3bdd-41b8-9e14-820331f3b4b6.png)

##

DELETE - http://localhost:8080/newServlet_war_exploded/delete

{ 
    "id": 2
}

![image](https://user-images.githubusercontent.com/92450565/170820501-71f62a44-ab01-4408-95f1-e086c3845009.png)
