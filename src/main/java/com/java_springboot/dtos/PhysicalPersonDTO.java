package com.java_springboot.dtos;

import com.java_springboot.domain.address.Address;

import java.util.List;

public record PhysicalPersonDTO(String name , String  cpf, String phone, List<AddressDTO> addresses ) {
}
