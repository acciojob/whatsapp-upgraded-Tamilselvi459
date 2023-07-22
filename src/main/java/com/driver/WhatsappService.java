package com.driver;

import com.driver.Exception.UserAlreadyExists;
import com.driver.Repository.GroupRepository;
import com.driver.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class WhatsappService {

@Autowired UserRepository userRepository;
@Autowired
    GroupRepository groupRepository;
        int groupcount;

    public String createUser(String name, String mobile) {

        User user = userRepository.findByMobile(mobile);
        if(user!=null){
            throw new UserAlreadyExists("User already exists");
        }
        User user1 = new User();
        user1.setMobile(mobile);
        user1.setName(name);

        userRepository.save(user1);
        return "User registered successfully";
    }

    public Group createGroup(List<User> users) {

        Group sgroup = null;
        if(users.size()==2){
            Group group = new Group();
            group.setName(users.get(1).getName());
            group.setNumberOfParticipants(2);
           Group savedgroup =  groupRepository.save(group);
           List<User> list = savedgroup.getUserList();

          for(User user : list) user.setGroup(savedgroup);
           return savedgroup;
        }
        else if(users.size()>2){
             groupcount++;
            Group group = new Group();
            group.setName("Group" + groupcount);
            group.setNumberOfParticipants(users.size());
             Group savedgroup = groupRepository.save(group);
            List<User> list = savedgroup.getUserList();

            for(User user : list) user.setGroup(savedgroup);
             return savedgroup;
        }
        return sgroup;
    }
}
