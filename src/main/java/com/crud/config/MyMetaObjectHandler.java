package com.crud.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * Created by xuruzi on 2019/12/29.
 * mybatis plus 自动填充
 * @author
 */
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateUserId", String.class, "2");
        this.strictUpdateFill(metaObject, "updateUserName", String.class, "2");
    }
}
