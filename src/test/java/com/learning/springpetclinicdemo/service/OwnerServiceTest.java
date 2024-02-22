package com.learning.springpetclinicdemo.service;

import com.learning.springpetclinicdemo.entity.Owner;
import com.learning.springpetclinicdemo.repository.OwnerRepository;
import com.learning.springpetclinicdemo.testsupport.factories.OwnerFactory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringJUnitConfig
public class OwnerServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerService ownerService;


    @Test
    public void testGetAllOwners() {

        List<Owner> owners = Arrays.asList(
                OwnerFactory.createJohnDoe(), OwnerFactory.createJaneSmith());
        when(ownerRepository.findAll()).thenReturn(owners);

        List<Owner> allOwners = ownerService.getAllOwners();

        assertThat(allOwners.size()).isEqualTo(2);
        assertThat(allOwners.get(0).getFirstName()).isEqualTo("John");
        assertThat(allOwners.get(1).getFirstName()).isEqualTo("Jane");

        verify(ownerRepository, times(1)).findAll();


    }

}
