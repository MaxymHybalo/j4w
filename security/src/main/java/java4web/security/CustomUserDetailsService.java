package java4web.security;

import java4web.entity.User;
import java4web.repositories.UserRepository;
import java4web.repositories.UserRoleRepository;
import java4web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService service;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = service.getByName(s);

        if(user == null){
            throw  new UsernameNotFoundException("User " +s);
        }else{
            String role = service.findRole(user.getName());
            return new UserSecurity(user,role);
        }
    }
}
