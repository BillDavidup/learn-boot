package com.david.learn.learnboot.Controller;

import com.david.learn.learnboot.utils.result.ResultDTO;
import com.david.learn.learnboot.vo.UserVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wudening
 * @Description: <!-- knife4j 接入STEP ④：Knife4j API文档代码侵入式使用Demo-->
 * @Date: 2021/2/25 5:52 下午
 */
@Api(tags = "Knife4jDemoController")
@ApiSort(1) // Knife4j API文档 Controller排序
@Component
@RestController
@RequestMapping("/api/knife4j")
public class Knife4jDemoController {
    @ApiOperationSupport(order = 1) // Knife4j API文档接口级别排序
    @ApiOperation(value = "获取用户信息接口", nickname = "根据用户ID获取用户相关信息") // Knife4j API文档接口信息
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int") // Knife4j API文档参数定义
    @GetMapping("/user")
    public ResultDTO<UserVO> getUser(@RequestParam Integer id) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setName("管理员");
        return ResultDTO.success(userVO);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "获取用户信息接口2", nickname = "根据用户ID获取用户相关信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int")
    @GetMapping("/user2")
    public ResultDTO<UserVO> getUser2(@RequestParam Integer id) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setName("管理员2");
        System.out.println(userVO);
        return ResultDTO.success(userVO);
    }
}
