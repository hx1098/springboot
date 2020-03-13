登录页面

http://localhost:8080/toLogin

登陆时会去判断是否这个用户名和密码
整合mybatis和shiro进行鉴权

用户名：eric
密码：123456


filterMap.put("/testThymeleaf", "anon");
filterMap.put("/login", "anon");
//所哟的都需要权限进行访问
filterMap.put("/*", "authc");
