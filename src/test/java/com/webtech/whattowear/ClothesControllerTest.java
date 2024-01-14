package com.webtech.whattowear;

import com.webtech.whattowear.controller.ClothesController;
import com.webtech.whattowear.model.Clothes;
import com.webtech.whattowear.repository.ClothesRepository;
import com.webtech.whattowear.service.ClothesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClothesControllerTest {

    @Mock
    private ClothesService clothesService;

    @Mock
    private ClothesRepository clothesRepository;

    @InjectMocks
    private ClothesController clothesController;

    private Clothes clothes;

    @BeforeEach
    void setUp() {
        clothes = new Clothes();
        clothes.setId(1L);
        clothes.setCategory("Jacket");
        clothes.setMinTemp(0L);
        clothes.setMaxTemp(10L);
        clothes.setDescription("Winter Jacket");
    }

    @Test
    void getAllClothes_NonEmptyList() {
        when(clothesService.getAll()).thenReturn(Arrays.asList(clothes));
        List<Clothes> result = clothesController.getAllClothes();
        assertFalse(result.isEmpty());
        verify(clothesService).getAll();
    }

    @Test
    void getAllClothes_EmptyList() {
        when(clothesService.getAll()).thenReturn(Arrays.asList());
        List<Clothes> result = clothesController.getAllClothes();
        assertTrue(result.isEmpty());
        verify(clothesService).getAll();
    }

    @Test
    void getClothesById_Found() {
        when(clothesService.getClothes(1L)).thenReturn(Optional.of(clothes));
        ResponseEntity<Clothes> response = clothesController.getClothesById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(clothesService).getClothes(1L);
    }

    @Test
    void getClothesById_NotFound() {
        when(clothesService.getClothes(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> clothesController.getClothesById(1L));
        verify(clothesService).getClothes(1L);
    }

    @Test
    void createClothes_Success() {
        when(clothesService.save(any(Clothes.class))).thenReturn(clothes);
        Clothes result = clothesController.createClothes(clothes);
        assertNotNull(result);
        assertEquals("Jacket", result.getCategory());
        verify(clothesService).save(any(Clothes.class));
    }

    @Test
    void updateClothes_Success() {
        Clothes clothes = new Clothes();
        clothes.setId(1L);
        clothes.setCategory("Jacket");
        clothes.setDescription("Winter Jacket");
        clothes.setMinTemp(0L);
        clothes.setMaxTemp(10L);

        when(clothesRepository.findById(1L)).thenReturn(Optional.of(clothes));

        Clothes updatedClothes = new Clothes();
        updatedClothes.setCategory("Jacket");
        updatedClothes.setDescription("Summer Jacket");
        updatedClothes.setMinTemp(15L);
        updatedClothes.setMaxTemp(30L);

        when(clothesRepository.save(any(Clothes.class))).thenReturn(updatedClothes);

        Clothes result = clothesController.updateClothes(1L, updatedClothes);
        assertNotNull(result);
        assertEquals("Jacket", result.getCategory());
        verify(clothesRepository).findById(1L);
        verify(clothesRepository).save(any(Clothes.class));
    }

    @Test
    void deleteClothes_Success() {
        doNothing().when(clothesService).delete(1L);
        ResponseEntity<Void> response = clothesController.deleteClothes(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(clothesService).delete(1L);
    }

    @Test
    void deleteClothes_NotFound() {
        doThrow(new RuntimeException("Clothes not found")).when(clothesService).delete(1L);
        assertThrows(RuntimeException.class, () -> clothesController.deleteClothes(1L));
        verify(clothesService).delete(1L);
    }
}
