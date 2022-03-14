package com.hb.sky.base.controller;

import com.hb.sky.common.container.DropdownRegister;
import com.hb.sky.common.model.vo.DropdownVO;
import com.hb.sky.common.standard.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 通用功能controller
 *
 * @author Mr.huang
 * @date 2022/3/13
 */
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    /**
     * 获取下拉框
     *
     * @param type 类型
     * @return 结果
     */
    @RequestMapping("/dropdown/{type}")
    public Result<List<DropdownVO>> getDropdownByType(@PathVariable("type") String type) {
        return Result.success(DropdownRegister.get(type));
    }

}
