package com.tl.datalabeling.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName: Label
 * Package: com.tl.datalabeling.entity
 * Description: 标签实体类
 *
 * @Author Taylin
 * @Create 2025/7/1 14:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("label")
public class Label implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标签名称
     */
    @TableField("label_name")
    private String labelName;

    /**
     * 标签描述
     */
    @TableField("label_desc")
    private String labelDesc;

    /**
     * 标签颜色
     */
    @TableField("label_color")
    private String labelColor;

    /**
     * 标签组ID
     */
    @TableField("label_group_id")
    private Long labelGroupId;

    /**
     * 排序号
     */
    @TableField("sort_order")
    private Integer sortOrder;

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