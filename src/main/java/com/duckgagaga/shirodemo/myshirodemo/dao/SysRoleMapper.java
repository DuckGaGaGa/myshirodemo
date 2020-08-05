package com.duckgagaga.shirodemo.myshirodemo.dao;

import com.duckgagaga.shirodemo.myshirodemo.entity.SysRole;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysRoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysRoleMapper {
    long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    /**
     * 通过用户id查询用户所拥有的所有权限
     * @param userId
     * @return
     */
    List<SysRole> selectUserRolesById(Integer userId);
}