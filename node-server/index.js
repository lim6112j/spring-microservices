const express = require('express')
const Eureka = require('eureka-js-client').Eureka
// const eureka_client = new Eureka({
// 		cwd: `${__dirname}/config`,
// 		filename: 'eureka-config'
// })
const eureka_client = new Eureka({
		instance: {
        app: 'nodejs-service',
        hostName: 'localhost',
        ipAddr: '127.0.0.1',
        port: {
            '$': 8300,
            '@enabled': 'true',
        },
        vipAddress: 'nodejs-service',
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn',
        },
    },
    eureka: {
        host: 'localhost',
        port: 8761,
        servicePath: '/eureka/apps'
    }
})

const app = express()
const port = 8300

app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
eureka_client.start(error => {
    console.log('----------------------------\nEureka client started with error:', JSON.stringify(error));
});
