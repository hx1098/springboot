package com.itheima.shiro;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义relam类
 * @author hanxi
 *
 */
public class UserRelam  extends AuthorizingRealm{


	@Autowired
	private UserService userService;
	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.err.println("执行授权逻辑");

		//给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

//        info.addStringPermission("user:add");  //	 与这里的一致才行  filterMap.put("/add","perms[user:add]");


		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		User byId = userService.findById(user.getId());

		//获取数据库中的权限
		info.addStringPermission(byId.getPerms());

		return info;
	}

	
	/**
	 * 执行认证的逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.err.println( "执行认证的逻辑 ");
		/*//假设数据库的用户名和密码
		String name = "eric";
		String password = "123456";*/

		//编写shiro判断逻辑，判断用户名和密码
		//1，判单用户名
		UsernamePasswordToken tokens = (UsernamePasswordToken) token;

		User user = userService.findByName(tokens.getUsername());
        if (user == null){
        	return null;//shriro底层会抛出UnKnownAccountException
		}



		return new SimpleAuthenticationInfo(user,user.getPassword(),"");
	}




}
