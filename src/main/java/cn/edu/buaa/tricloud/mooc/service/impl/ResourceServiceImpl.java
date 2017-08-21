package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.Request.ResourceInsert;
import cn.edu.buaa.tricloud.mooc.domain.Course;
import cn.edu.buaa.tricloud.mooc.domain.Resource;
import cn.edu.buaa.tricloud.mooc.exception.CourseNotFound;
import cn.edu.buaa.tricloud.mooc.exception.ResourceNotFound;
import cn.edu.buaa.tricloud.mooc.exception.ResourceNotInCourse;
import cn.edu.buaa.tricloud.mooc.repository.CourseRepository;
import cn.edu.buaa.tricloud.mooc.repository.ResourceRepository;
import cn.edu.buaa.tricloud.mooc.service.ResourceService;
import cn.edu.buaa.tricloud.mooc.utils.FileUpLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
import java.util.List;

/**
 * Created by qixiang on 8/20/17.
 */
@Component("ResourceService")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    FileUpLoadUtils fileUpLoadUtils;

    public List<Resource> getByCourse(Integer cid) {
        List<Resource> resources = resourceRepository.getByCourse(cid);

        if ( resources == null || resources.isEmpty() ) throw new ResourceNotFound(String.format("failure to find resources with course id:%d",cid));

        return resources;
    }

    public Integer insert(Integer cid, ResourceInsert resourceInsert, Part attachment) {

        Course course = courseRepository.get(cid);
        if ( course == null ) throw new CourseNotFound(String.format("failure to find the course by id:%d",cid));

        return resourceRepository.insert(resourceInsert.build(cid,fileUpLoadUtils.save(course.getLogin_name(),course.getId(),attachment)));
    }

    public void update(Integer cid, Integer rid, String name, Part attachment) {

        Course course = courseRepository.get(cid);
        if ( course == null ) throw new CourseNotFound(String.format("failure to find the course by id:%d",cid));

        Resource resource = resourceRepository.getById(rid);
        if ( resource == null ) throw new ResourceNotFound(String.format("failure to find the resource by id:%d",rid));
        if ( resource.getCid().compareTo(cid) != 0 ) throw new ResourceNotInCourse(String.format("resource %d not in the course %d", rid, cid));

        if ( name != null ) resource.setName(name);
        if ( attachment.getSize() != 0 ) {
            resource.setAttachment(fileUpLoadUtils.save(course.getLogin_name(),cid,attachment));
        }

        resourceRepository.update(resource);
    }

    public void delete(Integer cid, Integer rid) {
//        Course course = courseRepository.get(cid);
//        if ( course == null ) throw new CourseNotFound(String.format("failure to find the course by id:%d",cid));

//        Resource resource = resourceRepository.getById(rid);
//        if ( resource == null ) throw new ResourceNotFound(String.format("failure to find the resource by id:%d",rid));

        resourceRepository.delete(rid);
    }
}
