package com.ukg.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String entity , String field , Long id) {
        super(entity + " with field: " + field + " id: " + id + " not found! ");
    }
}
