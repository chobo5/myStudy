package com.example.board.service;

import com.example.board.dao.BoardDao;
import com.example.board.dto.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDao boardDao;
    @Transactional
    public void addBoard(int userId, String title, String content) {
        boardDao.addBoard(userId, title, content);
    }
    @Transactional(readOnly = true) //조회만 할떄는 성능상 readOnly=true가 좋다.
    public List<Board> getBoards(int page) {
        return boardDao.getBoards(page);
    }

    @Transactional(readOnly = true) //조회만 할떄는 성능상 readOnly=true가 좋다.
    public int getTotalCount() {
        return boardDao.getTotalCount();
    }
}
