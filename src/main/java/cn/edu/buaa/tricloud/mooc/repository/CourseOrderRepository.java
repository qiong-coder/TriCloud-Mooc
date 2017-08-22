package cn.edu.buaa.tricloud.mooc.repository;

import cn.edu.buaa.tricloud.mooc.domain.CourseOrder;

import java.util.List;
import java.util.Map;

/**
 * Created by qixiang on 8/21/17.
 */
public interface CourseOrderRepository {

    List<CourseOrder> listOrdersByCourseId(Integer cid);

    List<CourseOrder> listOrdersByLoginName(String login_name);

    Map<Integer, Long> listNumbersByCourseId(Integer cid);

    CourseOrder get(Integer id);

    Integer insert(CourseOrder courseOrder);

    void update(CourseOrder courseOrder);

    void delete(Integer id);

    void deleteByCourseId(Integer cid);
}
