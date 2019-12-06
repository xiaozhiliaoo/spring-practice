package org.lili.forfun.spring.traning.service;


import lombok.extern.slf4j.Slf4j;
import org.lili.forfun.spring.traning.db.domain.BaseEntity;
import org.lili.forfun.spring.traning.db.mapper.BaseMapper;

import java.util.Date;
import java.util.List;

@Slf4j
public abstract class AbstractService<T extends BaseEntity> {
    /**
     * 获取BaseMapper
     *
     * @return
     */
    protected abstract BaseMapper<T> getMapper();

    /**
     *
     * @param offset
     * @param pageSize
     * @return
     */
    public List<T> selectByPage(int offset, int pageSize) {
        return getMapper().selectByPage(offset, pageSize);
    }

    /**
     * 计算表中记录总数
     *
     * @return
     */
    public int count() {
        return getMapper().count();
    }

    /**
     * 按对象id查询指定记录
     *
     * @param id
     * @return
     */
    public T get(long id) {
        return getMapper().findById(id);
    }

    /**
     * 删除指定ID的记录
     *
     * @param id
     * @return
     */
    public boolean delete(long id) {
        log.info("delete: class = {}, id = {}", this.getClass(), id);
        getMapper().delete(id);
        return true;
    }

    /**
     * 插入记录，会设置表的创建时间和修改时间为当前时间
     *
     * @param t
     * @return
     */
    public int insert(T t) {
        t.setGmtCreate(new Date());
        t.setGmtModified(t.getGmtCreate());
        log.info("insert: {}", t);
        return getMapper().insert(t);
    }

    /**
     * 更新某一对象<br/> 注意，对象的所有字段必须完整，最好是从数据库查出来后更新其中字段再调此方法更新。
     *
     * @param t
     * @return
     */
    public boolean update(T t) {
        t.setGmtModified(new Date());
        log.info("update: {}", t);
        return getMapper().update(t) > 0;
    }
}
