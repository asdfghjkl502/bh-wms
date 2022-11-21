package io.ukoko.bhwms.shiro;

import io.ukoko.bhwms.entity.User;
import io.ukoko.bhwms.enums.ShiroStatus;
import io.ukoko.bhwms.exceptions.BhWmsException;
import io.ukoko.bhwms.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Shiro Realm
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户手机号
        String userTel = authenticationToken.getPrincipal().toString();
        //判断手机号是否存在
        if(userTel==null || userTel.length()==0){
            throw new BhWmsException(ShiroStatus.LOGIN_NOT_USER);
        }
        User user = userMapper.getUserByUserTel(userTel);
        if(user==null){
            throw new BhWmsException(ShiroStatus.LOGIN_ERROR_USER);
        }
        //盐值转换
        ByteSource bytes = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUserTel(),user.getPassword(),bytes,getName());
        return simpleAuthenticationInfo;
    }
}
