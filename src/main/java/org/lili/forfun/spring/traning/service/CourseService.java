package org.lili.forfun.spring.traning.service;


import lombok.extern.log4j.Log4j2;
import org.lili.forfun.spring.traning.db.domain.Course;
import org.lili.forfun.spring.traning.db.mapper.BaseMapper;
import org.lili.forfun.spring.traning.db.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CourseService extends AbstractService<Course> {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public BaseMapper<Course> getMapper() {
        return courseMapper;
    }

    public List<Course> selectCourseByPersonId(Long personId) {
        if (personId != null) {
            courseMapper.selectCourseByPersonId(personId);
        }
        return null;
    }
}
