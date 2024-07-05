from flask import Flask, request, jsonify
from models import APIResponse
import py_eureka_client.eureka_client as eureka_client

app = Flask(__name__)
eureka_client.init(eureka_server="http://localhost:8761/eureka/",instance_host="127.0.0.1", app_name="python-service", instance_port= 8500)
@app.route('/api', methods=['POST'])
def postRequest():
    req_data = request.get_json()
    keys = req_data.keys()
    if 'startLoc' in keys and 'endLoc' in keys and 'timestamp' in keys:
        res = APIResponse(1, [1,2,3], "k", 123123123)
        return jsonify({
            'status': 200,
            'res': res.serialize()
    })
    else:
        return jsonify({
            'status': 400,
            'res': 'wrong request'
        })
if __name__ == '__main__':
    app.run()
