How to run: docker-compose up, it will take care of everything
Project has no error handling for connection issues, no tests as they were not mentioned
directly, although good programing practices might indicate they should be here. But I wanted
to keep things short and simple. For same reason I went with very flat package structure.

In case of changing things in app docker-compose up --build
 is required as docker-compose by default doesn't rebuild image. 
 App can by run locally with Intellij, but it will require changing database address
 in application.yml from jdbc:mysql://${DB_HOST}:3306/empik to jdbc:mysql://localhost:3308/empik
 
 Example request:
 curl --location --request GET 'http://localhost:8080/user/octocat'
 
 