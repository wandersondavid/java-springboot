package com.java_springboot.dtos;

public record ResponseAddressDTO(
        String id,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String zip_code,
        String physical_person_id){
}
