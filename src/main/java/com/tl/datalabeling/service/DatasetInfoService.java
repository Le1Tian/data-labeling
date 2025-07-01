package com.tl.datalabeling.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tl.datalabeling.entity.DatasetInfo;
import com.tl.datalabeling.param.DatasetInfoAddParam;
import com.tl.datalabeling.param.DatasetInfoPageParam;

/**
 * ClassName: DatasetInfoService
 * Description: 数据集信息服务接口
 *
 * @Author Taylin
 * @Create 2025/7/1 14:56
 */
public interface DatasetInfoService extends IService<DatasetInfo> {

    /**
     * 添加数据集
     */
    boolean addDataset(DatasetInfoAddParam param);

    /**
     * 分页查询数据集
     */
    IPage<DatasetInfo> getDatasetPage(DatasetInfoPageParam param);

    /**
     * 删除数据集
     */
    boolean deleteDataset(Long id);

    /**
     * 更新数据集状态
     */
    boolean updateDatasetStatus(Long id, Integer status);
}
