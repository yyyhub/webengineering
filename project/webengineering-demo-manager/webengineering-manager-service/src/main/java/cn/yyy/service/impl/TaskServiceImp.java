package cn.yyy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yyy.mapper.TaskMapper;
import cn.yyy.pojo.Class;
import cn.yyy.pojo.Course;
import cn.yyy.pojo.StudentInfo;
import cn.yyy.pojo.Task;
import cn.yyy.pojo.TaskExample;
import cn.yyy.pojo.TaskExample.Criteria;
import cn.yyy.service.CourseService;
import cn.yyy.service.MessageService;
import cn.yyy.service.MessageSubject;
import cn.yyy.service.StudentService;
import cn.yyy.service.TaskService;

@Service
public class TaskServiceImp implements TaskService{
	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private StudentService studentService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private CourseService courseService;
	
	public void assginTask(String taskName,String taskContent,Integer teacherid,Integer courseid,Date deadline) {
		Task task = new Task();
		task.setCourseid(courseid);
		task.setDeadline(deadline);
		task.setTaskcontent(taskContent);
		task.setTaskid(null);
		task.setTaskname(taskName);
		task.setTeacherid(teacherid);
		taskMapper.insert(task);
		List<StudentInfo> studentInfos = studentService.getCourseStudentsInfoByCourseId(courseid);
		for (StudentInfo studentInfo:studentInfos) {
			messageService.addMessage(taskContent, teacherid, studentInfo.getUserid(),"亲爱的"+studentInfo+"同学，您有一项新的作业",MessageSubject.JOB);
		}
	}
	
	public List<Task> getAllTaskByCourseId(Integer courseid){
		TaskExample taskExample = new TaskExample();
		Criteria criteria = taskExample.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		List<Task> tasks = taskMapper.selectByExample(taskExample);
		return tasks;
	}
	
	public List<Task> getAllTaskByClassId(Integer classid){
		Course course = courseService.getCourseByClassId(classid);
		List<Task> tasks = getAllTaskByCourseId(course.getCourseid());
		return tasks;
	}
	
	public List<Task> getAllTaskByStudentId(Integer studentid){
		List<Class> classes = studentService.getAllClassByStudentid(studentid);
		List<Task> tasks = new ArrayList<>();
		for (Class clazz:classes) {
			List<Task> clazztasks = getAllTaskByClassId(clazz.getClassid());
			for (Task task:clazztasks) {
				if (!tasks.contains(task))
					tasks.add(task);
			}
		}
		return tasks;
	}
}
