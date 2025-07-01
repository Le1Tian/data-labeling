package com.tl.datalabeling.param;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/**
 * ClassName: DatasetInfoAddParam
 * Package: com.tl.datalabeling.param
 * Description:
 *
 * @Author Taylin
 * @Create 2025/7/1 14:46
 */
@Data
public class DatasetInfoAddParam {

    /**
     * 数据集名称
     */
    @NotBlank(message = "数据集名称不能为空")
    private String datasetName;

    /**
     * 数据集描述
     */
    private String datasetDesc;

    /**
     * 数据集类型
     */
    @NotBlank(message = "数据集类型不能为空")
    private String datasetType;

    /**
     * 项目空间ID
     */
    @NotNull(message = "项目空间ID不能为空")
    private Long projectSpaceId;
}
