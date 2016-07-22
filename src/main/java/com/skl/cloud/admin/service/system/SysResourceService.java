package com.skl.cloud.admin.service.system;

import java.util.List;
import java.util.Set;

import com.skl.cloud.admin.dto.ComplexButton;
import com.skl.cloud.admin.model.system.SysResource;
import com.skl.cloud.admin.service.common.BaseService;

public interface SysResourceService extends BaseService<SysResource>{

    /**
     * 得到资源对应的权限字符串
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<Long> resourceIds);

    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<ComplexButton> findMenus(Set<String> permissions);
    
    /**
     * 判断权限名是否存在
     * TODO(这里用一句话描述这个方法的作用)
     * <p>Creation Date: 2016年6月21日 and by Author: weibin </p>
     * @param roleName
     * @return
     * @return Boolean 存在返回true，不存在返回false
     * @throws
     *
     */
	public Boolean isExistsResourceName(String resourceName);
}
