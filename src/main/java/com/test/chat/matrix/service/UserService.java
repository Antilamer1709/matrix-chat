package com.test.chat.matrix.service;

import com.test.chat.matrix.model.LoginModel;
import com.test.chat.matrix.utils.SynapseRestHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
public class UserService {

    private final SynapseRestHelper synapseRestHelper;

    public LoginModel login(LoginModel loginModel) {
        return synapseRestHelper.exchange(null, "/login", POST, loginModel, LoginModel.class);
    }
}