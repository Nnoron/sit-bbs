package com.local.i_sit_bbs.controller;

import com.local.i_sit_bbs.common.Result;
import com.local.i_sit_bbs.pojo.Advertisement;
import com.local.i_sit_bbs.services.AdvertisementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@Api(value = "AdvertisementController")
@RestController
public class AdvertisementController {

    @Autowired
    AdvertisementService advertisementService;

    @ApiOperation(value = "新增广告")
    @PostMapping("/addAdv")
    public Result addAdv(Advertisement advertisement){
        return Result.result(advertisementService.addAdv(advertisement)>0);
    }

    @ApiOperation(value = "删除广告")
    @GetMapping("/deleteAdv")
    public Result deleteAdv(Advertisement advertisement){
        return Result.result(advertisementService.deleteAdv(advertisement)>0);
    }

    @ApiOperation(value = "修改广告")
    @PostMapping("/editAdv")
    public Result editAdv(Advertisement advertisement){
        return Result.result(advertisementService.editAdv(advertisement)>0);
    }

    @ApiOperation(value = "查询广告")
    @GetMapping("/getAdvs")
    public Result getAdvs(Advertisement advertisement){
        try{
            return Result.success(advertisementService.getAdvs(advertisement));
        }catch(Exception e){
            e.printStackTrace();
            return Result.failed("获取广告信息失败");
        }
    }

}
