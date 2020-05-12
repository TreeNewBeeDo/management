package com.example.demo.service.impl;

import com.example.demo.mapper.AuthorityMapper;
import com.example.demo.mapper.UserAuthorityMapper;
import com.example.demo.model.Authority;
import com.example.demo.model.AuthorityExample;
import com.example.demo.model.UserAuthority;
import com.example.demo.model.UserAuthorityExample;
import com.example.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author duhongchi
 * <p>
 * Date 2020/4/27
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;
    @Autowired
    private UserAuthorityMapper userAuthorityMapper;

    @Override
    public Authority getAuthorityById(Integer authorityId){
//        AuthorityExample example = new AuthorityExample();
//        AuthorityExample.Criteria criteria = example.createCriteria();
//        criteria.andAuthorityIdEqualTo(authorityId);
        return authorityMapper.selectByPrimaryKey(authorityId);
    }

    @Override
    public Authority getAuthorityByName(String name) {
        AuthorityExample example = new AuthorityExample();
        AuthorityExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        authorityMapper.selectByExample(example);
        List<Authority> authorityList = authorityMapper.selectByExample(example);
        if (authorityList.size()!=0){
            return authorityList.get(0);
        }
        else {
            return null;
        }

    }

    @Override
    public void addAdmin(String userId) {
        UserAuthority userAuthority = new UserAuthority();
        userAuthority.setAuthorityId(1);
        userAuthority.setUserId(userId);
        userAuthorityMapper.insertSelective(userAuthority);
    }

    @Override
    public void removeAdmin(String userId) {
        UserAuthorityExample example = new UserAuthorityExample();
        UserAuthorityExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andAuthorityIdEqualTo(1);
        userAuthorityMapper.deleteByExample(example);
    }
}
