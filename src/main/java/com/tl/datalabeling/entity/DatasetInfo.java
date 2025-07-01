package com.tl.datalabeling.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName: DatasetInfo
 * Package: com.tl.datalabeling.entity
 * Description:数据信息实体类
 *
 * @Author Taylin
 * @Create 2025/7/1 14:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dataset_info")
public class DatasetInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 数据集名称
     */
    @TableField("dataset_name")
    private String datasetName;

    /**
     * 数据集描述
     */
    @TableField("dataset_desc")
    private String datasetDesc;

    /**
     * 数据集类型（分类/检测/分割）
     */
    @TableField("dataset_type")
    private String datasetType;

    /**
     * 数据集状态（0-未开始，1-标注中，2-已完成）
     */
    @TableField("status")
    private Integer status;

    /**
     * 项目空间ID
     */
    @TableField("project_space_id")
    private Long projectSpaceId;

    /**
     * 创建人ID
     */
    @TableField("create_user_id")
    private Long createUserId;

    /**
     * 创建时间
     *
     * 前端：发送包含 datasetName、datasetDesc、datasetType、projectSpaceId 的数据
     * 后端 Controller：接收数据，调用 Service
     * Service：创建 DatasetInfo 对象，设置基本字段
     * MyBatis-Plus：在执行 save() 方法时：
     * 检查 createTime 字段是否有 @TableField(fill = FieldFill.INSERT) 注解
     * 发现该字段为空，调用 MyMetaObjectHandler.insertFill()
     * 自动填充 createTime 和 updateTime 为当前时间
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