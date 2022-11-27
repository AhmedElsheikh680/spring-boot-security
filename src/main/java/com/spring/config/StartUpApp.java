//package com.spring.config;
//
//import com.spring.entity.AppUser;
//import com.spring.entity.Role;
//import com.spring.service.RoleService;
//import com.spring.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//@RequiredArgsConstructor
//public class StartUpApp implements CommandLineRunner {
//
//    private final UserService userService;
//    private final RoleService roleService;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        if (roleService.findAll().isEmpty()){
//            roleService.save(new Role(null, "ADMIN"));
//            roleService.save(new Role(null, "USER"));
//            roleService.save(new Role(null, "EMPLOYEE"));
//        }
//
//
//        if (userService.findAll().isEmpty()){
//            Set<Role> adminRoles = new HashSet<>();
//            adminRoles.add(roleService.findByName("ADMIN"));
//
//            Set<Role> userRoles = new HashSet<>();
//            userRoles.add(roleService.findByName("USER"));
//
//            Set<Role> employeeRoles = new HashSet<>();
//            employeeRoles.add(roleService.findByName("EMPLOYEE"));
//            userService.save(new AppUser(null, "Ahmed Mohamed","Ahmed", "12345", adminRoles));
//            userService.save(new AppUser(null, "Kamal Ali", "Kamal", "12345", userRoles));
//            userService.save(new AppUser(null, "Ramy Helal","Kamal","12345", employeeRoles));
//        }
//
//    }
//}
