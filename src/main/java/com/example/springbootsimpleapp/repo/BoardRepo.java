package com.example.springbootsimpleapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootsimpleapp.model.Board;

import java.util.Optional;

public interface BoardRepo extends JpaRepository<Board, Long> {
    void deleteBoardById(Long id);

    Optional<Board> findBoardById(Long id);
}
