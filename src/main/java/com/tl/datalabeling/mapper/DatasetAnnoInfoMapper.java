package com.tl.datalabeling.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tl.datalabeling.entity.DatasetAnnoInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: DatasetAnnoInfoMapper
 * Package: com.tl.datalabeling.mapper
 * Description: 数据集标注信息mapper接口
 *
 * @Author Taylin
 * @Create 2025/7/1 14:27
 */
@Mapper
public interface DatasetAnnoInfoMapper extends BaseMapper<DatasetAnnoInfo> {

    /**
     * 分页查询标注信息
     */
    IPage<DatasetAnnoInfo> selectAnnoInfoPage(Page<DatasetAnnoInfo> page, @Param("datasetId") Long datasetId,
                                              @Param("annotationStatus") Integer annotationStatus,
                                              @Param("annotatorId") Long annotatorId,
                                              @Param("annoTaskId") Long annoTaskId);
}