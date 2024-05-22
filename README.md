* cloud-config

````http://localhost:8888/info-foo/bar````

* microservices

http://localhost:8000/dispatch-service/from/(37.33, 127.33)/to/(36.232, 127.333)

http://localhost:8100/location-info/from/(37.33, 127.33)/to/(36.232,127.333)

http://localhost:8100/location-info-feign/from/(37.33, 127.33)/to/(36.232, 127.333)

* naming-server : port 8761

* api-gateway : port 8765 

http://localhost:8765/LOCATION-INFO/location-info/from/(37.33,%20127.33)/to/(36.232,%20127.333)

http://localhost:8765/DISPATCH-SERVICE/dispatch-service/from/(37.33,127.33)/to/(36.232,127.333) 

