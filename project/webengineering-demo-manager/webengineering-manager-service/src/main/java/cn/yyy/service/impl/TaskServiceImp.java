package cn.yyy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yyy.mapper.TaskMapper;
import cn.yyy.pojo.Class;
import cn.yyy.pojo.Course;
import cn.yyy.pojo.StudentInfo;
import cn.yyy.pojo.Task;
import cn.yyy.pojo.TaskExample;
import cn.yyy.pojo.TaskExample.Criteria;

public class TaskServiceImp {
	@Autowired
	private TaskMapper taskMapper;
	
	public void assginTask(String taskName,String taskContent,Integer teacherid,Integer courseid,Date deadline) {
		Task task = new Task();
		task.setCourseid(courseid);
		task.setDeadline(deadline);
		task.setTaskcontent(taskContent);
		task.setTaskid(null);
		task.setTaskname(taskName);
		task.setTeacherid(teacherid);
		taskMapper.insert(task);
		StudentServiceImp studentServiceImp = new StudentServiceImp();
		List<StudentInfo> studentInfos = studentServiceImp.getCourseStudentsInfoByCourseId(courseid);
		MessageServiceImp messageServiceImp = new MessageServiceImp();
		for (StudentInfo studentInfo:studentInfos) {
			messageServiceImp.addMessage(taskContent, teacherid, studentInfo.getUserid());
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
		CourseServiceImp courseServiceImp = new CourseServiceImp();
		Course course = courseServiceImp.getCourseByClassId(classid);
		List<Task> tasks = getAllTaskByCourseId(course.getCourseid());
		return tasks;
	}
	
	public List<Task> getAllTaskByStudentId(Integer studentid){
		StudentServiceImp studentServiceImp = new StudentServiceImp();
		List<Class> classes = studentServiceImp.getAllClassByStudentid(studentid);
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
