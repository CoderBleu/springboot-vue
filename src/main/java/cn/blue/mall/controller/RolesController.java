package cn.blue.mall.controller;

import cn.blue.mall.bean.Powers;
import cn.blue.mall.bean.Roles;
import cn.blue.mall.bean.UserInfo;
import cn.blue.mall.service.PowersService;
import cn.blue.mall.service.RolesService;
import cn.blue.mall.service.UserInfoService;
import cn.blue.mall.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Blue
 * @date 2020/3/10
 **/
@Controller
@RequestMapping("/roles")
public class RolesController {
    @Resource
    private RolesService rolesService;
    @Resource
    private PowersService powersService;

    @GetMapping("/list")
    @ResponseBody
    public Result findAll() {
        try {
            List<Roles> list = rolesService.findAll(null);
            return Result.success().setCode(200).setMsg("查询成功").add("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500).setMsg(e.getMessage());
        }
    }

    /**
     * 查找角色列表展开后的权限
     */
    @PutMapping("/expandTree")
    @ResponseBody
    public Result findExpandTree(Roles roles) {
        try {
//            修改一级权限的pid
            List<Roles> list = null;
//            if (powersService.setPidByRolesId(roles.getId())) {
            list = rolesService.findExpandTree();
//            }
            return Result.success().setCode(200).setMsg("查询成功").add("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500).setMsg(e.getMessage());
        }
    }

    /**
     * @return 查找列表展开后的权限
     */
    @GetMapping("/findAll")
    @ResponseBody
    public Result findAllPowers() {
        try {
            List<Roles> list = rolesService.findAllPowers(null);
            return Result.success().setCode(200).setMsg("查询成功").add("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500).setMsg(e.getMessage());
        }
    }

    @GetMapping(path = {"/{rolesId}"})
    @ResponseBody
    public Result findTreeByRolesId(@PathVariable("rolesId") Integer rolesId) {
        try {
            List<Roles> tree = rolesService.findTreeByRolesId(rolesId);
            tree.forEach(item -> item.getPowers().forEach(power -> {
//                如果是三级权限就设置true，前端只需要它被勾选。
                        if (powersService.findThirdGrade(power.getId()) != null) {
                            power.setHaveChildren(true);
                        }
                    }
            ));
            return Result.success().setCode(200).setMsg("查询成功").add("data", tree);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500).setMsg(e.getMessage());
        }
    }

    @PostMapping(path = {"/updateTree/{rolesId}"})
    @ResponseBody
    public Result updateTreeByIds(Integer[] ids, @PathVariable(name = "rolesId") Integer rolesId) {
        // 有个小问题：直接在mybatis中用foreach标签新增数据，提示sql命令不正确，以前同样如此，为什么就可以了。
        try {
            if (rolesService.updateTreeByIds(ids, rolesId)) {
                return Result.success().setCode(200).setMsg("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500).setMsg(e.getMessage());
        }
        return Result.error(500).setMsg("更新失败");
    }

    @ResponseBody
    @PostMapping("/add")
    public Result addRole(Roles roles) {
        try {
            if(rolesService.addNewRole(roles)) {
                return Result.success().setCode(200).setMsg("新增成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error(500).setMsg("新增失败");
    }
}
