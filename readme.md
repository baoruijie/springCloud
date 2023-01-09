## step1:初期注意事项：框架搭建

1.使用set ,get 方法，构造方法需要安装Lombok插件。
2.拆分实体类作为独立模块，引用依赖后其他模块可删除实体类。
3.独立配置，启动增加web模块。
4.使用构造方法时，需要在类上声明是否无参构造，或者所有参数构造方法。
5.----------------------------------------------------。
6.至此，springCloud微服务项目粗略框架搭建完成。


## step2:二期注意事项（后续补充）
0.springCloud各个模块：eureka,[openFeign],loadBalance,hystrix,gateway,config,CAP
1.首先父模块增加版本springcloud管理,后eureka增加依赖spring-cloud-starter-netflix-eureka-server。
3.启动后 http://localhost:port 访问即可。
4.将模块注册到eureka,添加依赖，配置文件增加注册服务器.
5.注册完成后会显示unknow服务名，此时配置模块名即可。
6.增加config类，将指定ip:port调用改为通过服务名调用。
7.配置增加多实例，eureka将通过默认的轮询的负载均衡策略进行调用。

## step3:如何实现高可用？ 配置多个注册中心eureka实例，互相注册。@LoadBalance实现负载均衡。
1.详情查看配置文件。通过spring.profiles.active=01指定配置文件。
2.负载均衡@LoadBalance. 此注解会启用拦截器,即LoadBalancerIntercepter,实现了ClientHttpRequestIntercepter接口。
3.修改负载均衡策略。新增LoadBalancerConfig类,后在BeanConfiguration类上增加注解。
##### 问题： 增加注册中心之后，不会显示down的服务，为什么？？

## step4:openFeign 实现负载均衡。
1.feign和RestTemplate类似，也是http客户端请求工具。引入后主要变化是temlate.getForObject(url...)
2.在borrow-service中增加openfeign依赖。
3.在启动类增加注解@EnableFeignClients。
4.增加接口UserClient,增加注解@FeignClient("user-service")，接口增加@RequestMapping("/user/{id}")
                                                 public UserEntity findUserById(@PathVariable("id");
5.在UserBorrow中注入UserClient,通过userClient.findUserById(id),替换templet.getForObject();
 此处由于镜像问题可能无法导入@EnableFeignClients和@FeignClient注解.
 
## step5:服务熔断与降级(为解决分布式雪崩问题Hystrix)。（Hystrix已经凉凉，可通过openFeign实现降级【补救措施】）
1.如服务链：1->2->3->4->5->6 当6不可用，前面都不调用，减少性能消耗，使服务在1就返回结果。
2.在启动类添加注解@EnableHystrix，在方法加上注解 @HystrixCommand(fallbackMethod = "onError")//指定备选方案。
3.理解熔断状态。在一段时间内多次掉调用失败再请求会直接进入备用方案，过一段时间会重新正常执行。周而复始。直到服务可用。
4.openFeign实现降级：创建UserClient的实现类。在接口上声明哪个类作为fallback的实现类。实现类通过注解注册为bean。最后在配置文件中配置熔断。

## step6:监控 pass

## step7：gateway路由网关 路由过滤器
无需增加web依赖，gateway是使用的webFlus的。
目前mac的M1芯片native方法好像不支持。

## step8：配置中心config
一般只是把可能变动的放到配置中心。
举例1：git本地配置中心&github配置中心。 在book-service模块添加bootstrap.yml配置文件。详见配置。
在resource中增加bootstrap.yml文件（名字固定，且中心类似云的标志）
在pom.xml里添加配置中信依赖，包括bootstrap依赖。
举例2：在user-service中增加mysql配置中心。有时间补充。

## step9：分布式ACP原则。

