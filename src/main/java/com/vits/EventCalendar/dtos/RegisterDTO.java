package com.vits.EventCalendar.dtos;

import com.vits.EventCalendar.enums.UserRole;

public record RegisterDTO(String login, String password, String email, UserRole role) {
}
