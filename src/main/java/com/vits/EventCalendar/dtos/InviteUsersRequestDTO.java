package com.vits.EventCalendar.dtos;

import java.util.List;
import java.util.UUID;

public record InviteUsersRequestDTO(List<UUID> invitedUsersIDs, UUID eventId) {

}
