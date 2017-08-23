package cn.edu.buaa.tricloud.mooc.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by stupid-coder on 8/22/17.
 */

public interface MachineService {

    JSONObject create(Integer school);

    void start(Integer oid);

    void stop(Integer oid);

    void migrate(Integer oid);

}
