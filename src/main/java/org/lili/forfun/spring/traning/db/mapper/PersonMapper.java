package org.lili.forfun.spring.traning.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lili.forfun.spring.traning.db.domain.Person;

import java.util.List;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    /**
     * @param name
     * @return
     */
    List<Person> selectPersonByName(@Param("name") String name);


    void updatePersonNameById(@Param("name") String name, @Param("id") Long id);

    @Override
    @Select("select count(*) from person")
    int count();

}
