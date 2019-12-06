package org.lili.forfun.spring.traning.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lili.forfun.spring.traning.db.domain.BaseEntity;

import java.util.List;

@Mapper
public interface BaseMapper<T extends BaseEntity> {

    List<T> selectByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 总数
     *
     * @return
     */
    int count();

    /**
     * 更新对象
     *
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 新增对象
     *
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 通过主键id删除对象
     *
     * @param id
     * @return
     */
    int delete(@Param("id") long id);

    /**
     * 通过主键id查找对象
     *
     * @param id
     * @return
     */
    T findById(@Param("id") long id);
}
