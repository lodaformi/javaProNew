package com.loda.controller;

import com.loda.entity.po.User;
import com.loda.entity.vo.ResultInfo;
import com.loda.exceptions.ParamsException;
import com.loda.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author loda
 * @Date 2022/11/19 16:54
 * @Description user控制层
 * @Version 1.0
 */
@Api(tags = "用户操作Controller")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据用户名查询用户")
    @ApiImplicitParam(name = "userName", value="查询参数：用户名", required = true, dataType = "String", paramType = "path")
    @GetMapping("user/name/{userName}")
    @ResponseBody
    public User queryUserByUserName(@PathVariable String userName){
        System.out.println("queryUserMethod-->userName: " + userName);
        return userService.queryUserByUserName(userName);
    }

    @ApiOperation(value = "根据用户名id查询用户")
    @ApiImplicitParam(name = "id", value="查询参数：用户id", required = true, paramType = "path")
    @GetMapping("user/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable Integer id) throws ParamsException {
        return userService.queryUserById(id);
    }

    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(name = "user", value="用户信息", required = true)
    @PostMapping("user")
    @ResponseBody
    public ResultInfo<User> addUser(@RequestBody User user) {
        ResultInfo<User> resultInfo = new ResultInfo<>();

        try {
            userService.addUser(user);
        }catch (ParamsException e) {
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
            e.printStackTrace();
        }catch (Exception e) {
            resultInfo.setCode(300);
            resultInfo.setMsg("用户添加失败!");
            e.printStackTrace();
        }
        return resultInfo;
    }

    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true)
    @PutMapping("user")
    @ResponseBody
    public ResultInfo<User> updateUser(@RequestBody User user) {
        ResultInfo<User> resultInfo = new ResultInfo<>();

        try {
            userService.updateUser(user);
        }catch (ParamsException e) {
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
            e.printStackTrace();
        }catch (Exception e) {
            resultInfo.setCode(300);
            resultInfo.setMsg("用户更新失败!");
            e.printStackTrace();
        }
        return resultInfo;
    }

    @ApiOperation(value = "根据用户id删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer", paramType = "path")
    @DeleteMapping("user/{id}")
    @ResponseBody
    public ResultInfo<User> deleteUser(@PathVariable Integer id) {
        ResultInfo<User> resultInfo = new ResultInfo<>();

        try {
            userService.deleteUser(id);
        }catch (ParamsException e) {
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
            e.printStackTrace();
        }catch (Exception e) {
            resultInfo.setCode(300);
            resultInfo.setMsg("用户删除失败!");
            e.printStackTrace();
        }
        return resultInfo;
    }

    @ApiOperation(value = "添加用户02")
//    @ApiImplicitParam(name = "user", value="用户信息", required = true)
    @PostMapping("user02")
//    @ResponseBody
    public ResultInfo<User> addUser02(@RequestBody User user) throws ParamsException {
        ResultInfo<User> resultInfo = new ResultInfo<>();
        userService.addUser(user);
        return resultInfo;
    }

    @ApiOperation(value = "添加用户03")
//    @ApiImplicitParam(name = "user", value="用户信息", required = true)
    @PostMapping("user03")
//    @ResponseBody
    public ResultInfo<User> addUser03(@Valid User user) throws ParamsException {
        ResultInfo<User> resultInfo = new ResultInfo<>();
        userService.addUser(user);
        return resultInfo;
    }



}
