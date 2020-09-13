#!/usr/bin/env python
# _*_ coding: utf-8 _*_
# @Time: 2020/9/13 2:09 PM
# @Author: wangyong
# @Version: 1.0.0
# @File: microservice-maintain.py
# @desc: 运维服务

from flask import Flask, abort, request, jsonify
import py_eureka_client.eureka_client as eureka_client
import requests, json

app = Flask(__name__)

# 测试数据暂时存放
tasks = []


@app.route('/task', methods=['POST'])
def add_task():
    '''
    :param id
    :param info
    :return: []
    '''
    if not request.json or 'id' not in request.json or 'info' not in request.json:
        abort(400)
    task = {
        'id': request.json['id'],
        'info': request.json['info']
    }
    tasks.append(task)
    return jsonify({'result': 'success'})


@app.route('/task', methods=['PUT'])
def edit_task():
    '''
    :param id
    :param info
    :return:
    '''
    if not request.json or 'id' not in request.json or 'info' not in request.json:
        abort(400)
    task = {
        'id': request.json['id'],
        'info': request.json['info']
    }
    for t in tasks:
        if int(t['id']) == task['id']:
            t['info'] = task['info']
            return jsonify({'result': 'edit success'})
    tasks.append(task)
    return jsonify({'result': 'add success'})


@app.route('/task/<id>', methods=['GET'])
def get_task(id):
    print(type(id))
    if not id:
        return jsonify({'result': 'id is none'})
    else:
        for t in tasks:
            if int(id) == t['id']:
                return jsonify(t)
        return jsonify({'result': 'not found'})


@app.route('/task/list', methods=['GET'])
def get_task_list():
    return jsonify(tasks)


@app.route('/task/path/<path:path>', methods=['GET'])
def get_task_path(path):
    print(path)
    return jsonify(tasks)


@app.route('/task/user/<user_id>', methods=['GET'])
def get_task_by_user(user_id):
    print(user_id)
    res = eureka_client.do_service("microservice-system", "/user/" + user_id)
    print("result from system service:" + res)
    return jsonify(res)


@app.route('/task/requests', methods=['GET'])
def get_task_by_requests():
    system_url = "http://127.0.0.1:11000/user"
    data = json.dumps({'userName': 'test3', 'mobileNumber': '13801010103', 'password': '123456'})
    res = requests.post(system_url, data, headers={'Content-Type': 'application/json'})
    print(res.text)
    print(res.json())
    return jsonify(res.text)


def setEureka():
    '''
    设置eureka
    :param
    :return:
    '''
    server_host = "localhost"
    server_port = 8050
    eureka_client.init(eureka_server="http://localhost:8761/eureka/",
                       app_name="microservice-maintain",
                       # 当前组件的主机名，可选参数，如果不填写会自动计算一个，如果服务和 eureka 服务器部署在同一台机器，请必须填写，否则会计算出 127.0.0.1
                       instance_host=server_host,
                       instance_port=server_port,
                       # 调用其他服务时的高可用策略，可选，默认为随机
                       ha_strategy=eureka_client.HA_STRATEGY_RANDOM)


setEureka();

if __name__ == "__main__":
    # 将host设置为0.0.0.0，则外网可以访问
    app.run(host="0.0.0.0", port=8050, debug=True)
