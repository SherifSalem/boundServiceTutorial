bound service tut 
1- first create a local service class extends service , dont forget to add the service to the manifest.
2- creeat instance of IBinder class u should initialize it once declared.
3- in this example we are generating a random number to run from our service to display it in our activity .
4- once the service is created u will notce an error ALT + Enter to implement the onBind method and make it return the mBinder
   variable now in our main awe created.
5- then declare a public class that extends Binder and create method in it to return an instance of our service in our bound activity 
in order to use the functions from the service 
6- we create a public method to generate and return the random int to display it in our activity
7- now in the main activity create an instance of our bound service ,and a boolean variable and initiate it to false
8- implement a Service connection interface , implement its methods , on service connected 
9- in the onService connected method create intialize an instance for our local binder class existed in our service and 
    cast the local variable and get our service, and set mBond to true
10- in onService disconnected we set the mbound variable to false 
11- override the onStart() method in our main activity  and create an intent passing the context , and the service class we want to bind 
12- then we call the bindService method passing the intent we created , the service connection interface, and the Flag ,
in our case we used Context.BIND_AUTO_CREATE, for automatically create the service as long as the binding exists
13- then we set an onClick listener to our button which invoke the method in our service to generate the random number 
    n save it in a a variable which we set in the text view to display 
