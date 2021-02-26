package com.david.learn.learnboot.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: wudening
 * @Description: 用户VO
 * @Date: 2021/2/25 5:54 下午
 */
@Data
@ApiModel("用户VO")
public class UserVO {
    @ApiModelProperty(value = "id", required = true, example = "1")
    private Integer id;
    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;
}
