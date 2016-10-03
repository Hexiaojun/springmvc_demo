package com.conteoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import po.Student;
import service.StudentQueryService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by chenglei on 2016/10/3.
 */

@Controller
@RequestMapping("/stu")
public class StudentController {

    private StudentQueryService studentQueryService;

    /**
     * 注入service层
     *
     * @param service
     */
    @Autowired
    public void setStudentQueryService(StudentQueryService service) {
        this.studentQueryService = service;
    }

    /**
     * 根据id查看student的name
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getStuById(@RequestParam("id") Integer id, Model model) {
        Student student = studentQueryService.getStuNameById(id);
        model.addAttribute(student);
        return "stu_view";
    }

    /**
     * 功能同上，但是使用了Restful风格的url
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/view2/{id}", method = RequestMethod.GET)
    public String getStuById2(@PathVariable("id") Integer id, Map<String, Object> model) {
        Student student = studentQueryService.getStuNameById(id);
        model.put("student", student);
        return "stu_view";
    }

    /**
     * 添加student信息页面
     *
     * @return
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET, params = "add")
    public String gotoAddStuJSP() {
        return "addStu";
    }

    /**
     * 添加student信息
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStu(
            Student student
    ) {
        studentQueryService.addStu(student);
        return "redirect:view2/" + student.getId();
    }

    /**
     * 上传文件界面
     *
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String showUploadPage() {
        return "img_upload";
    }

    /**
     * 上传一张图片
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {

            System.out.println(file.getOriginalFilename());
            System.out.println(file.getName());

            InputStream stream = null;
            FileOutputStream outputStream = null;
            try {
                stream = file.getInputStream();
                outputStream = new FileOutputStream("C:/Users/chenglei/Desktop/s.png");
                int len = -1;
                byte[] bytes = new byte[1024];
                while ((len = (stream.read(bytes))) != -1) {
                    outputStream.write(bytes, 0, len);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                stream.close();
                outputStream.flush();
                outputStream.close();
            }

        }

        return "upload_success";
    }
}
