package com.zhhfu.demo.project.service.Impl;

import com.zhhfu.demo.project.dao.StudentDao;
import com.zhhfu.demo.project.entity.StudentEntity;
import com.zhhfu.demo.project.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/1 11:51
 * @email ：fuzhihang5@jd.com
 * @description : Student 的 service层接口实现
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentDao studentDao;

    @Override
    public StudentEntity findStudentByName(String name) {
        return studentDao.findStudentByName(name);
    }

    @Override
    public List<StudentEntity> findAll() {
        return studentDao.findAll();
    }

    @Override
    public StudentEntity findStudentById(int id) {
        return studentDao.findStudentById(id);
    }

    @Override
    public int countStudentNum() {
        return studentDao.countStudentNum();
    }

    @Override
    public int addStudent(StudentEntity student){
        return studentDao.addStudent(student);
    }
}
