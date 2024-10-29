package com.example.springbootsimpleapp.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springbootsimpleapp.model.Board;
import com.example.springbootsimpleapp.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardResource {
    private final BoardService boardService;

    public BoardResource(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Board>> getAllBoards () {
        List<Board> boards = boardService.findAllBoards();
        return new ResponseEntity<>(boards, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Board> getBoardById (@PathVariable("id") Long id) {
        Board board = boardService.findBoardById(id);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Board> addBoard(@RequestBody Board board) {
        Board newBoard = boardService.addBoard(board);
        return new ResponseEntity<>(newBoard, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Board> updateBoard(@RequestBody Board board) {
        Board updateBoard = boardService.updateBoard(board);
        return new ResponseEntity<>(updateBoard, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
