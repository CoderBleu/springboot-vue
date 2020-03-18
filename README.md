## 电商后台管理系统(Springboot 项目)

[Demo Site](http://43.226.35.120/)
[My Blog](http://coderblue.cn/)

### 功能

> 用于管理用户账号，商品分类，商品信息，订单，数据统计等业务功能

![](./src/assets/mall_desc01.png)

### 开发模式

> 电商后台管理系统整体采用前后端分离的开发模式,其中前端项目是基于 Vue 技术栈的 SPA 项目

![](./src/assets//mall_desc02.png)

### 技术选型

#### 前端项目技术栈

- Vue
- Vue-router
- Element-UI
- Axios
- Echarts

#### 后端项目技术栈

- Springboot
- Mysql(开始用的 Oracle，在部署服务器的时候遂更改)
- Mybatis

### 项目初始化

#### 前端项目初始化步骤

1. 安装 Vue 脚手架
2. 通过 Vue-Cli 创建项目
3. 配置 Vue-router
4. 配置 Element-UI 组件库
5. 配置 Axios 库
6. 初始化 git 远程仓库

##### 相关依赖-按需导入

![](./src/assets//mall_desc03.png)

#### 后端项目的环境安装配置

1. 安装 MySQL8.0 数据库
2. 数据库表：[数据库代码文件](./mall_vue.sql)

- 创建电商商品表

```sql
CREATE TABLE `mall_goods`  (
  `id` int(11) NOT NULL,
  `cat_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cat_deleted` int(255) NOT NULL,
  `cat_level` int(255) NOT NULL,
  `cat_pid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```

- 创建电商权限表

```sql
CREATE TABLE `mall_powers`  (
  `id` int(11) NOT NULL,
  `auth_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` int(255) NOT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```

- 创建用户角色表

```sql
CREATE TABLE `mall_roles`  (
  `id` int(11) NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```

-

```sql 用户表
CREATE TABLE `mall_users`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` int(255) NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```

- 角色权限的中间表

```sql
CREATE TABLE `roles_powers`  (
  `roles_id` int(11) NOT NULL,
  `powers_id` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```

3. 使用 Postman 测试后台项目接口是否正常
   ![](https://img-blog.csdnimg.cn/2020031817462317.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNDc2NDY1,size_16,color_FFFFFF,t_70)

4. 创建 idea 的 springboot 工程，导入相关依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-config</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.1.1</version>
</dependency>
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.20</version>
</dependency>
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper-spring-boot-starter</artifactId>
    <version>1.2.12</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j.adapters</groupId>
    <artifactId>log4j-to-slf4j</artifactId>
    <version>2.0-beta4</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
    <exclusions>
        <exclusion>
            <groupId>org.junit.vintage</groupId>
            <artifactId>junit-vintage-engine</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.66</version>
</dependency>
```
5. 注意：本地访问路径- localhost:8081/index.html，如有弹窗：用户名默认user，密码在控制台生成的

### 登录概述

#### 登录业务流程

1. 在登录页面输入用户名和密码
2. 调用后台接口进行验证
3. 通过验证之后,根据后台的响应状态跳转到项目主页

#### 登录业务相关技术点

1. http 是无状态的
2. 通过 cookie 在客户端记录状态
3. 通过 sesion 在服务器端记录状态
4. 通过 token 维持状态(不允许跨域使用)

![](./src/assets//mall_desc04.png)

#### 登录业务流程

##### 登录页面的布局

通过 Element-UI 组件实现布局

- el-form
- el-form-item
- el-input
- el-button
- 字体图标

##### 创建 git 分支

```
// 创建并切换登录分支
git checkout -b login

// login分支合并到主分支
// 1.切换到master分支
git checkout master
// 2.合并分支到master
git merge login

// 将本地login子分支推送到github
git push -u origin login
```

##### 路由导航守卫控制访问权限

> 如果用户没有登录,但是直接通过 URL 访问特定页面,需要重新导航到登录页面

```js
//为路由对象,添加beforeEach导航守卫
router.beforeEach((to, from, next) => {
  //如果用户访问的登录页,直接放行
  if (to.path === "login") return next();
  //从sessionStorage中获取到保存的token值
  const tokenStr = window.sessionStorage.getItem("token");
  //如果么有token,强制跳转到登录页
  if (!tokenStr) return next("/login");
  next();
});
```

### 主页布局

#### 通过接口获取菜单数据

> 通过 axios 请求拦截器添加 token,保证拥有获取数据的权限

```js
// axios请求拦截
axios.interceptors.request.use(config => {
  // 为请求头对象,添加token验证的Authorization字段
  config.headers.Authorization = window.sessionStorage.getItem("token");
  return config;
});
```

### 权限管理

#### 权限管理业务分析

> 通过权限管理模块控制不同的用户可以进行哪些操作,具体可以通过角色的方式进行控制,即每个用户分配一个特定的角色,角色包括不同的功能权限

![](./src/assets//mall_desc05.png)

### 分类管理

#### 商品分类概述

> 商品分类用于在购物时,快速找到需要购买的商品,进行直观显示

### 参数管理

#### 参数管理概述

> 商品参数用于显示商品的特征信息,可以通过电商平台详情页面直观的看到

### 项目所用依赖(vue 全家桶不描述)

1. 运行依赖

- axios => 发送请求
- echarts => 图表
- element-ui => element ui 组件
- lodash => js 工具库,该项目用到深拷贝与对象合并
- moment => 时间处理工具库
- nprogress => 进度条库
- v-viewer => 图片预览工具库
- vue-quill-editor => 富文本编辑器
- vue-table-with-tree-grid => 树形菜单/表格

2. 开发依赖

- babel => es6+语法转换
- eslint/babel-eslint => 语法检查
- less/less-loader => less 语法
- babel-plugin-transform-remove-console => 移除 console 插件

### 项目优化

### 项目优化策略

- 生成打包报告

  - 通过命令行参数形式生成报告=>vue-cli-service build --report
  - 通过可视化 ui 面板直接查看报告(通过控制台和分析面板)

- 通过 vue.config.js 修改 webpack 的默认配置

  > 通过 vue-cli 3.0 工具生成的项目,默认隐藏了所有 webpack 的配置项,目的是为了屏蔽项目的配置过程,让开发人员把工作的 重心,放在具体功能和业务逻辑的实现上

- 为开发模式与发布模式指定不同的打包入口

  > 默认情况下,vue 项目的开发与发布模式,共用同一个打包的入口文件(即 src/main.js),为了将项目的开发过程与发布过程分离,可以为两种模式,各自指定打包的入口文件,即:
  >
  > 1. 开发模式入口文件 src/main-dev.js
  > 2. 发布模式入口文件 src/main-prod.js
  >
  > 方案：configureWebpack(通过链式编程形式)和 chainWebpack(通过操作对象形式)
  >
  > 在 vue.config.js 导出的配置文件中,新增 configureWebpack 或 chainWebpack 节点,来自定义 webpack 的打包配置

  ```js
  // 代码示例
  module.exports = {
    chainWebpack: config => {
      // 发布模式
      config.when(process.env.NODE_ENV === "production", config => {
        config
          .entry("app")
          .clear()
          .add("./src/main-prod.js");
      });
      // 开发模式
      config.when(process.env.NODE_ENV === "development", config => {
        config
          .entry("app")
          .clear()
          .add("./src/main-dev.js");
      });
    }
  };
  ```

- 第三方库启用 CDN

  - 通过 externals 加载外部 cdn 资源

  > 默认情况下,通过 import 语法导入的第三方依赖包,最终会打包合并到同一个文件中,从而导致打包成功后,单文件体积过大的问题 => **chunk-vendors**体积过大
  >
  > 为了解决上述问题,可以通过 webpack 的 externals 节点,来配置加载外部的 cdn 资源,凡是声明在 externals 中的第三方依赖包,都不会被打包

  1. 步骤 1

  ```js
  module.exports = {
    chainWebpack: config => {
      config.when(process.env.NODE_ENV === "production", config => {
        config
          .entry("app")
          .clear()
          .add("./src/main-prod.js");
        // 在vue.config.js如下配置
        config.set("externals", {
          vue: "Vue",
          "vue-router": "VueRouter",
          axios: "axios",
          lodash: "_",
          echarts: "echarts",
          nporgress: "NProgress",
          "vue-quill-editor": "VueQuillEditor"
        });
      });
      config.when(process.env.NODE_ENV === "development", config => {
        config
          .entry("app")
          .clear()
          .add("./src/main-dev.js");
      });
    }
  };
  ```

  2. 步骤 2

  > 在 public/index.html 文件头部,将 main-prod 中的已经进行配置的 import(<code>样式表</code>)删除替换为 cdn 引入
  >
  > <link href="https://cdn.bootcss.com/viewerjs/1.3.7/viewer.min.css" rel="stylesheet">
  >
  > ​ <link href="https://cdn.bootcss.com/quill/2.0.0-dev.3/quill.bubble.min.css" rel="stylesheet">
  >
  > ​ <link href="https://cdn.bootcss.com/quill/2.0.0-dev.3/quill.core.min.css" rel="stylesheet">
  >
  > ​ <link href="https://cdn.bootcss.com/quill/2.0.0-dev.3/quill.snow.min.css" rel="stylesheet">
  >
  > ​ <link href="https://cdn.bootcss.com/nprogress/0.2.0/nprogress.min.css" rel="stylesheet">
  >
  > ​ <link href="https://cdn.bootcss.com/element-ui/2.12.0/theme-chalk/index.css" rel="stylesheet">

  3. 步骤 3

  > 在 public/index.html 文件头部,将 main-prod 中的已经进行配置的 import(<code>js 文件</code>)删除替换为 cdn 引入
  >
  > <script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
  > <script src="https://cdn.bootcss.com/vue-router/3.1.3/vue-router.min.js"></script>
  > <script src="https://cdn.bootcss.com/axios/0.19.0/axios.min.js"></script>
  > <script src="https://cdn.bootcss.com/lodash.js/4.17.15/lodash.min.js"></script>
  > <script src="https://cdn.bootcss.com/echarts/4.4.0-rc.1/echarts.min.js"></script>
  > <script src="https://cdn.bootcss.com/nprogress/0.2.0/nprogress.min.js"></script>
  > <script src="https://cdn.bootcss.com/quill/2.0.0-dev.3/quill.min.js"></script>
  > <script src="https://cdn.jsdelivr.net/npm/vue-quill-editor@3.0.4/dist/vue-quill-editor.js"></script>
  > <script src="https://cdn.bootcss.com/viewerjs/1.3.7/viewer.min.js"></script>
  > <script src="https://cdn.bootcss.com/moment.js/2.24.0/moment.min.js"></script>

  4. cdn 加速前后对比( **chunk-vendors**打包文件)

  > Parsed 大小 2.6m=> **596.9kB**

  - 使用 cdn 优化 elementui 打包

    > 具体操作流程
    >
    > 1. 在 main-prod.js 中,注释掉 element-ui 按需加载的代码
    > 2. 在 index.html 头部区域中,通过 cdn 加载 element-ui 的 js 和 css 样式
    >
    > <link href="https://cdn.bootcss.com/element-ui/2.12.0/theme-chalk/index.css" rel="stylesheet">
    >
    > <script src="https://cdn.bootcss.com/element-ui/2.12.0/index.js"></script>

- 首页内容定制

  > 不同打包环境下,首页内容可能会有所不同,通过插件方式定制

  - vue.config.js 配置

  ```js
  config.plugin("html").tap(args => {
    args[0].isProd = true或false;
    return args;
  });
  ```

  - index.html 修改

  ```html
  <!-- 开发模式:使用import,发布模式:使用cdn -->
  <title><%= htmlWebpackPlugin.options.isProd ? '' : 'dev-' %>vue-mall</title>
  <% if(htmlWebpackPlugin.options.isProd) { %> css | js放在这儿 <% } %>
  ```

- Element-UI 组件按需加载

- 路由懒加载

  > 在打包构建项目时,javascript 包会变得特别大,影响页面加载,如果我们能把不同路由对应的组件分隔成不同的代码块,然后当路由被访问的时候才加载对应组件,这样更加高效

  - 安装@babel/plugin-syntax-dynamic-import 包
  - 在 babel.config.js 配置文件声明该插件
  - 将路由改为按需加载形式

  ```js
  // 示例:
  const Foo = () => import(/* webpackChunkName: "group-foo" */ './Foo.vue')
  const Bar = () => import(/* webpackChunkName: "group-foo" */ './Bar.vue')
  const Baz = () => import(/* webpackChunkName: "group-foo" */ './Baz.vue')

  // import Login from '../components/Login.vue'
  const Login = () => import(/* webpackChunkName: "login_home_welcome" */ '../components/Login.vue')
  // import Home from '../components/Home.vue'
  const Home = () => import(/* webpackChunkName: "login_home_welcome" */ '../components/Home.vue')
  // import Welcome from '../components/Welcome.vue'
  const Welcome = () => import(/* webpackChunkName: "login_home_welcome" */ '../components/Welcome.vue')
  ...
  ```

#### 配置 https 服务

##### 为什么要启用 https 服务

- 传统的 http 协议传输的数据都是明文,不安全
- 采用 https 协议对传输的数据进行了加密处理,可以防止数据被中间人窃取,使用更安全

申请 ssl 证书(https://freessl.org) => 正常企业还是使用收费 ssh(http 协议默认运行在 80 端口,https 默认运行在 443 端口)

```

![](./src/assets//mall_desc06.png)



---

[接口API](./api接口文档.md)

[vue.config.js配置](https://cli.vuejs.org/zh/config/#lintonsave)

[路由懒加载](https://router.vuejs.org/zh/guide/advanced/lazy-loading.html)

[babel配置](https://babeljs.io/docs/en/babel-plugin-syntax-dynamic-import/)
```
