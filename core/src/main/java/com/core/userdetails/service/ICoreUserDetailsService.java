package com.core.userdetails.service;

public interface ICoreUserDetailsService {

    long isValidToken(String token64);
}
