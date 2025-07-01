package com.tl.datalabeling.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * ClassName: LabelGroup
 * Description: 标签组实体类
 *
 * @Author Taylin
 * @Create 2025/7/1 14:45
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("label_group")
public class LabelGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标签组名称
     */
    @TableField("group_name")
    private String groupName;

    /**
     * 标签组描述
     */
    @TableField("group_desc")
    private String groupDesc;

    /**
     * 标签组类型（分类/检测/分割）
     */
    @TableField("group_type")
    private String groupType;

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