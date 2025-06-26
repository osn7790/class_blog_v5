package com.tenco.blog.board;

import com.tenco.blog.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class BoardJpaRepositoryTest {

    @Autowired
    private BoardJpaRepository boardJpaRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void save_test() {

        User testUser = User.builder()
                .username("username")
                .password("password")
                .email("a@naver.com")
                .build();

        em.persistAndFlush(testUser);

        Board board = Board.builder()
                .title("테스트제목")
                .content("테스트 내용")
                .user(testUser)
                .build();

        // 게시글 저장 테스트
        boardJpaRepository.save(board);

    }

}
