package com.gotod.gototest.services.impl;

import com.gotod.gototest.repositories.RoleRepository;
import com.gotod.gototest.services.RoleService;
import com.gotod.gototest.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> consultRole() {

        return roleRepository.consultRole();
    }


}
