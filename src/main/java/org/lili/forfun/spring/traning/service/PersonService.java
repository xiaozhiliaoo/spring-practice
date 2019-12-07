package org.lili.forfun.spring.traning.service;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.lili.forfun.spring.traning.db.domain.Course;
import org.lili.forfun.spring.traning.db.domain.Person;
import org.lili.forfun.spring.traning.db.mapper.BaseMapper;
import org.lili.forfun.spring.traning.db.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class PersonService extends AbstractService<Person> {

    @Autowired
    private PersonMapper mapper;

    @Autowired
    private CourseService courseService;

    @Override
    public BaseMapper<Person> getMapper() {
        return mapper;
    }

    /**
     * 该事务要做的事情是，查找学生，并且修改学生名字和学生所对应的课程
     *
     * @param name
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public List<Person> selectPersonByName(String name) {
        List<Person> people = mapper.selectPersonByName(name);
        Person person = people.get(0);
        person.setName("hi~~~~");
        updatePerson(person);
        return people;
    }

    public int updatePerson(Person person) {
        person.setAge("99999999");
        person.setGmtModified(new Date());
        return mapper.update(person);
    }

    public void updateCource(Person person) {
        long id = person.getId();
        List<Course> courses = courseService.selectCourseByPersonId(id);
        Course course = courses.get(0);
        Course newCourse = new Course();
        newCourse.setName(course.getName());
        newCourse.setOpen(course.getOpen());
        newCourse.setTeacher(course.getTeacher());
        courseService.insert(newCourse);
    }
}
