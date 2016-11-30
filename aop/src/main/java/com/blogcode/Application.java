package com.blogcode;

import com.blogcode.board.Board;
import com.blogcode.board.BoardRepository;
import com.blogcode.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Application implements CommandLineRunner{

	@Autowired
	private BoardService boardService;

	@Autowired
	private BoardRepository boardRepository;

	@Override
	public void run(String... args) throws Exception {
		for(int i=1;i<=100;i++){
			boardRepository.save(new Board(i+"번째 게시글의 제목", i+"번째 게시글의 내용"));
		}
	}

	@GetMapping("/")
	public List<Board> getBoards() {
		return boardService.getBoards();
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
