package com.example.springbootsimpleapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootsimpleapp.model.Board;

import java.util.Optional;

@Repository
public interface BoardRepo extends JpaRepository<Board, Long> {
    void deleteBoardById(Long id);

    Optional<Board> findBoardById(Long id);
}
