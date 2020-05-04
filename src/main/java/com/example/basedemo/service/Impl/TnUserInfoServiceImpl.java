package com.example.basedemo.service.impl;

import com.example.basedemo.entity.po.TnUserInfoPo;
import com.example.basedemo.dao.TnUserInfoDao;
import com.example.basedemo.entity.vo.UserVo;
import com.example.basedemo.service.TnUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author klchen
 * @since 2020-05-04
 */
@Service
public class TnUserInfoServiceImpl extends ServiceImpl<TnUserInfoDao, TnUserInfoPo> implements TnUserInfoService {

    @Autowired
    private TnUserInfoDao tnUserInfoDao;

    @Override
    public UserVo getUser(String userCode) {
        return tnUserInfoDao.getUser(userCode);
    }

    @Override
    public Page<UserVo> getUserByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return tnUserInfoDao.getUserByPage();
    }
}
