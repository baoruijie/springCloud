## 初期注意事项：框架搭建

1.使用set ,get 方法，构造方法需要安装Lombok插件。
2.拆分实体类作为独立模块，引用依赖后其他模块可删除实体类。
3.独立配置，启动增加web模块。
4.使用构造方法时，需要在类上声明是否无参构造，或者所有参数构造方法。
5.----------------------------------------------------。
6.至此，springCloud微服务项目粗略框架搭建完成。


## 二期注意事项（后续补充）
0.springCloud各个模块：eureka,[openFeign],loadBalance,hystrix,gateway,config,CAP
1.首先父模块增加版本springcloud管理,后eureka增加依赖spring-cloud-starter-netflix-eureka-server。
3.启动后 http://localhost:8888访问即可。
4.将模块注册到eureka,添加依赖，配置文件增加注册服务器.
5.注册完成后会显示unknow服务名，此时配置模块名即可。
6.增加config类，将指定ip:port调用改为通过服务名调用。
7.配置增加多实例，eureka将通过默认的轮询的负载均衡策略进行调用。

## 如何实现高可用？ 配置多个eureka启动实例，互相注册。
1.详情查看配置文件。通过spring.profiles.active=01指定配置文件。
2.负载均衡@LoadBalance. 此注解会启用拦截器,即LoadBalancerIntercepter,实现了ClientHttpRequestIntercepter接口。
3.修改负载均衡策略。新增LoadBalancerConfig类,后在BeanConfiguration类上增加注解。
