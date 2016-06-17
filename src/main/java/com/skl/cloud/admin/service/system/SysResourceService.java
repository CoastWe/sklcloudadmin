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
}
