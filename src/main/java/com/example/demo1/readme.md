# 1-/src/main/java代码目录说明
```
|_annotation：放置项目自定义注解
|_aspect：放置切面代码
|_config：放置配置类
|_constant：放置常量、枚举等定义
   |__consist：存放常量定义
   |__enums：存放枚举定义
|_controller：放置控制器代码
|_filter：放置一些过滤、拦截相关的代码
|_mapper：放置数据访问层代码接口
|_model：放置数据模型代码
   |__entity：放置数据库实体对象定义
   |__dto：存放数据传输对象定义
   |__vo：存放显示层对象定义
|_service：放置具体的业务逻辑代码（接口和实现分离）
   |__intf：存放业务逻辑接口定义
   |__impl：存放业务逻辑实际实现
|_utils：放置工具类和辅助代码



(1)sql table 就是表结构文件中的每一个表格。
(2)POJO = Plain Ordinary Java Object，每一个表格直接对应的Java对象。有一些hibernate注释需要掌握。
(3)DAO = Data Access Object，面向对象的数据库接口 interface。继承自JpaRepository<T,Integer>，不需要用到的功能就不用写。
(4)Service 业务层，需要用到的对数据的增删改查分页等功能都写在了这里，等待Controller控制层的调用。相当于一个函数库。
(5)Controller 控制层，控制页面之间的跳转；与html发生数据交换，决定要调用哪些Service 业务层中的函数。
(6)html 决定了最终显示出来的界面，它可以调用Controller控制层中的函数，也可以把Controller控制层提供的数据显示在页面上。
   写这个html需要学习 html/css/JavaScript/JSON/Vue.js等相关知识。



```
# 2-/src/main/resources目录说明

```
|_mapper：存放mybatis的XML映射文件（如果是mybatis项目）
|_static：存放网页静态资源，比如下面的js/css/img
   |__js：
   |__css：
   |__img：
   |__font：
   |__XXX.html等等
   |__等等
|_template：存放网页模板，比如thymeleaf/freemarker模板等
   |__header
   |__sidebar
   |__bottom
   |__等
|_application.yml       基本配置文件
|_application-dev.yml   开发环境配置文件
|_application-test.yml  测试环境配置文件
|_application-prod.yml  生产环境配置文件
```

# 3-附录
 ## (1)sprintboot常规架构:https://zhuanlan.zhihu.com/p/115403195
