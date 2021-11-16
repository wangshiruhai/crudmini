package com.crud.rest;

import com.crud.biz.IUserService;
import com.crud.entity.User;
import com.crud.utils.ApiResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tommy
 *         免登录controller
 */
@ApiModel("用户模块")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired IUserService userService;

    @ApiOperation("查看用户列表")
    @GetMapping("/find")
    public ApiResult<List<User>> findUser() {
        return ApiResult.success(userService.findUserList());
    }

    @ApiOperation("新增用户")
    @PostMapping("/save")
    public ApiResult<Void> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ApiResult.success();
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public ApiResult<String> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ApiResult.success();
    }

    @ApiOperation("删除用户")
    @PostMapping("/delete")
    public ApiResult<String> deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getId());
        return ApiResult.success();
    }

}
