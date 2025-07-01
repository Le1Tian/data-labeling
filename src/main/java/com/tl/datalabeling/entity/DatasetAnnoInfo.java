package com.tl.datalabeling.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * ClassName: DatasetAnnoInfo
 * Package: com.tl.datalabeling.entity
 * Description: 数据集标注信息实体类
 *
 * @Author Taylin
 * @Create 2025/7/1 14:38
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dataset_anno_info")
public class DatasetAnnoInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 数据集ID
     */
    @TableField("dataset_id")
    private Long datasetId;

    /**
     * 图片文件路径
     */
    @TableField("image_path")
    private String imagePath;

    /**
     * 图片文件名
     */
    @TableField("image_name")
    private String imageName;

    /**
     * 标注数据（JSON格式）
     */
    @TableField("annotation_data")
    private String annotationData;

    /**
     * 标注状态（0-未标注，1-已标注，2-已复核）
     */
    @TableField("annotation_status")
    private Integer annotationStatus;

    /**
     * 标注人ID
     */
    @TableField("annotator_id")
    private Long annotatorId;

    /**
     * 复核人ID
     */
    @TableField("reviewer_id")
    private Long reviewerId;

    /**
     * 标注任务ID
     */
    @TableField("anno_task_id")
    private Long annoTaskId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除标志（0-未删除，1-已删除）
     */
    @TableLogic
    @TableField("deleted")
    private Integer deleted;
}
