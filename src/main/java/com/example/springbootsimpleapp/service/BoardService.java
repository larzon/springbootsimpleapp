package com.example.springbootsimpleapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootsimpleapp.exception.BoardNotFoundException;
import com.example.springbootsimpleapp.model.Board;
import com.example.springbootsimpleapp.repo.BoardRepo;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BoardService {
    private final BoardRepo boardRepo;

    @Autowired
    public BoardService(BoardRepo boardRepo) {
        this.boardRepo = boardRepo;
    }

    public Board addBoard(Board board) {
        return boardRepo.save(board);
    }

    public List<Board> findAllBoards() {
        return boardRepo.findAll();
    }

    public Board updateBoard(Board board) {
        return boardRepo.save(board);
    }

    public Board findBoardById(Long id) {
        return boardRepo.findBoardById(id)
                .orElseThrow(() -> new BoardNotFoundException("Board by id " + id + " was not found"));
    }

    public void deleteBoard(Long id){
        boardRepo.deleteBoardById(id);
    }
}