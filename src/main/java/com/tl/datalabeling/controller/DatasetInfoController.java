package com.tl.datalabeling.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tl.datalabeling.common.Result;
import com.tl.datalabeling.entity.DatasetInfo;
import com.tl.datalabeling.param.DatasetInfoAddParam;
import com.tl.datalabeling.param.DatasetInfoPageParam;
import com.tl.datalabeling.service.DatasetInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 数据集信息控制器
 *
 * @Author Taylin
 * @Create 2025/7/1 14:59
 */
@Slf4j
@RestController
@RequestMapping("/datasetInfo")
public class DatasetInfoController {

    @Autowired
    private DatasetInfoService datasetInfoService;

    /**
     * 添加数据集
     */
    @PostMapping("/add")
    public Result<Boolean> addDataset(@Validated @RequestBody DatasetInfoAddParam param) {
        try {
            boolean result = datasetInfoService.addDataset(param);
            return result ? Result.success(true) : Result.error("添加数据集失败");
        } catch (Exception e) {
            log.error("添加数据集异常", e);
            return Result.error("添加数据集异常：" + e.getMessage());
        }
    }

    /**
     * 分页查询数据集
     */
    @PostMapping("/page")
    public Result<IPage<DatasetInfo>> getDatasetPage(@RequestBody DatasetInfoPageParam param) {
        try {
            IPage<DatasetInfo> page = datasetInfoService.getDatasetPage(param);
            return Result.success(page);
        } catch (Exception e) {
            log.error("查询数据集异常", e);
            return Result.error("查询数据集异常：" + e.getMessage());
        }
    }

    /**
     * 删除数据集
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteDataset(@PathVariable Long id) {
        try {
            boolean result = datasetInfoService.deleteDataset(id);
            return result ? Result.success(true) : Result.error("删除数据集失败");
        } catch (Exception e) {
            log.error("删除数据集异常", e);
            return Result.error("删除数据集异常：" + e.getMessage());
        }
    }

    /**
     * 更新数据集状态
     */
    @PutMapping("/{id}/status")
    public Result<Boolean> updateDatasetStatus(@PathVariable Long id, @RequestParam Integer status) {
        try {
            boolean result = datasetInfoService.updateDatasetStatus(id, status);
            return result ? Result.success(true) : Result.error("更新数据集状态失败");
        } catch (Exception e) {
            log.error("更新数据集状态异常", e);
            return Result.error("更新数据集状态异常：" + e.getMessage());
        }
    }

    /**
     * 根据ID获取数据集详情
     */
    @GetMapping("/{id}")
    public Result<DatasetInfo> getDatasetById(@PathVariable Long id) {
        try {
            DatasetInfo datasetInfo = datasetInfoService.getById(id);
            return datasetInfo != null ? Result.success(datasetInfo) : Result.error("数据集不存在");
        } catch (Exception e) {
            log.error("获取数据集详情异常", e);
            return Result.error("获取数据集详情异常：" + e.getMessage());
        }
    }
}