package jjay.blog.developer.service;

import jjay.blog.developer.domain.Article;
import jjay.blog.developer.dto.AddArticleRequest;
import jjay.blog.developer.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor //final 이 붙거나 @NotNull 이 붙은 필드의 생성자 추가
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
