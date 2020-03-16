package cn.blue.mall.controller;

import cn.blue.mall.bean.GoodsInfo;
import cn.blue.mall.bean.UserInfo;
import cn.blue.mall.service.GoodsService;
import cn.blue.mall.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Blue
 * @date 2020/3/15
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping
    @ResponseBody
    public Result findAll(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize,
            GoodsInfo goodsInfo) {
        PageHelper.startPage(pageNum, pageSize);
        // 这里默认将 catLevel=0传过来
        List<GoodsInfo> list = goodsService.findAll(goodsInfo);
        PageInfo<GoodsInfo> pageInfo = new PageInfo<>(list);
        Result r = Result.success();
        r.add("total", pageInfo.getTotal());
        r.add("data", list);
        r.setMsg("查询成功");
        return r;
    }

    /**
     * 只保留一级、二级分类
     * @param goodsInfo 传catLevel=0
     * @return 一级二级分类列表
     */
    @GetMapping("/filterCat")
    @ResponseBody
    public Result findAll(GoodsInfo goodsInfo) {
        try {
            // 这里默认将 catLevel=0传过来
            List<GoodsInfo> list = goodsService.findAll(goodsInfo);
            // 复制集合,将只保留一级、二级分类
            ArrayList<GoodsInfo> arrayList = new ArrayList<>(list);
            arrayList.forEach(item -> {
                item.getChildren().forEach(goods -> {
                    goods.setChildren(null);
                });
            });
            return Result.success().setCode(200).setMsg("查询成功").add("goods",arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500).setMsg(e.getMessage());
        }
    }

    @ResponseBody
    @PutMapping("/update")
    public Result updateById(GoodsInfo goodsInfo) {
        try {
            goodsService.updateById(goodsInfo);
            return Result.success().setCode(200).setMsg("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500).setMsg(e.getMessage());
        }
    }


    @ResponseBody
    @PostMapping("/addCat")
    public Result addCat(GoodsInfo goodsInfo) {
        try {
            goodsService.addCatByPId(goodsInfo);
            return Result.success().setCode(200).setMsg("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500).setMsg(e.getMessage());
        }
    }

}
