package com.example.basedemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.basedemo.entity.PageInfo;
import com.example.basedemo.entity.po.TnUserInfoPo;
import com.example.basedemo.entity.vo.UserVo;
import com.example.basedemo.error.BusinessException;
import com.example.basedemo.error.EmBusinssError;
import com.example.basedemo.service.TnUserInfoService;
import com.example.basedemo.utils.CommonreturnType;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 〈基础操作控制接口〉
 *
 * @author Chkl
 * @create 2020/4/25
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api")
public class BaseDataController extends BaseController {

    @Autowired
    private TnUserInfoService tnUserInfoService;

    @ApiOperation(value = "insert", notes = "")
    @PostMapping("/user")
    public CommonreturnType insertUser(@RequestBody TnUserInfoPo tnUserInfoPo) throws BusinessException {
        Integer count = tnUserInfoService.lambdaQuery().
                eq(TnUserInfoPo::getUserCode, tnUserInfoPo.getUserCode()).
                count();
        if (count > 0) {//主键冲突
            throw new BusinessException(EmBusinssError.PRIMARY_KEY_EXIST);
        }
        boolean save = tnUserInfoService.save(tnUserInfoPo);
        return CommonreturnType.create(save);
    }

    @ApiOperation(value = "update", notes = "")
    @PutMapping("/user")
    public CommonreturnType updateUser(@RequestBody TnUserInfoPo tnUserInfoPo) {
        // 通过传入实体进行修改，默认策略会排除空字段
//        boolean update = tnUserInfoService.updateById(tnUserInfoPo);
        // 通过条件修改指定的字段 lambda表达式
        boolean update = tnUserInfoService.lambdaUpdate().
                eq(TnUserInfoPo::getUserCode, tnUserInfoPo.getUserCode()).
                set(TnUserInfoPo::getUserName, tnUserInfoPo.getUserName()).update();
        return CommonreturnType.create(update);
    }

    @ApiOperation(value = "delete", notes = "")
    @DeleteMapping("/user")
    public CommonreturnType deleteUser(@RequestParam(value = "userCode") String userCode) {
        boolean remove = tnUserInfoService.lambdaUpdate().
                eq(TnUserInfoPo::getUserCode, userCode).
                remove();
        return CommonreturnType.create(remove);
    }

    @ApiOperation(value = "get", notes = "")
    @GetMapping("/user/{userCode}")
    public CommonreturnType getUser(@PathVariable String userCode) {
        TnUserInfoPo tnUserInfoPo = tnUserInfoService.
                getOne(Wrappers.<TnUserInfoPo>lambdaQuery().
                        eq(TnUserInfoPo::getUserCode, userCode));
        return CommonreturnType.create(tnUserInfoPo);
    }

    @ApiOperation(value = "getPage", notes = "")
    @GetMapping(value = "/user/pageNum/{pageNum}/pageSize/{pageSize}")
    public CommonreturnType getUserByPage(@PathVariable Integer pageNum,
                                          @PathVariable Integer pageSize) {
        IPage<TnUserInfoPo> page = new Page<>(pageNum, pageSize);
        IPage<TnUserInfoPo> pageInfo = tnUserInfoService.lambdaQuery().
                select(TnUserInfoPo.class,info->!info.getColumn().equals("PASSWORD")).//排除密码被查询
                page(page);
        return CommonreturnType.create(pageInfo);
    }
    @ApiOperation(value = "get2", notes = "多表关联查询")
    @GetMapping("/user2/{userCode}")
    public CommonreturnType getUser2(@PathVariable String userCode) {
        UserVo user = tnUserInfoService.getUser(userCode);
        return CommonreturnType.create(user);
    }
    @ApiOperation(value = "getPage2", notes = "多表关联分页查询")
    @GetMapping(value = "/user2/pageNum/{pageNum}/pageSize/{pageSize}")
    public CommonreturnType getUserByPage2(@PathVariable Integer pageNum,
                                          @PathVariable Integer pageSize) {

        com.github.pagehelper.Page<UserVo> userVos = tnUserInfoService.getUserByPage(pageNum, pageSize);
        PageInfo<UserVo> pageInfo = new PageInfo<>(userVos);
        return CommonreturnType.create(pageInfo);
    }

}
