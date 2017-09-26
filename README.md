# 项目简介
本项目是《使用Spring Cloud与Docker实战微服务》：


内容主要包含：

| 微服务角色                 | 对应的技术选型                              |
| --------------------- | ------------------------------------ |
| 注册中心(Register Server) | Eureka                               |
| 服务提供者                 | spring mvc、spring-data-jpa、h2等       |
| 服务消费者                 | Ribbon/Feign消费服务提供者的接口               |
| 熔断器                   | Hystrix，包括Hystrix Dashboard以及Turbine |
| 配置服务                  | Spring Cloud Config Server           |
| API Gateway           | Zuul                                 |



# 准备

## 环境准备：

| 工具    | 版本或描述                |
| ----- | -------------------- |
| JDK   | 1.8                  |
| IDE   | STS 或者 IntelliJ IDEA |
| Maven | 3.x                  |

## 主机名配置：

| 主机名配置（C:\Windows\System32\drivers\etc\hosts文件） |
| ---------------------------------------- |
| 127.0.0.1 discovery config-server gateway movie user feign ribbon |

## 主机规划：

| 项目名称                                     | 端口   | 描述                     | URL             |
| ---------------------------------------- | ---- | ---------------------- | --------------- |
| microservice-api-gateway                 | 8050 | API Gateway            | 详见文章            |
| microservice-config-client               | 8041 | 配置服务的客户端               | 详见文章            |
| microservice-config-server               | 8040 | 配置服务                   | 详见文章            |
| microservice-consumer-movie-feign        | 8020 | Feign Demo             | /feign/1        |
| microservice-consumer-movie-feign-with-hystrix | 8021 | Feign Hystrix Demo     | /feign/1        |
| microservice-consumer-movie-feign-with-hystrix-stream | 8022 | Hystrix Dashboard Demo | /feign/1        |
| microservice-consumer-movie-ribbon       | 8010 | Ribbon Demo            | /ribbon/1       |
| microservice-consumer-movie-ribbon-with-hystrix | 8011 | Ribbon Hystrix Demo    | /ribbon/1       |
| microservice-discovery-eureka            | 8761 | 注册中心                   | /               |
| microservice-hystrix-dashboard           | 8030 | hystrix监控              | /hystrix.stream |
| microservice-hystrix-turbine             | 8031 | turbine                | /turbine.stream |
| microservice-system                      | 12000 | 系统管理服务提供者               | /1              |
| microservice-system-web                  | 12001 | 系统管理服务消费者               | /1              |
| microservice-contract                    | 12002 | 合同管理服务提供者               | /1              |
| microservice-contract-web                | 12003 | 合同管理服务消费者               | /1              |
| microservice-rabbitmq                    | 12004 | MQ服务提供者                          | /1              |
| microservice-rabbitmq2                   | 12005 | MQ服务提供者2      | /1              |
| microservice-activiti                    | 12006 | 合同管理服务提供者               | /1              |
| microservice-activiti-web                | 12007 | 合同管理服务消费者               | /1              |
| microservice-flowable                    | 12008 | 合同管理服务提供者               | /1              |
| microservice-flowable-web                | 12009 | 合同管理服务消费者               | /1              |
| microservice-performance                 | 12010 | 绩效管理服务提供者               | /1              |
| microservice-shiro                       | 12011 | 权限认证服务提供者               | /1              |
| microservice-filecenter                  | 12012 | 文件中心服务                             | /1              |
