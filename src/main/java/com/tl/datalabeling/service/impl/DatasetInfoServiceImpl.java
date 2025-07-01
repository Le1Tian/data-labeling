package com.tl.datalabeling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tl.datalabeling.entity.DatasetInfo;
import com.tl.datalabeling.mapper.DatasetInfoMapper;
import com.tl.datalabeling.param.DatasetInfoAddParam;
import com.tl.datalabeling.param.DatasetInfoPageParam;
import com.tl.datalabeling.service.DatasetInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * ClassName: DatasetInfoServiceImpl
 * Description: 数据集信息服务实现类
 *
 * @Author Taylin
 * @Create 2025/7/1 14:57
 */
@Service
public class DatasetInfoServiceImpl extends ServiceImpl<DatasetInfoMapper, DatasetInfo> implements DatasetInfoService {

    @Override
    public boolean addDataset(DatasetInfoAddParam param) {
        DatasetInfo datasetInfo = new DatasetInfo();
        datasetInfo.setDatasetName(param.getDatasetName());
        datasetInfo.setDatasetDesc(param.getDatasetDesc());
        datasetInfo.setDatasetType(param.getDatasetType());
        datasetInfo.setProjectSpaceId(param.getProjectSpaceId());
        datasetInfo.setStatus(0); // 初始状态：未开始
        datasetInfo.setCreateUserId(1L); // 临时设置，实际应该从当前用户获取

        return save(datasetInfo);
    }

    @Override
    public IPage<DatasetInfo> getDatasetPage(DatasetInfoPageParam param) {
        Page<DatasetInfo> page = new Page<>(param.getCurrent(), param.getSize());

        LambdaQueryWrapper<DatasetInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(param.getDatasetName()), DatasetInfo::getDatasetName, param.getDatasetName())
                .eq(param.getDatasetType() != null, DatasetInfo::getDatasetType, param.getDatasetType())
                .eq(param.getStatus() != null, DatasetInfo::getStatus, param.getStatus())
                .eq(param.getProjectSpaceId() != null, DatasetInfo::getProjectSpaceId, param.getProjectSpaceId())
                .orderByDesc(DatasetInfo::getCreateTime);

        return page(page, queryWrapper);
    }

    @Override
    public boolean deleteDataset(Long id) {
        return removeById(id);
    }

    @Override
    public boolean updateDatasetStatus(Long id, Integer status) {
        DatasetInfo datasetInfo = new DatasetInfo();
        datasetInfo.setId(id);
        datasetInfo.setStatus(status);
        return updateById(datasetInfo);
    }
}
