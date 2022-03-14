package com.hb.sky.config.controller;

import com.hb.sky.base.annotation.InOutLog;
import com.hb.sky.common.constant.CommonConsts;
import com.hb.sky.common.constant.ErrorCode;
import com.hb.sky.common.model.dto.Page;
import com.hb.sky.common.standard.Result;
import com.hb.sky.common.util.StrUtils;
import com.hb.sky.common.validator.Assert;
import com.hb.sky.common.validator.Check;
import com.hb.sky.config.dao.dobj.GlobalConfigDO;
import com.hb.sky.config.service.IGlobalConfigService;
import com.hb.sky.easyui.support.vo.Tree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 全局配置表控制层
 *
 * @version v0.1, 2022-03-13 11:37:23, create by Mr.Huang.
 */
@Slf4j
@RestController
@RequestMapping("/globalConfig")
public class GlobalConfigController {

    /**
     * 全局配置表服务层
     */
    @Resource
    private IGlobalConfigService globalConfigService;

    /**
     * 分页查询全局配置表
     *
     * @param globalConfig 查询条件对象
     * @param pageNum      当前第几页
     * @param pageSize     每页条数
     * @return 分页结果
     */
    @PostMapping("/queryPages")
    public Result<Page<GlobalConfigDO>> queryPages(@RequestBody GlobalConfigDO globalConfig,
                                                   @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        Assert.ifTrueThrows(Check.isErrorPageParameter(pageNum, pageSize), ErrorCode.PAGE_PARAM_ERROR);
        return Result.success(globalConfigService.selectPages(globalConfig, pageNum, pageSize));
    }

    /**
     * 新增全局配置表
     *
     * @param globalConfig 新增对象信息
     * @return 影响的行数
     */
    @InOutLog("新增全局配置表")
    @PostMapping("/save")
    public Result save(@RequestBody GlobalConfigDO globalConfig) {
        if (StrUtils.isAnyEmpty(globalConfig.getSystemName(), globalConfig.getGroupName(), globalConfig.getConfigKey(), globalConfig.getConfigValue(), globalConfig.getRemark())) {
            return Result.fail(ErrorCode.REQUIRED_PARAM_NULL);
        }
        return Result.success(globalConfigService.insert(globalConfig));
    }

    /**
     * 通过主键修改全局配置表
     *
     * @param globalConfig 要修改的信息
     * @return 影响的行数
     */
    @InOutLog("通过主键修改全局配置表")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody GlobalConfigDO globalConfig) {
        if (globalConfig.getId() == null) {
            return Result.fail(ErrorCode.REQUIRED_PARAM_NULL);
        }
        return Result.success(globalConfigService.updateById(globalConfig));
    }

    /**
     * 通过主键删除全局配置表
     *
     * @param id 主键
     * @return 影响的行数
     */
    @InOutLog("通过主键删除全局配置表")
    @GetMapping("/deleteById")
    public Result deleteById(@RequestParam("id") Long id) {
        if (id == null) {
            return Result.fail(ErrorCode.REQUIRED_PARAM_NULL);
        }
        GlobalConfigDO globalConfig = new GlobalConfigDO();
        globalConfig.setId(id);
        return Result.success(globalConfigService.deleteById(globalConfig));
    }

    /**
     * 获取系统配置属性结构
     * @return 结果
     */
    @GetMapping("/findSystemConfigTree")
    public Result<List<Tree>> findSystemConfigTree() {
        GlobalConfigDO query = new GlobalConfigDO();
        query.setSystemName(CommonConsts.BASE_PROJECT_NAME);
        List<GlobalConfigDO> dbDataList = globalConfigService.selectList(query);
        if (CollectionUtils.isEmpty(dbDataList)) {
            return Result.success();
        }
        int id = 0;
        List<Tree> treeList = new ArrayList<>();
        Tree firstLevelTree = new Tree();
        firstLevelTree.setId(++id);
        firstLevelTree.setText(CommonConsts.BASE_PROJECT_NAME);
        for (GlobalConfigDO globalConfig : dbDataList) {
            String groupName = globalConfig.getGroupName();
            List<Tree> secondLevelList = firstLevelTree.getChildren();
            secondLevelList.stream().filter(tree -> groupName.equals(tree.getText())).findFirst().orElse()
        }
    }

}
