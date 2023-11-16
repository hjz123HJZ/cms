package com.briup.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.briup.bean.Slideshow;
import com.briup.dao.SlideshowDao;
import com.briup.exception.ServiceException;
import com.briup.util.Result;
import com.briup.util.ResultCode;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import com.briup.service.ISlideshowService;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 轮播图 前端控制器
 * </p>
 *
 * @author briup
 * @since 2023-11-15
 */
@Api(tags = "轮播图")
@RestController
@RequiredArgsConstructor
@RequestMapping("/slideshow")
public class SlideshowController {
    private final ISlideshowService slideshowService;
    private final SlideshowDao slideshowDao;


    @ApiOperation("根据id删除")
    @DeleteMapping("/deleteById")
    public Result deleteById(Integer id) {
    slideshowService.removeById(id);
        return Result.success();
    }



    @ApiOperation("基本查询")
    @GetMapping("/findAll")
    public Result findAll() {
        return Result.success(slideshowService.list());
    }



    //直接调用了mp封装好了的实现类的方法，不再通过service层写各种判断逻辑
    @ApiOperation("启用轮播图")
    @GetMapping("/queryAllEnable")
    public Result queryAllEnable(){
        LambdaQueryChainWrapper<Slideshow> lqw = slideshowService.lambdaQuery();
        lqw.eq(Slideshow::getStatus,"启用").orderByDesc(Slideshow::getUploadTime);
        List<Slideshow> list = lqw.list();
        if(list == null || list.isEmpty())
            throw new ServiceException(ResultCode.DATA_NONE);
        return Result.success(list);
    }
    @ApiOperation("分页条件查询")
    @GetMapping("/query")
    public Result query(@RequestParam Integer pageNum, @RequestParam Integer pageSize, String status,String desc) {
        IPage<Slideshow> p = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<Slideshow> lqw = new LambdaQueryWrapper<>();
        lqw.eq(StringUtils.hasText(status),Slideshow::getStatus,status)
                .like(Slideshow::getDescription,desc)
                .orderByDesc(Slideshow::getUploadTime);
        IPage<Slideshow> slideshowIPage = slideshowDao.selectPage(p, lqw);
        return Result.success(slideshowIPage);
    }
    @ApiOperation("根据id查询")
    @GetMapping("/queryById/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(slideshowService.getById(id));
    }
    @ApiOperation("添加或修改")
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody @Valid Slideshow slideshow) {
            slideshowService.saveOrUpdate(slideshow);
        return Result.success();
    }
    @ApiOperation("批量删除")
    @PostMapping("/deleteByBatch/{ids}")
    public Result deleteBatch(@PathVariable List<Integer> ids) {
        slideshowService.removeByIds(ids);
        return Result.success();
    }

}

