package com.spmia.chapterone.chapterone.mapper;

import com.spmia.chapterone.chapterone.dto.UserDto;
import com.spmia.chapterone.chapterone.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto userDto);
    List<User> toUser(List<UserDto> userDto);

    UserDto toUserDto(User user);
    List<UserDto> toUserDto(List<User> user);
}
