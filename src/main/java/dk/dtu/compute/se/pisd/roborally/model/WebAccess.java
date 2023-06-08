package dk.dtu.compute.se.pisd.roborally.model;

import dk.dtu.compute.se.pisd.roborally.fileaccess.LoadBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@SpringBootApplication
@RestController

public class WebAccess {
    private Board board;
    public WebAccess(Board board)
    {
        this.board=board;
    }


    @RequestMapping("/share")
    public class boardWebController
    {

        @Autowired


        public boardWebController(Board board)
        {
           // this.board=board;
        }

        @GetMapping("/share")
        /*
        public board read(@PathVariable String id)
        {
      //      return board.find(id);
            return board;
        }

         */

        @PostMapping("share")
        public ResponseEntity<Board> create(@RequestBody Board board)
                throws URISyntaxException {
            Board createdBoard = LoadBoard.loadBoard("Share");
            if (createdBoard == null) {
                return ResponseEntity.notFound().build();
            } else {
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand("share")
                        .toUri();

                return ResponseEntity.created(uri)
                        .body(createdBoard);
            }
        }

        @GetMapping("/share")
        public ResponseEntity<Board> read(@PathVariable("share") Long id)
        {
            Board foundBoard = LoadBoard.loadBoard("Share");
            if (foundBoard == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(foundBoard);
            }
        }
/*
        @PutMapping("/{id}")
        public ResponseEntity<Board> update(@RequestBody Board Board, @PathVariable Long id) {
            Board updatedBoard = board.update(id, Board);
            if (updatedBoard == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(updatedBoard);
            }
        }



        @DeleteMapping("/{id}")
        public ResponseEntity<Object> deleteBoard(@PathVariable Long id) {
            board.delete(id);
            return ResponseEntity.noContent().build();
        }

 */
    }


}
