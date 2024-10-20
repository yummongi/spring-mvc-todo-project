package yummongi.todo;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import yummongi.todo.domain.task.Task;
import yummongi.todo.domain.task.TaskCategories;
import yummongi.todo.domain.task.TaskPriority;
import yummongi.todo.domain.task.TaskRepository;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Component
@RequiredArgsConstructor
public class TestInitData {

    private final TaskRepository taskRepository;

    @PostConstruct
    public void init() {
        Task task1 = new Task(new AtomicLong(1L), "Spring 공부하기", "스프링 공부 하자!", false, TaskCategories.STUDY, TaskPriority.HIGH, LocalDateTime.now(), LocalDateTime.now());
        Task task2 = new Task(new AtomicLong(2L), "Java 공부하기", "자바 공부 하자!", false, TaskCategories.STUDY, TaskPriority.MEDIUM, LocalDateTime.now(), LocalDateTime.now());
        taskRepository.save(task1);
        taskRepository.save(task2);
    }
}
