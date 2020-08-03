package com.zhhfu.demo.project.controller;

import com.zhhfu.demo.project.entity.StudentEntity;
import com.zhhfu.demo.project.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/1 11:57
 * @email ：fuzhihang5@jd.com
 * @description ：Student 的controller层
 */
@Controller
@RequestMapping("/stu")
public class StudentController {

    @Resource
    StudentService studentService;

    @RequestMapping("/allStudents")
    @ResponseBody
    public String findAllStudent(){
        StringBuffer sb = new StringBuffer();
        List<StudentEntity> list = studentService.findAll();
        int count = studentService.countStudentNum();
        sb.append("当前共有 " + count + " 名学生");
        sb.append("<br>");
        for (StudentEntity stu : list){
            String str = "当前用户是：" + stu.getName() + ",他的年龄是：" + stu.getAge()
                    + "，他的分数是：" + stu.getScore();
            sb.append(str);
            sb.append("<br>");
        }
        return sb.toString();
    }

    @RequestMapping(value = "/searchResult", method = RequestMethod.GET)
    public String findStudentById(@RequestParam("id") int id, Model model){
        StudentEntity stu = studentService.findStudentById(id);
        model.addAttribute("stu",stu);
        return "index1";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String findStudentById(@RequestParam("name") String name,
                                  @RequestParam("age") int age,
                                  @RequestParam("score") int score,
                                  Model model){
        StudentEntity stu = new StudentEntity();
        stu.setName(name);
        stu.setAge(age);
        stu.setScore(score);
        int res = studentService.addStudent(stu);
        String info = "添加成功";
        if (res == 0){
            return "redirect:";
        }
        model.addAttribute("info",info);
        StudentEntity student = studentService.findStudentByName(name);
        model.addAttribute("stu",student);
        return "index1";
    }

    @RequestMapping(value = "/jump")
    public String jump(){
        return "redirect:/stu/jumpPage";
    }

    @RequestMapping("jumpPage")
    @ResponseBody
    public String jumpPage(){
        return "this is jump Page!";
    }
}
