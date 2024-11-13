package com.vits.EventCalendar.dtos;

import java.util.List;
import java.util.UUID;

import jakarta.annotation.Nullable;

public record InviteUsersRequestDTO(List<UUID> invitedUsersIDs, UUID eventId, @Nullable String emailBody) {

}
