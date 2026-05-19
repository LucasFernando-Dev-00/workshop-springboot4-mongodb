package com.projeto.workshopmongo.services;

import com.projeto.workshopmongo.domain.Post;
import com.projeto.workshopmongo.domain.User;
import com.projeto.workshopmongo.repositories.PostRepository;
import com.projeto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Post post = repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return post;
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }


}
