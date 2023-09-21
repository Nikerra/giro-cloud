package Giros.Service;

import Giros.dao.Entity.User;
import Giros.dao.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User= " + user + " not found");
        }
        return user;
    }
//
//    public User findUserById(Long userId) {
//        Optional<User> userFromDb = userRepository.findById(userId);
//        return userFromDb.orElse(new User());
//    }
//
//    public List<User> allUsers() {
//        return userRepository.findAll();
//    }
//
//    /***
//     * Создание юзера при регистрации
//     * @param user
//     * @return
//     */
//    public boolean saveUser(User user) {
//
//        User userFromDB = userRepository.findByUsername(user.getUsername());
//
//        if (userFromDB != null) {
//            return false;
//        }
//        user.setRole(new Role(2, "USER"));
//        user.setGroupUser(new Group(1L, "Нет группы"));
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
//        String hashedPassword = passwordEncoder.encode(user.getPassword());
//
//        user.setPassword(hashedPassword);
//        userRepository.save(user);
//        return true;
//    }
//
//    public boolean deleteUser(Long userId) {
//        if (userRepository.findById(userId).isPresent()) {
//            List<TaskResponse> taskResponse = taskResponseRepository.findAllByUserId(userId);
//            if (taskResponse != null) {
//                taskResponseRepository.deleteAll(taskResponse);
//            }
//            userRepository.deleteById(userId);
//            return true;
//        }
//        return false;
//    }
//
//    public List<Role> allRoles() {
//        return roleRepository.findAll();
//    }
//
//
//    public Role findRoleById(long id_role) {
//        return roleRepository.getById(id_role);
//    }
//
//    public void save(User user) {
//        userRepository.save(user);
//    }
//
//    public User findUserByUsername(String username) {
//        return userRepository.findByName(username);
//    }
//
//    public List<User> getUsersRoleTeacher() {
//        Long id = 3L;
//        return userRepository.getUserByRoleId(id);
//    }
}