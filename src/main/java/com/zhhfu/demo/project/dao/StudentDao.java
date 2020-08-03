package com.zhhfu.demo.project.dao;

import com.zhhfu.demo.project.entity.StudentEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/1 11:43
 * @email ：fuzhihang5@jd.com
 * @description ：Student的Dao
 */
@Repository
public interface StudentDao {

    @Select("select * from stu")
    List<StudentEntity> findAll();

    @Select("select * from stu where id = #{id}")
    StudentEntity findStudentById(int id);

    @Select("select * from stu where name = #{name}")
    StudentEntity findStudentByName(String name);

    @Select("select count(id) from stu")
    int countStudentNum();

    @Insert("insert into stu (name, age, score, addr) values(#{name}, #{age}, #{score}, #{addr})")
    int addStudent(StudentEntity student);
}
