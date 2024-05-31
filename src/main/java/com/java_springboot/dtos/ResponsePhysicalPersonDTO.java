package com.java_springboot.dtos;

import java.util.List;

public record ResponsePhysicalPersonDTO(String id, String name , String  cpf, String phone, List<ResponseAddressDTO> addresses ) {
}
