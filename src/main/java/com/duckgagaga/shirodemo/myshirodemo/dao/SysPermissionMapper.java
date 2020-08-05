package com.duckgagaga.shirodemo.myshirodemo.dao;

import com.duckgagaga.shirodemo.myshirodemo.entity.SysPermission;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysPermissionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysPermissionMapper {
    long countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    /**
     * 通过传入父权限id值查询子孙权限
     * @param id  父权限id
     * @return
     */
    List<SysPermission> selectChildrenPermission(Integer id);

    /**
     * 通过传入子权限id值查询父权限
     * @param id  子权限id
     * @return
     */
    SysPermission selectParent(Integer id);

    SysPermission selectOneTestById(Integer id);
}