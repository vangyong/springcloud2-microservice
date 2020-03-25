# 项目简介
本项目是《使用Spring Cloud与Docker实战微服务》：


内容主要包含：

| 微服务角色                 | 对应的技术选型                              |
| --------------------- | ------------------------------------ |
| 注册中心(Register Server) | Eureka                               |
| 服务提供者                 | spring mvc、spring-data-jpa、mysql等       |
| 服务消费者                 | Ribbon/Feign消费服务提供者的接口               |
| 链路监控                   | Hystrix，包括Hystrix Dashboard以及Turbine |
| 配置服务                  | Spring Cloud Config Server           |
| API Gateway           | Zuul                                 |



# 准备

## 环境准备：

| 工具    | 版本或描述                |
| ----- | -------------------- |
| JDK   | 1.8                  |
| IDE   | STS 或者 IntelliJ IDEA |
| Maven | 3.x                  |


## 主机规划：

| 项目名称                                     | 端口   | 描述                     | URL             |
| ---------------------------------------- | ---- | ---------------------- | --------------- |
| microservice-gateway                 | 8050 | API Gateway            | 详见文章            |
| microservice-config                | 8040 | 配置服务                   | 详见文章            |
| microservice-discovery            | 8761 | 注册中心                   | /               |
| microservice-monitor             | 8030 | hystrix监控              | /hystrix.stream |
| microservice-system                      | 12000 | 系统管理服务提供者               | /1              |
| microservice-system-web                  | 12001 | 系统管理服务消费者               | /1              |
| microservice-flowable                    | 12008 | 合同管理服务提供者               | /1              |
| microservice-filecenter                  | 12012 | 文件中心服务                             | /1              |
