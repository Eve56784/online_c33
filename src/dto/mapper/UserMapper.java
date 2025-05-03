package dto.mapper;

import dto.dto.UserDto;
import dto.entity.UserEntity;

public class UserMapper {

    public static UserDto toDto(UserEntity user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public static UserEntity toUser(UserDto dto, String password){
        return new UserEntity(dto.getId(), dto.getEmail(),  dto.getName(), password);
    }
}
