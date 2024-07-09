const express = require("express");
const Eureka = require("eureka-js-client").Eureka;
// const eureka_client = new Eureka({
// 		cwd: `${__dirname}/config`,
// 		filename: 'eureka-config'
// })
const eureka_client = new Eureka({
    instance: {
        app: "nodejs-service",
        hostName: "localhost",
        ipAddr: "127.0.0.1",
        port: {
            $: 8300,
            "@enabled": "true",
        },
        vipAddress: "nodejs-service",
        dataCenterInfo: {
            "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
            name: "MyOwn",
        },
    },
    eureka: {
        host: "localhost",
        port: 8761,
        servicePath: "/eureka/apps",
    },
});

const app = express();
const port = 8300;

app.get("/", (req, res) => {
    res.send("Hello World!");
});
app.get("/node-service/v3/api-docs", (req, res) => {
		const response ={
  "openapi": "3.0.0",
  "info": {
    "title": "node API example",
    "version": "1.0.0"
  },
  "paths": {
    "/": {
      "get": {
        "operationId": "listVersionsv2",
        "summary": "List API versions",
        "responses": {
          "200": {
            "description": "200 response",
            "content": {
              "application/json": {
                "examples": {
                  "foo": {
                    "value": {
                      "versions": [
                        {
                          "status": "CURRENT",
                          "updated": "2011-01-21T11:33:21Z",
                          "id": "v2.0",
                          "links": [
                            {
                              "href": "http://127.0.0.1:8774/v2/",
                              "rel": "self"
                            }
                          ]
                        },
                        {
                          "status": "EXPERIMENTAL",
                          "updated": "2013-07-23T11:33:21Z",
                          "id": "v3.0",
                          "links": [
                            {
                              "href": "http://127.0.0.1:8774/v3/",
                              "rel": "self"
                            }
                          ]
                        }
                      ]
                    }
                  }
                }
              }
            }
          },
          "300": {
            "description": "300 response",
            "content": {
              "application/json": {
                "examples": {
                  "foo": {
                    "value": "{\n \"versions\": [\n       {\n         \"status\": \"CURRENT\",\n         \"updated\": \"2011-01-21T11:33:21Z\",\n         \"id\": \"v2.0\",\n         \"links\": [\n             {\n                 \"href\": \"http://127.0.0.1:8774/v2/\",\n                 \"rel\": \"self\"\n             }\n         ]\n     },\n     {\n         \"status\": \"EXPERIMENTAL\",\n         \"updated\": \"2013-07-23T11:33:21Z\",\n         \"id\": \"v3.0\",\n         \"links\": [\n             {\n                 \"href\": \"http://127.0.0.1:8774/v3/\",\n                 \"rel\": \"self\"\n             }\n         ]\n     }\n ]\n}\n"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/v2": {
      "get": {
        "operationId": "getVersionDetailsv2",
        "summary": "Show API version details",
        "responses": {
          "200": {
            "description": "200 response",
            "content": {
              "application/json": {
                "examples": {
                  "foo": {
                    "value": {
                      "version": {
                        "status": "CURRENT",
                        "updated": "2011-01-21T11:33:21Z",
                        "media-types": [
                          {
                            "base": "application/xml",
                            "type": "application/vnd.openstack.compute+xml;version=2"
                          },
                          {
                            "base": "application/json",
                            "type": "application/vnd.openstack.compute+json;version=2"
                          }
                        ],
                        "id": "v2.0",
                        "links": [
                          {
                            "href": "http://127.0.0.1:8774/v2/",
                            "rel": "self"
                          },
                          {
                            "href": "http://docs.openstack.org/api/openstack-compute/2/os-compute-devguide-2.pdf",
                            "type": "application/pdf",
                            "rel": "describedby"
                          },
                          {
                            "href": "http://docs.openstack.org/api/openstack-compute/2/wadl/os-compute-2.wadl",
                            "type": "application/vnd.sun.wadl+xml",
                            "rel": "describedby"
                          },
                          {
                            "href": "http://docs.openstack.org/api/openstack-compute/2/wadl/os-compute-2.wadl",
                            "type": "application/vnd.sun.wadl+xml",
                            "rel": "describedby"
                          }
                        ]
                      }
                    }
                  }
                }
              }
            }
          },
          "203": {
            "description": "203 response",
            "content": {
              "application/json": {
                "examples": {
                  "foo": {
                    "value": {
                      "version": {
                        "status": "CURRENT",
                        "updated": "2011-01-21T11:33:21Z",
                        "media-types": [
                          {
                            "base": "application/xml",
                            "type": "application/vnd.openstack.compute+xml;version=2"
                          },
                          {
                            "base": "application/json",
                            "type": "application/vnd.openstack.compute+json;version=2"
                          }
                        ],
                        "id": "v2.0",
                        "links": [
                          {
                            "href": "http://23.253.228.211:8774/v2/",
                            "rel": "self"
                          },
                          {
                            "href": "http://docs.openstack.org/api/openstack-compute/2/os-compute-devguide-2.pdf",
                            "type": "application/pdf",
                            "rel": "describedby"
                          },
                          {
                            "href": "http://docs.openstack.org/api/openstack-compute/2/wadl/os-compute-2.wadl",
                            "type": "application/vnd.sun.wadl+xml",
                            "rel": "describedby"
                          }
                        ]
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}

		const resJson = JSON.stringify(response);
		res.send(resJson)
})
app.listen(port, () => {
    console.log(`Example app listening on port ${port}`);
});
eureka_client.start((error) => {
    console.log(
        "----------------------------\nEureka client started with error:",
        JSON.stringify(error),
    );
});
process.on("SIGINT", function() {
    // C-c event handling for client down to Eureka server
    eureka_client.stop((error) => {
        console.log(
            `----------------------\nEureka client stopped with error: `,
            JSON.stringify(error),
        );
        process.exit();
    });
});
