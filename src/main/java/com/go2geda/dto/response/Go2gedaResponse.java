package com.go2geda.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Builder
public class Go2gedaResponse <T>{
    private T data;
}
