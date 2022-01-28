package org.lili.forfun.spring.training.db.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.lili.forfun.spring.training.db.domain.Person;

import java.util.List;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {

    @Override
    List<Person> selectByPage(int offset, int pageSize);

    @Override
    @Update({"update person set gmt_create=#{gmtCreate},gmt_modified=#{gmtModified},name=#{name},age=#{age},sex=#{sex},status=#{status},level=#{level} where id = #{id, jdbcType=BIGINT}"})
    int update(Person person);

    @Override
    @Insert({"insert into person(gmt_create,gmt_modified,name,age, sex,status,level) values(#{gmtCreate},#{gmtModified},#{name},#{age},#{sex},#{status},#{level})"})
    int insert(Person person);

    @Override
    @Delete("delete from person where id = #{id,jdbcType=BIGINT}")
    int delete(long id);

    /**
     * xml file can not work,why? 为什么XML不能工作呢？？？老是报错呢
     * @param id
     * @return
     */
    @Select("select id,gmt_create,gmt_modified,name,age, sex, status, level from person where id = #{id,jdbcType=BIGINT}")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "age", property = "age", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sex", property = "sex", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "level", property = "level", jdbcType = JdbcType.INTEGER)
    })
    Person findById(long id);

    /**
     * @param name
     * @return
     */
    @Select("select id,gmt_create,gmt_modified,name,age, sex, status, level from person where name = #{name,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "age", property = "age", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sex", property = "sex", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "level", property = "level", jdbcType = JdbcType.INTEGER)
    })
    List<Person> selectPersonByName(@Param("name") String name);


    @Update({"update person set name=#{name} where id = #{id, jdbcType=BIGINT}"})
    void updatePersonNameById(@Param("name") String name, @Param("id") Long id);

    @Override
    @Select("select count(*) from person")
    int count();


    @Select("select id,gmt_create,gmt_modified,name,age, sex, status, level from person where id = #{id,jdbcType=BIGINT} for update")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "age", property = "age", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sex", property = "sex", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "level", property = "level", jdbcType = JdbcType.INTEGER)
    })
    Person selectByIdAddLock(Long id);


    @Select("SELECT id,name,age, max(gmt_create) FROM person")
    public void showErrorStackTrace();

}
