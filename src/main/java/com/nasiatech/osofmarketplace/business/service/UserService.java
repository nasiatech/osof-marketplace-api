package com.nasiatech.osofmarketplace.business.service;

import com.nasiatech.osofmarketplace.api.dto.UserDto;
import com.nasiatech.osofmarketplace.api.dto.UserDto;
import com.nasiatech.osofmarketplace.business.mapper.UserMapper;
import com.nasiatech.osofmarketplace.data.entity.User;
import com.nasiatech.osofmarketplace.data.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(userMapper::userToUserDto).toList();
    }

    public UserDto getById(Integer id) {
        return userMapper.userToUserDto(getEntityById(id));
    }

    public User getEntityById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
