package jjay.blog.developer.service;

import jakarta.transaction.Transactional;
import jjay.blog.developer.domain.Article;
import jjay.blog.developer.dto.AddArticleRequest;
import jjay.blog.developer.dto.UpdateArticleRequest;
import jjay.blog.developer.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor //final 이 붙거나 @NotNull 이 붙은 필드의 생성자 추가
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional //트랜잭션 메서드
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found:"  + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }

}
