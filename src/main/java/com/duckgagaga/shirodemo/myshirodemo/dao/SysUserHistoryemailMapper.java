package com.duckgagaga.shirodemo.myshirodemo.dao;

import com.duckgagaga.shirodemo.myshirodemo.entity.SysUserHistoryemail;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysUserHistoryemailExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysUserHistoryemailMapper {
    long countByExample(SysUserHistoryemailExample example);

    int deleteByExample(SysUserHistoryemailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserHistoryemail record);

    int insertSelective(SysUserHistoryemail record);

    List<SysUserHistoryemail> selectByExample(SysUserHistoryemailExample example);

    SysUserHistoryemail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserHistoryemail record, @Param("example") SysUserHistoryemailExample example);

    int updateByExample(@Param("record") SysUserHistoryemail record, @Param("example") SysUserHistoryemailExample example);

    int updateByPrimaryKeySelective(SysUserHistoryemail record);

    int updateByPrimaryKey(SysUserHistoryemail record);
}