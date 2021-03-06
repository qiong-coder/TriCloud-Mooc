package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.domain.Course;
import cn.edu.buaa.tricloud.mooc.domain.CourseOrder;
import cn.edu.buaa.tricloud.mooc.exception.AccountNotFound;
import cn.edu.buaa.tricloud.mooc.exception.CourseOrderAlreadyOrdered;
import cn.edu.buaa.tricloud.mooc.exception.CourseOrderNotFound;
import cn.edu.buaa.tricloud.mooc.repository.AccountRepository;
import cn.edu.buaa.tricloud.mooc.repository.CourseRepository;
import cn.edu.buaa.tricloud.mooc.repository.CourseOrderRepository;
import cn.edu.buaa.tricloud.mooc.service.CourseOrderService;
import cn.edu.buaa.tricloud.mooc.utils.MachineUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by qixiang on 8/21/17.
 */
@Component("CourseOrderSerivce")
public class CourseOrderServiceImpl implements CourseOrderService {

    @Autowired
    CourseOrderRepository courseOrderRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    AccountRepository accountRepository;

    public List<CourseOrder> listOrdersByCourseId(Integer cid) {
        List<CourseOrder> courseOrders = courseOrderRepository.listOrdersByCourseId(cid);
        if ( courseOrders == null || courseOrders.isEmpty() ) throw new CourseOrderNotFound(String.format("failure to find the courseOrders by course id:%d",cid));
        return courseOrders;
    }

    public List<CourseOrder> listOrdersByLoginName(String login_name) {
        List<CourseOrder> courseOrders = courseOrderRepository.listOrdersByLoginName(login_name);
        if ( courseOrders == null || courseOrders.isEmpty() ) throw new CourseOrderNotFound(String.format("failure to find the courseOrders by login_name:%s",login_name));
        return courseOrders;
    }

    public CourseOrder get(Integer oid) {
        CourseOrder courseOrder = courseOrderRepository.get(oid);
        if (courseOrder == null) throw new CourseOrderNotFound(String.format("failure to find the courseOrder by oid:%d",oid));
        return courseOrder;
    }

    public Integer insert(CourseOrder courseOrder) {
        return courseOrderRepository.insert(courseOrder);
    }

    public void update(CourseOrder courseOrder) {
        courseOrderRepository.update(courseOrder);
    }

    public void delete(Integer oid) {
        CourseOrder courseOrder = courseOrderRepository.get(oid);
        if (courseOrder == null) throw new CourseOrderNotFound(String.format("failure to find the course order by id%s", oid));
        MachineUtil.stop(courseOrder.getSchool(), JSONObject.parseObject(courseOrder.getMachine()));
        courseOrderRepository.delete(oid);
    }

    public Integer insertOrderCourse(String login_name, Integer cid) {
        Account account = accountRepository.getAccountByLoginName(login_name);
        if ( account == null ) throw new AccountNotFound(String.format("failure to find account by login_name:%s",login_name));

        CourseOrder courseOrder = courseOrderRepository.getByLoginNameAndCourseId(login_name,cid);

        if ( courseOrder == null ) {
            courseOrder = new CourseOrder();
            courseOrder.setLogin_name(login_name);
            courseOrder.setCid(cid);
            courseOrder.setSchool(account.getSchool());
            courseOrder.setMachine(MachineUtil.create(account.getSchool()).toJSONString());
            return insert(courseOrder);
        } else {
            throw new CourseOrderAlreadyOrdered(String.format("course order is already ordered - oid:%d",courseOrder.getId()));
        }
    }

    public Map<Integer, Long> listOrderNumberByCourseId(Integer cid) {
        return courseOrderRepository.listNumbersByCourseId(cid);
    }
}
