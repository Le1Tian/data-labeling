package com.tl.datalabeling.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tl.datalabeling.common.Result;
import com.tl.datalabeling.entity.DatasetAnnoInfo;
import com.tl.datalabeling.param.DataInfoAnnoPageQueryParam;
import com.tl.datalabeling.service.DatasetAnnoInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * Description: 数据集标注信息控制器
 *
 * @Author Taylin
 * @Create 2025/7/1 15:03
 */
@Slf4j
@RestController
@RequestMapping("/datasetAnnoInfo")
public class DatasetAnnoInfoController {

    @Autowired
    private DatasetAnnoInfoService datasetAnnoInfoService;

    /**
     * 分页查询标注信息
     */
    @PostMapping("/page")
    public Result<IPage<DatasetAnnoInfo>> getAnnoInfoPage(@RequestBody DataInfoAnnoPageQueryParam param) {
        try {
            IPage<DatasetAnnoInfo> page = datasetAnnoInfoService.getAnnoInfoPage(param);
            return Result.success(page);
        } catch (Exception e) {
            log.error("查询标注信息异常", e);
            return Result.error("查询标注信息异常：" + e.getMessage());
        }
    }

    /**
     * 保存标注结果
     */
    @PostMapping("/save")
    public Result<Boolean> saveAnnoResult(@RequestBody DatasetAnnoInfo annoInfo) {
        try {
            boolean result = datasetAnnoInfoService.saveAnnoResult(annoInfo);
            return result ? Result.success(true) : Result.error("保存标注结果失败");
        } catch (Exception e) {
            log.error("保存标注结果异常", e);
            return Result.error("保存标注结果异常：" + e.getMessage());
        }
    }

    /**
     * 根据ID获取标注信息
     */
    @GetMapping("/{id}")
    public Result<DatasetAnnoInfo> getAnnoInfoById(@PathVariable Long id) {
        try {
            DatasetAnnoInfo annoInfo = datasetAnnoInfoService.getById(id);
            return annoInfo != null ? Result.success(annoInfo) : Result.error("标注信息不存在");
        } catch (Exception e) {
            log.error("获取标注信息异常", e);
            return Result.error("获取标注信息异常：" + e.getMessage());
        }
    }

    /**
     * 删除标注信息
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteAnnoInfo(@PathVariable Long id) {
        try {
            boolean result = datasetAnnoInfoService.removeById(id);
            return result ? Result.success(true) : Result.error("删除标注信息失败");
        } catch (Exception e) {
            log.error("删除标注信息异常", e);
            return Result.error("删除标注信息异常：" + e.getMessage());
        }
    }

    /**
     * 更新标注状态
     */
    @PutMapping("/{id}/status")
    public Result<Boolean> updateAnnoStatus(@PathVariable Long id, @RequestParam Integer status) {
        try {
            boolean result = datasetAnnoInfoService.updateAnnoStatus(id, status);
            return result ? Result.success(true) : Result.error("更新标注状态失败");
        } catch (Exception e) {
            log.error("更新标注状态异常", e);
            return Result.error("更新标注状态异常：" + e.getMessage());
        }
    }

    /**
     * 根据数据集ID获取该数据集下所有图片标注信息
     */
    @PostMapping("/listByDatasetId")
    public Result<List<DatasetAnnoInfo>> listByDatasetId(@RequestBody Map<String, Long> param) {
        try {
            Long datasetId = param.get("datasetId");
            List<DatasetAnnoInfo> list = datasetAnnoInfoService.list(
                new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<DatasetAnnoInfo>()
                    .eq("dataset_id", datasetId)
                    .eq("deleted", 0)
            );
            return Result.success(list);
        } catch (Exception e) {
            log.error("查询图片列表异常", e);
            return Result.error("查询图片列表异常：" + e.getMessage());
        }
    }
}
