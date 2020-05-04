package com.example.basedemo.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author klchen
 * @since 2020-05-04
 */
@Data
@ApiModel(value="User多表联查结果集映射对象", description="")
public class UserVo implements Serializable {


    private String userCode;

    private String userName;

    private String unitCode;

    private String unitName;

    private String ChineseName;

    private Date createTime;


}
