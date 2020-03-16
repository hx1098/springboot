package com.itheima.controller;


import com.itheima.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


	
	@RequestMapping("/hello")
	@ResponseBody 
	public String hello() {
		System.err.println("userController");
		return "ok";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "/user/add";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "/user/update";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "/login";
	}

	@RequestMapping("/noAuth")
	public String noAuth(){
		return "/noAuth";
	}

	
	@RequestMapping("/testThymeleaf")
	public String testThymeleaf(Model model){
		//把数据存入model
		model.addAttribute("name", "黑马程序员");
		//返回test.html
		return "test";
	}
	
	
	/**
	 * 登录的逻辑处理
	 */
    @RequestMapping("/login")
    public String login(String name,String password,Model modle) {
    	System.err.println("name= " + name);
    	//使用shiro编写认证操作
    	//1 获取subject
    	Subject subject = SecurityUtils.getSubject();
    	
    	//2。封装用户数据
    	UsernamePasswordToken token = new UsernamePasswordToken(name,password);
    	
    	//3.执行登录方法
    	try {
			subject.login(token);
			//登录成功
			return "redirect:/testThymeleaf";//重定向
		} catch (UnknownAccountException e) {
			//登录失败:用户名不存在
			modle.addAttribute("msg","用户名不存在");
			return "login";
		}catch (IncorrectCredentialsException e) {
			//登录失败:密码错误
			modle.addAttribute("msg","密码错误");
			return "login";
		}
    	
    	
    }
}
