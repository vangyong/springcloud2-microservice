## 运维服务


## 环境安装
1. pip 导出、安装
pip freeze > requirements
pip install -r requirements

2. anaconda 导出、安装
conda list -e > requirements
conda install --yes --file requirements  
 
 
## 测试
POST http://127.0.0.1:8050/task
{
    "id": 1,
    "info": "test"
}

GET http://127.0.0.1:8050/task/1

GET http://127.0.0.1:8050/task/1

