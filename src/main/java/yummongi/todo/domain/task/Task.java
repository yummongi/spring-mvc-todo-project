package yummongi.todo.domain.task;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    //데이터 베이스 ID
    private AtomicLong id;

    //제목
    private String title;

    //설명
    private String description;

    //상태
    private Boolean isComplete;

    //카테고리
    private TaskCategories category;

    //우선순위
    private TaskPriority priority;

    //등록일
    @DateTimeFormat(pattern = "yyyy년 MM월 dd일 hh시 mm분")
    private LocalDateTime postDate;

    //수정일
    @DateTimeFormat(pattern = "yyyy년 MM월 dd일 hh시 mm분")
    private LocalDateTime editDate;



}
