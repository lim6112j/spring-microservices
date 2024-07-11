const express = require("express");
const Eureka = require("eureka-js-client").Eureka;
const yaml = require('js-yaml');
const fs = require('fs');
const path = require('path');

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

// Load OpenAPI spec from YAML file
const loadOpenApiSpec = () => {
    const filePath = path.join(__dirname, 'openapi-spec.yml');
    try {
        const fileContents = fs.readFileSync(filePath, 'utf8');
        return yaml.load(fileContents);
    } catch (error) {
        console.error('Error loading OpenAPI spec:', error);
        return null;
    }
};

app.get("/", (req, res) => {
    res.send("Hello World!");
});

app.get("/state-layer/v1/api-docs", (req, res) => {
    const openApiSpec = loadOpenApiSpec();
    if (openApiSpec) {
        res.json(openApiSpec);
    } else {
        res.status(500).send('Error loading OpenAPI specification');
    }
});

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
    eureka_client.stop((error) => {
        console.log(
            `----------------------\nEureka client stopped with error: `,
            JSON.stringify(error),
        );
        process.exit();
    });
});
