package com.tl.datalabeling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tl.datalabeling.entity.DatasetAnnoInfo;
import com.tl.datalabeling.mapper.DatasetAnnoInfoMapper;
import com.tl.datalabeling.param.DataInfoAnnoPageQueryParam;
import com.tl.datalabeling.service.DatasetAnnoInfoService;
import org.springframework.stereotype.Service;


/**
 * ClassName: DatasetAnnoInfoServiceImpl
 * Package: com.tl.datalabeling.service.impl
 * Description: 数据集标注信息服务实现类
 *
 * @Author Taylin
 * @Create 2025/7/1 15:10
 */
@Service
public class DatasetAnnoInfoServiceImpl extends ServiceImpl<DatasetAnnoInfoMapper, DatasetAnnoInfo> implements DatasetAnnoInfoService {

    @Override
    public IPage<DatasetAnnoInfo> getAnnoInfoPage(DataInfoAnnoPageQueryParam param) {
        Page<DatasetAnnoInfo> page = new Page<>(param.getCurrent(), param.getSize());

        LambdaQueryWrapper<DatasetAnnoInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(param.getDatasetId() != null, DatasetAnnoInfo::getDatasetId, param.getDatasetId())
                .eq(param.getAnnotationStatus() != null, DatasetAnnoInfo::getAnnotationStatus, param.getAnnotationStatus())
                .eq(param.getAnnotatorId() != null, DatasetAnnoInfo::getAnnotatorId, param.getAnnotatorId())
                .eq(param.getAnnoTaskId() != null, DatasetAnnoInfo::getAnnoTaskId, param.getAnnoTaskId())
                .orderByDesc(DatasetAnnoInfo::getCreateTime);

        return page(page, queryWrapper);
    }

    @Override
    public boolean saveAnnoResult(DatasetAnnoInfo annoInfo) {
        // 如果ID存在，则更新；否则新增
        if (annoInfo.getId() != null) {
            return updateById(annoInfo);
        } else {
            return save(annoInfo);
        }
    }

    @Override
    public boolean updateAnnoStatus(Long id, Integer status) {
        DatasetAnnoInfo annoInfo = new DatasetAnnoInfo();
        annoInfo.setId(id);
        annoInfo.setAnnotationStatus(status);
        return updateById(annoInfo);
    }
}
