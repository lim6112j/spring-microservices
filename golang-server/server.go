package main

import (

	"net/http"

	"github.com/ArthurHlt/go-eureka-client/eureka"
	"github.com/gin-gonic/gin"
)
func main() {

	client := eureka.NewClient([]string{
		"http://127.0.0.1:8761/eureka", //From a spring boot based eureka server
		// add others servers here
	})
	instance := eureka.NewInstanceInfo("localhost", "go-service","127.0.0.1", 8400, 30, false) //Create a new instance to register
	instance.Metadata = &eureka.MetaData{
		Map: make(map[string]string),
	}
	instance.Metadata.Map["foo"] = "bar" //add metadata for example
	client.RegisterInstance("go-service", instance) // Register new instance in your eureka(s)


	client.GetApplication(instance.App) // retrieve the application "go-service"
	client.GetInstance(instance.App, instance.HostName) // retrieve the instance from "eureka" inside "go-service"" app
	client.SendHeartbeat(instance.App, instance.HostName) // say to eureka that your app is alive (here you must send heartbeat before 30 sec)

	r := gin.Default()
	r.GET("/ping", func(c *gin.Context){
		c.JSON(http.StatusOK, gin.H{
			"message": "pong",
		})
	})
	r.GET("/info", func(c *gin.Context){
		c.JSON(http.StatusOK, gin.H{
			"message": "OK",
		})
	})
	r.Run(":8400")
}
