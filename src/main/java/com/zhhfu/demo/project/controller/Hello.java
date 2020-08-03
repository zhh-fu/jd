package com.zhhfu.demo.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fuzhihang5
 * @email  fuzhihang5@jd.com
 * @date   2020.6.24 15:53
 */

/**
 *
 */
@Controller
@RequestMapping("/path")
public class Hello {
    private static Logger logger = LoggerFactory.getLogger(Hello.class);
    /**
     * @param  
     * @return java.lang.String
     * @author fuzhihang5
     * @date   2020/6/28 19:51
     */
    
    @RequestMapping("/demo")
    @ResponseBody
    public String demo(){
        StringBuffer sb = new StringBuffer();
        sb.append("this is a simple demo!");
        sb.append("<br>");
        sb.append("the second day in jd.");
        return sb.toString();
    }

    /**
     * @param
     * @return java.lang.String
     * @author fuzhihang5
     * @date   2020/6/28 19:52
     */

    @RequestMapping("/demo1")
    public String demo1(){
        return "index2";
    }

    @RequestMapping()
    public String add(){
        return "addStudent";
    }


}
