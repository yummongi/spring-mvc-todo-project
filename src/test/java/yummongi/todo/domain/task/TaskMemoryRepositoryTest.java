package yummongi.todo.domain.task;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.*;

class TaskMemoryRepositoryTest {

    TaskRepository taskRepository = new TaskMemoryRepository();
    Task task;
    Task savedTask;

    @BeforeEach
    void beforeEach() {
        taskRepository.clear();

        task = new Task();
        task.setTitle("Spring 공부하기");
        task.setDescription("스프링에 관련된 공부하기!");
        task.setComplete(true);
        task.setCategory(TaskCategories.STUDY);
        task.setPriority(TaskPriority.HIGH);
        task.setPostDate(LocalDateTime.now());
        task.setPostDate(LocalDateTime.now());

        savedTask = taskRepository.save(task);
    }

    @Test
    void save() {
        assertThat(savedTask.getId().get()).isEqualTo(1L);
    }

    @Test
    void findById() {
        Task task = taskRepository.findById(1L);

        assertThat(savedTask).isEqualTo(task);
    }

    @Test
    void edit() {
        Task newTask = new Task();
        newTask.setTitle("Java 공부하기");
        newTask.setDescription("자바에 관련된 공부하기!");
        newTask.setIsComplete(true);
        newTask.setCategory(TaskCategories.STUDY);
        newTask.setPriority(TaskPriority.HIGH);
        newTask.setPostDate(LocalDateTime.now());
        newTask.setPostDate(LocalDateTime.now());

        Task editTask = taskRepository.edit(1L, newTask);

        assertThat(editTask.getTitle()).isEqualTo("Java 공부하기");
    }

    @Test
    void remove() {
        Task removedTask = taskRepository.remove(1L);

        assertThat(savedTask).isSameAs(removedTask);
    }

    @Test
    void findAll() {
        List<Task> tasks = taskRepository.findAll();
        assertThat(tasks.size()).isEqualTo(1);
    }
}