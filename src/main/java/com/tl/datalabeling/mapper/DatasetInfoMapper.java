package com.tl.datalabeling.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tl.datalabeling.entity.DatasetInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: DatasetInfoMapper
 * Package: com.tl.datalabeling.mapper
 * Description: 数据集信息Mapper接口
 *
 * @Author Taylin
 * @Create 2025/7/1 14:14
 */
@Mapper
public interface DatasetInfoMapper extends BaseMapper<DatasetInfo> {

    /**
     * 分页查询数据集信息
     */
    IPage<DatasetInfo> selectDatasetInfoPage(
            Page<DatasetInfo> page,
            @Param("datasetName") String datasetName,             // MyBatis映射文件中使用#{datasetName}引用此参数
            @Param("datasetType") String datasetType,             // MyBatis映射文件中使用#{datasetType}引用此参数
            @Param("status") Integer status,                      // MyBatis映射文件中使用#{status}引用此参数
            @Param("projectSpaceId") Long projectSpaceId          // MyBatis映射文件中使用#{projectSpaceId}引用此参数
    );
}
