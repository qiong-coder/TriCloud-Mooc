package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.domain.CourseOrder;
import cn.edu.buaa.tricloud.mooc.exception.CourseOrderNotFound;
import cn.edu.buaa.tricloud.mooc.repository.CourseOrderRepository;
import cn.edu.buaa.tricloud.mooc.service.MachineService;
import cn.edu.buaa.tricloud.mooc.utils.MachineUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by stupid-coder on 8/22/17.
 */
@Component("MachineService")
public class MachineServiceImpl implements MachineService {

    @Autowired
    CourseOrderRepository courseOrderRepository;

    public JSONObject create() {
        return MachineUtil.create();
    }

    public void start(Integer oid) {
        CourseOrder courseOrder = courseOrderRepository.get(oid);
        if ( courseOrder == null ) throw new CourseOrderNotFound(String.format("failure to find the course order by id:%d",oid));

        MachineUtil.start(JSONObject.parseObject(courseOrder.getMachine()));
    }

    public void stop(Integer oid) {
        CourseOrder courseOrder = courseOrderRepository.get(oid);
        if ( courseOrder == null ) throw new CourseOrderNotFound(String.format("failure to find the course order by id:%d",oid));

        MachineUtil.stop(JSONObject.parseObject(courseOrder.getMachine()));
    }

    public void migrate(Integer oid) {
        CourseOrder courseOrder = courseOrderRepository.get(oid);
        if ( courseOrder == null ) throw new CourseOrderNotFound(String.format("failure to find the course order by id:%d",oid));

        JSONObject machine_info = MachineUtil.migrate(JSONObject.parseObject(courseOrder.getMachine()));
        courseOrder.setMachine(machine_info.toJSONString());
        courseOrderRepository.update(courseOrder);
    }
}
