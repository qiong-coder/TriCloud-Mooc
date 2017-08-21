package cn.edu.buaa.tricloud.mooc.service;

import cn.edu.buaa.tricloud.mooc.domain.CourseOrder;

import java.util.List;
import java.util.Map;

/**
 * Created by qixiang on 8/21/17.
 */
public interface CourseOrderService {

    List<CourseOrder> listOrdersByCourseId(Integer cid);

    List<CourseOrder> listOrdersByLoginName(String login_name);

    CourseOrder get(Integer oid);

    Integer insert(CourseOrder courseOrder);

    void update(CourseOrder courseOrder);

    void delete(Integer oid);

    Integer insertOrderCourse(String login_name, Integer cid);

    Map<Integer,Long> listOrderNumberByCourseId(Integer cid);
}
