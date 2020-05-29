How to test the single threaded server?
-------------------------------------------------------------------------------

Server:
$ java -cp target/classes/ org.se.lab.HttpServerSingleThreaded
[Thu Mar 01 14:21:22 CET 2018] Server started...
[Thu Mar 01 14:21:23 CET 2018] ServerSocket[addr=0.0.0.0/0.0.0.0,localport=8080]
[Thu Mar 01 14:21:48 CET 2018] [Thu Mar 01 14:21:48 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47890,localport=8080] - thread id: 1
[Thu Mar 01 14:21:49 CET 2018] [Thu Mar 01 14:21:49 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47892,localport=8080] - thread id: 1
[Thu Mar 01 14:21:50 CET 2018] [Thu Mar 01 14:21:50 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47896,localport=8080] - thread id: 1
[Thu Mar 01 14:21:51 CET 2018] [Thu Mar 01 14:21:51 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47898,localport=8080] - thread id: 1
[Thu Mar 01 14:21:51 CET 2018] [Thu Mar 01 14:21:51 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47900,localport=8080] - thread id: 1
[Thu Mar 01 14:21:52 CET 2018] [Thu Mar 01 14:21:52 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47902,localport=8080] - thread id: 1
[Thu Mar 01 14:21:53 CET 2018] [Thu Mar 01 14:21:53 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47904,localport=8080] - thread id: 1
[Thu Mar 01 14:21:55 CET 2018] [Thu Mar 01 14:21:55 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47906,localport=8080] - thread id: 1

Client:
$ curl -i -X GET http://localhost:8080/index.html

We can also run the "HttpClientTest" class.


How to test the thread per request server?
-------------------------------------------------------------------------------

Server:
$ java -cp target/classes/ org.se.lab.HttpServerThreadPerRequest
[Thu Mar 01 14:22:09 CET 2018] Server started...
[Thu Mar 01 14:22:09 CET 2018] ServerSocket[addr=0.0.0.0/0.0.0.0,localport=8080]
[Thu Mar 01 14:22:13 CET 2018] [Thu Mar 01 14:22:13 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47910,localport=8080] - thread id: 8
[Thu Mar 01 14:22:13 CET 2018] [Thu Mar 01 14:22:13 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47914,localport=8080] - thread id: 9
[Thu Mar 01 14:22:14 CET 2018] [Thu Mar 01 14:22:14 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47916,localport=8080] - thread id: 10
[Thu Mar 01 14:22:15 CET 2018] [Thu Mar 01 14:22:15 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47918,localport=8080] - thread id: 11
[Thu Mar 01 14:22:16 CET 2018] [Thu Mar 01 14:22:16 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47920,localport=8080] - thread id: 12
[Thu Mar 01 14:22:16 CET 2018] [Thu Mar 01 14:22:16 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47922,localport=8080] - thread id: 13
[Thu Mar 01 14:22:17 CET 2018] [Thu Mar 01 14:22:17 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47924,localport=8080] - thread id: 14
[Thu Mar 01 14:22:18 CET 2018] [Thu Mar 01 14:22:18 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47926,localport=8080] - thread id: 15
[Thu Mar 01 14:22:19 CET 2018] [Thu Mar 01 14:22:19 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47928,localport=8080] - thread id: 16
[Thu Mar 01 14:22:20 CET 2018] [Thu Mar 01 14:22:20 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47930,localport=8080] - thread id: 17
[Thu Mar 01 14:22:20 CET 2018] [Thu Mar 01 14:22:20 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47932,localport=8080] - thread id: 18
[Thu Mar 01 14:22:21 CET 2018] [Thu Mar 01 14:22:21 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47934,localport=8080] - thread id: 19
[Thu Mar 01 14:22:22 CET 2018] [Thu Mar 01 14:22:22 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47936,localport=8080] - thread id: 20
[Thu Mar 01 14:22:23 CET 2018] [Thu Mar 01 14:22:23 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47938,localport=8080] - thread id: 21
[Thu Mar 01 14:22:23 CET 2018] [Thu Mar 01 14:22:23 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47940,localport=8080] - thread id: 22
[Thu Mar 01 14:22:24 CET 2018] [Thu Mar 01 14:22:24 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47942,localport=8080] - thread id: 23
[Thu Mar 01 14:22:25 CET 2018] [Thu Mar 01 14:22:25 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47944,localport=8080] - thread id: 24
[Thu Mar 01 14:22:26 CET 2018] [Thu Mar 01 14:22:26 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47946,localport=8080] - thread id: 25
[Thu Mar 01 14:22:26 CET 2018] [Thu Mar 01 14:22:26 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47948,localport=8080] - thread id: 26

Client:
$ curl -i -X GET http://localhost:8080/index.html


How to test the thread pool server?
-------------------------------------------------------------------------------

Server:
$ java -cp target/classes/ org.se.lab.HttpServerThreadPool
[Thu Mar 01 14:26:16 CET 2018] Server started...
[Thu Mar 01 14:26:16 CET 2018] ServerSocket[addr=0.0.0.0/0.0.0.0,localport=8080]
[Thu Mar 01 14:26:20 CET 2018] [Thu Mar 01 14:26:20 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47972,localport=8080] - thread id: 8
[Thu Mar 01 14:26:21 CET 2018] [Thu Mar 01 14:26:21 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47974,localport=8080] - thread id: 9
[Thu Mar 01 14:26:21 CET 2018] [Thu Mar 01 14:26:21 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47976,localport=8080] - thread id: 10
[Thu Mar 01 14:26:22 CET 2018] [Thu Mar 01 14:26:22 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47978,localport=8080] - thread id: 11
[Thu Mar 01 14:26:23 CET 2018] [Thu Mar 01 14:26:23 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47980,localport=8080] - thread id: 12
[Thu Mar 01 14:26:23 CET 2018] [Thu Mar 01 14:26:23 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47982,localport=8080] - thread id: 13
[Thu Mar 01 14:26:24 CET 2018] [Thu Mar 01 14:26:24 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47984,localport=8080] - thread id: 14
[Thu Mar 01 14:26:25 CET 2018] [Thu Mar 01 14:26:25 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47986,localport=8080] - thread id: 15
[Thu Mar 01 14:26:25 CET 2018] [Thu Mar 01 14:26:25 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47988,localport=8080] - thread id: 16
[Thu Mar 01 14:26:26 CET 2018] [Thu Mar 01 14:26:26 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47990,localport=8080] - thread id: 17

[Thu Mar 01 14:26:27 CET 2018] [Thu Mar 01 14:26:27 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47992,localport=8080] - thread id: 8
[Thu Mar 01 14:26:28 CET 2018] [Thu Mar 01 14:26:28 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47994,localport=8080] - thread id: 9
[Thu Mar 01 14:26:29 CET 2018] [Thu Mar 01 14:26:29 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47996,localport=8080] - thread id: 10
[Thu Mar 01 14:26:29 CET 2018] [Thu Mar 01 14:26:29 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=47998,localport=8080] - thread id: 11
[Thu Mar 01 14:26:30 CET 2018] [Thu Mar 01 14:26:30 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=48002,localport=8080] - thread id: 12
[Thu Mar 01 14:26:31 CET 2018] [Thu Mar 01 14:26:31 CET 2018]Socket[addr=/0:0:0:0:0:0:0:1,port=48004,localport=8080] - thread id: 13

Client:
$ curl -i -X GET http://localhost:8080/index.html
