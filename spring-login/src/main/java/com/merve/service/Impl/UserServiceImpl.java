package com.merve.service.Impl;

import com.merve.dto.UserDto;
import com.merve.entity.User;
import com.merve.repository.RoleRepository;
import com.merve.repository.UserRepository;
import com.merve.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        user.setEnabled(true);
        user.setFirstName(userDto.getFirstname());
        user.setLastName(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        User userDb = userRepository.save(user);

        userDto.setId(userDb.getId());
        return userDto;
    }
}
