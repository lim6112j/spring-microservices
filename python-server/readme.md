# how to run

models.py defines request and response type


```
pip install -r requirements.txt
flask run --host=0.0.0.0 --port=8500

POST 127.0.0.1:8500/api
content-type: application/json

{
    "startLoc": 1,
    "endLoc": 2,
    "timestamp": 12123
}
```

or

curl -X POST "127.0.0.1:8500/api" -H "Content-Type: application/json" -d '{"startLoc": "1", "endLoc": "2", "timestamp": "12123"}'

// 원도우 curl에서는 '를 "로 변경하고, "를 ""로 변경하고 호출해야함
