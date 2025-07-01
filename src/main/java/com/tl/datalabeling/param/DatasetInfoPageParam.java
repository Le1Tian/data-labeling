package com.tl.datalabeling.param;

import lombok.Data;

/**
 * ClassName: DatasetInfoPageParam
 * Package: com.tl.datalabeling.param
 * Description: 标注数据分页查询参数
 *
 * @Author Taylin
 * @Create 2025/7/1 14:12
 */
@Data
public class DatasetInfoPageParam {

    /**
     * 当前页码
     */
    private Integer current = 1;

    /**
     * 每页大小
     */
    private Integer size = 10;

    /**
     * 数据集名称（模糊查询）
     */
    private String datasetName;

    /**
     * 数据集类型
     */
    private String datasetType;

    /**
     * 数据集状态
     */
    private Integer status;

    /**
     * 项目空间ID
     */
    private Long projectSpaceId;
}