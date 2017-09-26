package cn.segema.cloud.shrio.auth;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.segema.cloud.shrio.domain.Role;
import cn.segema.cloud.shrio.domain.User;
import cn.segema.cloud.shrio.repository.ResourceRepository;
import cn.segema.cloud.shrio.repository.RoleRepository;
import cn.segema.cloud.shrio.repository.UserRepository;

public class MyShiroRealm  extends AuthorizingRealm {
    @Resource
    private UserRepository userRepository;
    
    @Resource
    private RoleRepository roleRepository;
    
    @Resource
    private ResourceRepository resourceRepository;

    /**
     * 授权：
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    		System.out.println("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
    		 User token = (User)SecurityUtils.getSubject().getPrincipal();
    		 String userId = token.getUserId();
    		 SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
    		 
    		 
        String currentLoginName = (String)principals.getPrimaryPrincipal();
        List<String> userRoleCodes = new ArrayList<String>();  
        List<String> userPermissions = new ArrayList<String>();  
        //从数据库中获取当前登录用户的详细信息  
        User user = userRepository.findByUserName(currentLoginName);
        if(null != user){  
            //获取当前用户下所有ACL权限列表  待续。。。
            //获取当前用户下拥有的所有角色列表
            List<Role> roles = roleRepository.findRoleByUserId(user.getUserId());
            for (int i = 0; i < roles.size(); i++) {
            		userRoleCodes.add(roles.get(i).getRoleCode());
            }
            
            List<cn.segema.cloud.shrio.domain.Resource> resources = resourceRepository.findResourceByUserId(user.getUserId());
            for (int i = 0; i < resources.size(); i++) {
	            	userPermissions.add(resources.get(i).getResourceCode());
	        }
            
        }else{  
            throw new AuthorizationException();  
        }  
         System.out.println("#######获取角色："+userRoleCodes);
         System.out.println("#######获取权限："+userPermissions);
        //为当前用户设置角色和权限  
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(userRoleCodes);
        authorizationInfo.addStringPermissions(userPermissions); 
        return authorizationInfo;
    }

    /** 
     * 认证：
     * 验证当前登录的Subject
     * LoginController.login()方法中执行Subject.login()时 执行此方法 
     */ 
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        System.out.println("###【开始认证[SessionId]】"+SecurityUtils.getSubject().getSession().getId());
        String loginName = (String)authcToken.getPrincipal();
       // String password = (String)authcToken.getCredentials();
        User user = userRepository.findByUserName(loginName);
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt,采用明文访问时，不需要此句
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
