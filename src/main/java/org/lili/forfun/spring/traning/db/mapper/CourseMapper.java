package org.lili.forfun.spring.traning.db.mapper;


import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.lili.forfun.spring.traning.db.domain.Course;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    @Override
    List<Course> selectByPage(int offset, int pageSize);


    @Override
    @Select({"select count(*) from course"})
    int count();

    @Override
    @Update({"update course set gmt_modified=#{gmtModified},name=#{name},person_id=#{personId}, open=#{open}, teacher=#{teacher}"})
    int update(Course course);

    @Override
    @Insert({" insert into course(gmt_create,gmt_modified,  name, person_id,open,  teacher)values(#{gmtCreate},#{gmtModified},#{name},#{personId},#{open},#{teacher})"})
    int insert(Course course);

    @Override
    @Delete({"delete from course where id = #{id,jdbcType=BIGINT}"})
    int delete(long id);

    @Override
    Course findById(long id);

    @Select({"select id, gmt_create, gmt_modified,name,person_id, open,teacher from course where person_id=#{personId, jdbcType=BIGINT}"})
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT),
            @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "person_id", property = "personId", jdbcType = JdbcType.BIGINT),
            @Result(column = "open", property = "open", jdbcType = JdbcType.INTEGER),
            @Result(column = "teacher", property = "teacher", jdbcType = JdbcType.VARCHAR)
    })
    List<Course> selectCourseByPersonId(@Param("personId") Long personId);

}
