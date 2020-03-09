package cn.blue.mall.controller;

import cn.blue.mall.bean.UserInfo;
import cn.blue.mall.service.UserInfoService;
import cn.blue.mall.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Blue
 * @date 2020/3/5
 **/
@Controller
@RequestMapping("/users")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @PutMapping("/changeStatus")
    @ResponseBody
    public Result changeStatus(UserInfo userInfo) {
        try {
            if(userInfoService.updateStatusById(userInfo)) {
                return Result.success().setCode(200).setMsg("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error(500).setMsg("修改失败");
    }

    @PostMapping("/add")
    @ResponseBody
    public Result addUser(UserInfo userInfo) {
        if (userInfo != null) {
            try {
                if (userInfo.getId() != null && !userInfo.getId().equals("")){
                    userInfoService.updateUserById(userInfo);
                    return Result.success().setCode(200).setMsg("修改成功");
                }else {
                    userInfoService.addUser(userInfo);
                    return Result.success().setCode(200).setMsg("添加成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Result.error(500).setMsg("添加失败");
    }

    @ResponseBody
    @DeleteMapping("/delete")
    public Result deleteById(@RequestParam("userId") String id) {
        try {
            userInfoService.deleteById(id);
            return Result.success().setCode(200).setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500).setMsg(e.getMessage());
        }
    }

    @GetMapping
    @ResponseBody
    public Result findAll(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "3") Integer pageSize,
            UserInfo user) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> list = null;
        if (user == null) {
            list = userInfoService.findAll(null);
        } else {
            list = userInfoService.findAll(user);
        }
        PageInfo<UserInfo> pageInfo = new PageInfo<>(list);
        Result r = Result.success();
        r.add("total", pageInfo.getTotal());
        r.add("data", list);
        r.setMsg("查询成功");
        return r;
    }
}
