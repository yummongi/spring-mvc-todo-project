package yummongi.todo.web.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import yummongi.todo.domain.task.TaskCategories;
import yummongi.todo.domain.task.TaskPriority;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@ToString
public class TaskSaveForm {

    //제목
    @NotBlank
    private String title;

    //설명
    private String description;

    //상태
    @NotNull
    private Boolean isComplete;

    //카테고리
    @NotNull
    private TaskCategories category;

    //우선순위
    @NotNull
    private TaskPriority priority;
}
