package com.crud.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 值班实体类
 *
 * @author makejava
 */
@Data
public class UserResp implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private String email;
    private Integer version;
    private String updateUserId;
    private String updateUserName;
}