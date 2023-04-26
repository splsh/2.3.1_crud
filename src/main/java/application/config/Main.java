package application.config;

import application.dao.UserDaoImpl;
import application.entity.User;
import application.service.UserService;
import application.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class Main {
    private static UserServiceImpl userService;

    @Autowired
    public Main(UserServiceImpl userService) {
        this.userService = userService;
    }


    public static void main(String[] args) {

        User user1 = new User("pet", "dog", true, 1);
       userService.addUser(user1);
        System.out.println(" Увидь меня ! /////////////////////////////////////////////////////////////////////////////");
    }
}
