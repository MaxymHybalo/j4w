package java4web.services;

import java4web.entity.User;
import java4web.entity.UserRole;
import java4web.repositories.UserRepository;
import java4web.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserRoleRepository roleRepository;

    @Override
    public void save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        roleRepository.save(new UserRole(user.getId(),"ROLE_USER"));
    }

    @Override
    public User getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public String findRole(String name) {
        return roleRepository.findRoleByUserName(name);
    }
}
