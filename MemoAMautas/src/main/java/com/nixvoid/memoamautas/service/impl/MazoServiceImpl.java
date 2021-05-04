package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.dto.cards.Mazo;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.user.Persona;
import com.nixvoid.memoamautas.repository.MazoRepository;
import com.nixvoid.memoamautas.service.MazoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MazoServiceImpl implements MazoService {

    @Autowired
    private MazoRepository mazoRepository;

    @Override
    public List<Mazo> getByAutor(Persona persona) {
        return mazoRepository.getByAutor(persona);
    }

    @Override
    public List<Mazo> obtenerMazos(Curso curso) {
        return mazoRepository.obtenerMazos(curso);
    }
}
