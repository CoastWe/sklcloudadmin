package com.skl.cloud.admin.service.system;

import java.util.Set;

import com.skl.cloud.admin.model.system.SysUser;
import com.skl.cloud.admin.service.common.BaseService;

public interface SysUserService extends BaseService<SysUser>{
    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long id, String newPassword);
    
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public SysUser findByUsername(String username);
    
    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);
    
    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);
    
    /**
     * 判断用户名是否存在
     * TODO(这里用一句话描述这个方法的作用)
     * <p>Creation Date: 2016年6月21日 and by Author: weibin </p>
     * @param name
     * @return
     * @return Boolean 存在返回true，不存在返回false
     * @throws
     *
     */
	public Boolean isExistsUserName(String name);
}
