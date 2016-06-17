package com.skl.cloud.admin.service.system;

import java.util.Set;

import com.skl.cloud.admin.model.system.SysRole;
import com.skl.cloud.admin.service.common.BaseService;

public interface SysRoleService extends BaseService<SysRole>{

    /**
     * 根据角色编号得到角色标识符列表
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号得到权限字符串列表
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);
}
