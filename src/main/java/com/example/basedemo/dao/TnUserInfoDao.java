package com.example.basedemo.dao;

import com.example.basedemo.entity.po.TnUserInfoPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.basedemo.entity.vo.UserVo;
import com.github.pagehelper.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author klchen
 * @since 2020-05-04
 */
public interface TnUserInfoDao extends BaseMapper<TnUserInfoPo> {

    UserVo getUser(String userCode);

    Page<UserVo> getUserByPage();
}
