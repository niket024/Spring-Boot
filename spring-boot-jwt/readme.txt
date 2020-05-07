What is JWT?
-------------------
JWT stands for JSON Web Token. 
JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact 
and self-contained way for securely transmitting information between parties as a JSON object. 
This information can be verified and trusted because it is digitally signed. 
The client will need to authenticate with the server using the credentials only once. 
During this time the server validates the credentials and returns the client a JSON Web Token(JWT). 
For all future requests the client can authenticate itself to the server using this JSON Web Token(JWT) 
and so does not need to send the credentials like username and password.

running steps:
open postman:
1. post call with localhost:8080/authenticate 
   body as json
    {
        "username": "javainuse",
        "password": "password"
    }
    
    you will get response
    {"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1ODc2Njg5MzksImlhdCI6MTU4NzY1MDkzOX0.Z5B1El0g7JCpEv0MjBD6JB1WQ1byuAjcX-O8OmVwiF-Lmn7cICZuX-jNOlhb6RDsi_bQDxVpGCic-O_dIAIOjA"}
    
2. get call with localhost:8080/hello
	under header add
	key : Authorization
	value Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1ODc2Njg5MzksImlhdCI6MTU4NzY1MDkzOX0.Z5B1El0g7JCpEv0MjBD6JB1WQ1byuAjcX-O8OmVwiF-Lmn7cICZuX-jNOlhb6RDsi_bQDxVpGCic-O_dIAIOjA

respose : Hello world!

ref: https://www.javainuse.com/spring/boot-jwt	
	     