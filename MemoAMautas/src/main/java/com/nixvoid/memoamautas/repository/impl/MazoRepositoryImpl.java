package com.nixvoid.memoamautas.repository.impl;

import com.nixvoid.memoamautas.dto.cards.Mazo;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.user.Persona;
import com.nixvoid.memoamautas.repository.MazoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MazoRepositoryImpl implements MazoRepository {

    @Override
    public List<Mazo> getByAutor(Persona persona) {
        return null;
    }

    @Override
    public List<Mazo> obtenerMazos(Curso curso) {
        return null;
    }
}
