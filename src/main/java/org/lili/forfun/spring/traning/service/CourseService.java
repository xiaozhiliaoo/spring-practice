package org.lili.forfun.spring.traning.service;


import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomUtils;
import org.lili.forfun.spring.traning.db.domain.Course;
import org.lili.forfun.spring.traning.db.domain.Person;
import org.lili.forfun.spring.traning.db.mapper.BaseMapper;
import org.lili.forfun.spring.traning.db.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class CourseService extends AbstractService<Course> {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private PersonService personService;

    @Override
    public BaseMapper<Course> getMapper() {
        return courseMapper;
    }


    public List<Course> selectCourseByPersonId(Long personId) {
        if (personId != null) {
            return courseMapper.selectCourseByPersonId(personId);
        }
        return null;
    }

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateCource(Person person) {
        log.info("start updateCource:{}", JSON.toJSON(person));
        long id = person.getId();
        List<Course> courses = courseMapper.selectCourseByPersonId(1L);
        Course course = courses.get(0);
        Course newCourse = new Course();
        newCourse.setName(course.getName());
        newCourse.setOpen(course.getOpen());
        newCourse.setTeacher(course.getTeacher());
        insert(newCourse);
    }


    @Transactional
    public void updatePerson(Person person) {
        //这里的事务会生效
        person.setAge(String.valueOf(RandomUtils.nextInt()));
        person.setGmtModified(new Date());
        personService.update(person);
        updateCource(person);
        throw new RuntimeException("error in CourseService");
    }
}
