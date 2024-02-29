package com.vladimir.curso.springboot.error.springbooterror.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vladimir.curso.springboot.error.springbooterror.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private List<User> users;

    ////public UserServiceImpl(){   SE INYECTARA DESDE ARRIBA CON @BEAN DE DataConfig
    ////    this.users = new ArrayList<>();
    ////    users.add(new User(1L, "Vladimir","Lopez"));
    ////    users.add(new User(2L, "Ana","Hernandez"));
    ////    users.add(new User(3L, "Rafael","Gonzo"));
    ////    users.add(new User(4L, "Gabriel","Murala"));
    ////    users.add(new User(5L, "Jose","Perez"));
    ////}

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findByiD(Long id) {
        return users.stream().filter(usr -> usr.getId().equals(id)).findFirst();
        // User user = null;
        // for (User u : users) {
        //     if (u.getId().equals(id)){
        //         user = u;
        //         break;
        //     }
        // }
        //return Optional.ofNullable(user);                                      //* En caso que no encuentre el objeto */
        
    }


}
