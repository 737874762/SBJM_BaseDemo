package com.example.basedemo.service;

import com.example.basedemo.entity.po.TnUserInfoPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.basedemo.entity.vo.UserVo;
import com.github.pagehelper.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author klchen
 * @since 2020-05-04
 */
public interface TnUserInfoService extends IService<TnUserInfoPo> {

    UserVo getUser(String userCode);

    Page<UserVo> getUserByPage(Integer pageNum, Integer pageSize);
}
