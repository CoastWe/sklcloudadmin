package com.skl.cloud.admin.foundation.shiro.realm;

import java.util.Set;

import javax.servlet.ServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.subject.WebSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.skl.cloud.admin.model.system.SysUser;
import com.skl.cloud.admin.service.system.SysUserService;
/**
 * 系统用户的认证与授权
 * @author weibin
 *
 */
public class UserRealm extends AuthorizingRealm{
	
	private static Logger log = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private SysUserService userService;

	@SuppressWarnings("unchecked")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub	
		Set<String> roles = null;
		Set<String> permissions = null;
		String username = (String)principals.getPrimaryPrincipal();
		ServletRequest request = ((WebSubject)SecurityUtils.getSubject()).getServletRequest();
		log.info("获取的request{}",request);
		roles = (Set<String>) request.getAttribute("AuthorizationRoles");
		permissions = (Set<String>) request.getAttribute("AuthorizationPermissions");
		if(roles == null){
			roles = userService.findRoles(username);
			request.setAttribute("AuthorizationRoles", roles);
		}
		if(permissions == null){
			permissions = userService.findPermissions(username);
			request.setAttribute("AuthorizationPermissions", permissions);
		}
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
        String username = (String)token.getPrincipal();

        SysUser user = userService.findByUsername(username);

        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }        
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
	}

}
