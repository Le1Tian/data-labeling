package com.tl.datalabeling.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tl.datalabeling.entity.DatasetAnnoInfo;
import com.tl.datalabeling.param.DataInfoAnnoPageQueryParam;

/**
 * Description:  数据集标注信息服务接口
 *
 * @Author Taylin
 * @Create 2025/7/1 15:09
 */
public interface DatasetAnnoInfoService extends IService<DatasetAnnoInfo> {

    /**
     * 分页查询标注信息
     */
    IPage<DatasetAnnoInfo> getAnnoInfoPage(DataInfoAnnoPageQueryParam param);

    /**
     * 保存标注结果
     */
    boolean saveAnnoResult(DatasetAnnoInfo annoInfo);

    /**
     * 更新标注状态
     */
    boolean updateAnnoStatus(Long id, Integer status);
}
