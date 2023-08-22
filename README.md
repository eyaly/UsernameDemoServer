# Username Demo Server
A demo server that return a valid username for the Sauce Demo Web App    

1. Clone or fork this repoistory 
2. Compile the code:
```bash
javac UsernameServer.java
```
3. Run the Code
```bash
java UsernameServer
```
This will start the server, and it will print a message indicating that the server is running on port 4000.        
             
4. Access the Serve
You can access the server using your web browser or a tool like curl.      
Open your web browser and enter the URL http://localhost:4000/give_me_valid_username.     
You should see the response "standard_user" displayed in your browser.     
Alternatively, if you prefer using curl in the command line, you can run:
```bash
curl http://localhost:4000/give_me_valid_username
```
This will display the "standard_user" response in the terminal.
