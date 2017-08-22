package cn.edu.buaa.tricloud.mooc.utils;

import cn.edu.buaa.tricloud.mooc.exception.MachineOperatorError;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by stupid-coder on 8/22/17.
 */

public class MachineUtil {

    private static final String machine_uri = "http://192.168.6.20/api/v0.1/vritual_machine";

    private static JSONObject doAction(String action, Integer vm_id)
    {
        HttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(machine_uri+action);
        httpPost.setHeader("X-Token", "tricloud");

        JSONObject requestBody = new JSONObject();
        if (vm_id != null)
            requestBody.put("data",1);
        else requestBody.put("vm_id",vm_id);

        StringEntity entity = new StringEntity(requestBody.toString(), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        try {
            HttpResponse httpResponse = client.execute(httpPost);

            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                throw new MachineOperatorError(String.format("failure to do action:%s - status:%s", action,httpResponse.getStatusLine().toString()));
            } else {
                JSONObject response = JSONObject.parseObject(EntityUtils.toString(httpResponse.getEntity()));
                if (response.isEmpty())
                    throw new MachineOperatorError(String.format("failure to do action:%s - result is empty",action));
                return response;
            }
        } catch (IOException e) {
            throw new MachineOperatorError(String.format("failure to do action:%s - %s",action,e.getLocalizedMessage()));
        }
    }

    public static JSONObject create() {
        return doAction("/create", null);
    }

    public static boolean start(JSONObject machine_info) {
        if (machine_info == null || machine_info.containsKey("vm_id")) throw new MachineOperatorError(String.format("failure to start machine - machine info is error:%s",machine_info==null?"empty":machine_info.toJSONString()));

        Integer vm_id = machine_info.getInteger("vm_id");

        JSONObject response = doAction("/start", vm_id);
        if (response.containsKey("result") && response.getString("result").compareTo("success") == 0 )
            return true;
        else throw new MachineOperatorError(String.format("failure to start machine - %s",response.toJSONString()));
    }
    public static boolean stop(JSONObject machine_info) {
        if (machine_info == null || machine_info.containsKey("vm_id")) throw new MachineOperatorError(String.format("failure to stop machine - machine info is error:%s",machine_info==null?"empty":machine_info.toJSONString()));

        Integer vm_id = machine_info.getInteger("vm_id");

        JSONObject response = doAction("/start", vm_id);
        if (response.containsKey("result") && response.getString("result").compareTo("success") == 0 )
            return true;
        else throw new MachineOperatorError(String.format("failure to stop machine - %s",response.toJSONString()));
    }

    public static JSONObject migrate(JSONObject machine_info) {
        if (machine_info == null || machine_info.containsKey("vm_id")) throw new MachineOperatorError(String.format("failure to migrate machine - machine info is error:%s",machine_info==null?"empty":machine_info.toJSONString()));

        Integer vm_id = machine_info.getInteger("vm_id");

        JSONObject response = doAction("/migrate", vm_id);

        if (response.containsKey("error") && response.getString("errror").compareTo("failed") == 0 )
            throw new MachineOperatorError(String.format("failure to stop machine - %s",response.toJSONString()));
        else return response;
    }
}
