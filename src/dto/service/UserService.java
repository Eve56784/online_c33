package dto.service;


import dto.dto.UserDto;
import dto.entity.UserEntity;
import dto.mapper.UserMapper;

public class UserService {
    public UserEntity getUser() {
        return new UserEntity(1,"eee@mail.ru","Li","3333");
    }

    public UserDto getUserDto(){
        UserEntity user = getUser();
        return UserMapper.toDto(user);
    }
}
