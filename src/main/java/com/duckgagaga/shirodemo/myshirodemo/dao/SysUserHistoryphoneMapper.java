package com.duckgagaga.shirodemo.myshirodemo.dao;

import com.duckgagaga.shirodemo.myshirodemo.entity.SysUserHistoryphone;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysUserHistoryphoneExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysUserHistoryphoneMapper {
    long countByExample(SysUserHistoryphoneExample example);

    int deleteByExample(SysUserHistoryphoneExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserHistoryphone record);

    int insertSelective(SysUserHistoryphone record);

    List<SysUserHistoryphone> selectByExample(SysUserHistoryphoneExample example);

    SysUserHistoryphone selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserHistoryphone record, @Param("example") SysUserHistoryphoneExample example);

    int updateByExample(@Param("record") SysUserHistoryphone record, @Param("example") SysUserHistoryphoneExample example);

    int updateByPrimaryKeySelective(SysUserHistoryphone record);

    int updateByPrimaryKey(SysUserHistoryphone record);
}