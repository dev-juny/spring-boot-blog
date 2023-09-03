package jjay.blog.developer.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity //엔티티 지정
@Getter
public class Article {
    @Id //ID가 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키는 자동으로 1씩 증가
    @Column(name="id", updatable = false)
    private Long id;


    @Column(name = "title", nullable = false) //title not null 처리
    private String title;

    @Column(name ="content", nullable = false)
    private String content;
    
    @Builder // 빌더 패턴으로 객체 생성
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }
    protected Article() { //기본 생성자
        
    }

}