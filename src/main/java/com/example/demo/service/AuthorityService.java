package com.example.demo.service;


import com.example.demo.model.Authority;

/**
 * author duhongchi
 * <p> 角色控制
 * Date 2020/4/27
 */
public interface AuthorityService {
    /**
     * 根据id获取 Authority
     * @param authorityId
     * @return
     */
    Authority getAuthorityById(Integer authorityId);

    /**
     * 根据权限名称获取权限
     * @param name
     * @return
     */
    Authority getAuthorityByName(String name);

    /**
     * 增加管理员权限
     * @param userId
     */
    void addAdmin(String userId);

    /**
     * 移除管理员权限
     * @param userId
     */
    void removeAdmin(String userId);
}
