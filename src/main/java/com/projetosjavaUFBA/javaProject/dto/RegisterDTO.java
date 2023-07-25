package com.projetosjavaUFBA.javaProject.dto;

import com.projetosjavaUFBA.javaProject.enuns.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
