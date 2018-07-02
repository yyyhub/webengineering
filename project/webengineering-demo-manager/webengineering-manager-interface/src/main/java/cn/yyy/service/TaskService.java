package cn.yyy.service;

import java.util.Date;
import java.util.List;

import cn.yyy.pojo.Task;

public interface TaskService {
	public void assginTask(String taskName,String taskContent,Integer teacherid,Integer courseid,Date deadline);
	
	public List<Task> getAllTaskByCourseId(Integer courseid);
	
	public List<Task> getAllTaskByClassId(Integer classid);
	
	public List<Task> getAllTaskByStudentId(Integer studentid);
	
	
}
