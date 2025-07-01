package com.tl.datalabeling.param;


import lombok.Data;


/**
 * ClassName: DataInfoAnnoPageQueryParam
 * Package: com.tl.datalabeling.param
 * Description: 标注数据分页查询参数
 *
 * @Author Taylin
 * @Create 2025/7/1 14:54
 */
@Data
public class DataInfoAnnoPageQueryParam {

    /**
     * 当前页码
     */
    private Integer current = 1;

    /**
     * 每页大小
     */
    private Integer size = 10;

    /**
     * 数据集ID
     */
    private Long datasetId;

    /**
     * 标注状态
     */
    private Integer annotationStatus;

    /**
     * 标注人ID
     */
    private Long annotatorId;

    /**
     * 标注任务ID
     */
    private Long annoTaskId;
}
