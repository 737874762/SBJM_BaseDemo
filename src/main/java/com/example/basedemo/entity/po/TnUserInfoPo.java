package com.example.basedemo.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author klchen
 * @since 2020-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tn_user_info")
@ApiModel(value="TnUserInfoPo对象", description="")
public class TnUserInfoPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("USER_CODE")
    private String userCode;

    @TableField("USER_NAME")
    private String userName;

    @TableField("UNIT_CODE")
    private String unitCode;

    @TableField("ChineseName")
    private String ChineseName;

    @TableField("PASSWORD")
    private String password;

    @TableField("CREATE_TIME")
    private Date createTime;


}
