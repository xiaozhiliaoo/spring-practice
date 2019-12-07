package org.lili.forfun.spring.traning.db.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lili.forfun.spring.traning.db.domain.Course;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> selectCourseByPersonId(@Param("personId") Long personId);

}
