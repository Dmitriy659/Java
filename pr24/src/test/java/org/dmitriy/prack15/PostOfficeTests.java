package org.dmitriy.prack15;

import org.dmitriy.prack15.entity.PostOffice;
import org.dmitriy.prack15.repositories.PostOfficeRepository;
import org.dmitriy.prack15.services.EmailService;
import org.dmitriy.prack15.services.PostOfficeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PostOfficeTests {
    @Mock
    private PostOfficeRepository postOfficeRepository;
    @Mock
    private EmailService emailService;

    @Test
    public void getPostOffices() {
        PostOffice postOffice = new PostOffice();
        postOffice.setCityName("Moscow");
        PostOffice postOffice2 = new PostOffice();
        postOffice2.setCityName("Kazan");
        PostOffice postOffice3 = new PostOffice();
        postOffice3.setCityName("Tula");
        Mockito.when(postOfficeRepository.findAll()).thenReturn(List.of(postOffice, postOffice2, postOffice3));

        PostOfficeService postOfficeService = new PostOfficeService(postOfficeRepository, emailService);

        Assertions.assertEquals(3, postOfficeService.getAllPost().size());
        Assertions.assertEquals("Moscow", postOfficeService.getAllPost().getFirst().getCityName());
    }

    @Test
    public void saveTest() {
        PostOffice postOffice = new PostOffice();
        postOffice.setCityName("Moscow");
        PostOfficeService postOfficeService = new PostOfficeService(postOfficeRepository, emailService);
        postOfficeService.addPost(postOffice);
        ArgumentCaptor<PostOffice> captor = ArgumentCaptor.forClass(PostOffice.class);
        Mockito.verify(postOfficeRepository).save(captor.capture());
        PostOffice captured = captor.getValue();
        Assertions.assertEquals("Moscow", captured.getCityName());
    }
}
