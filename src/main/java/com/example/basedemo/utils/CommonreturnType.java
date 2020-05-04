package com.example.basedemo.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 〈通用请求返回处理〉
 *
 * @author Chkl
 * @create 2019/3/9
 * @since 1.0.0
 */
@Data
@ApiModel(value = "通用返回类型")
public class CommonreturnType<T> {
    //表明请求的返回处理结果“success”或“fail”
    @ApiModelProperty(value = "状态码")
    private String status;

    //若status为success，返回前端需要的json数据
    //若status为fail，返回data内使用通用的错误格式码
    @ApiModelProperty(value = "返回数据")
    private T data;

    //定义一个通用的创建方法
    public static CommonreturnType create(Object result){
        return CommonreturnType.create(result,"success");
    }
    public static CommonreturnType create(Object result, String status){
        CommonreturnType type = new CommonreturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }
}
