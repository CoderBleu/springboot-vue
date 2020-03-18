package cn.blue.mall.controller;

import cn.blue.mall.bean.Powers;
import cn.blue.mall.bean.Powers;
import cn.blue.mall.service.PowersService;
import cn.blue.mall.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * @author Blue
 * @date 2020/3/10
 **/
@Controller
@RequestMapping("/powers")
public class PowersController {
    @Resource
    private PowersService powersService;

    @GetMapping("/list")
    @ResponseBody
    public Result findAll(
    ) {
        try {
            List<Powers> list = powersService.findAll(null);
            return Result.success().setCode(200).setMsg("查询成功").add("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500).setMsg(e.getMessage());
        }
    }

    @GetMapping("/tree")
    @ResponseBody
    public Result findPowersTree(
    ) {
        try {
            List<Powers> list = powersService.findPowersTree();
            return Result.success().setCode(200).setMsg("查询成功").add("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500).setMsg(e.getMessage());
        }
    }

}
