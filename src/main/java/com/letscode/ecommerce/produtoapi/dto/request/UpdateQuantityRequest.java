package com.letscode.ecommerce.produtoapi.dto.request;

import com.letscode.ecommerce.produtoapi.enuns.OperationQuantity;
import lombok.Getter;

@Getter
public class UpdateQuantityRequest {
    private Integer amount;
    private OperationQuantity operation;
}
