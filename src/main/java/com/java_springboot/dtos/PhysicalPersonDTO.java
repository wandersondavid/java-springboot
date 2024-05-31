package com.java_springboot.dtos;

import java.util.List;

public record PhysicalPersonDTO(String name , String  cpf, String phone, List<AddressDTO> addresses ) {
}
