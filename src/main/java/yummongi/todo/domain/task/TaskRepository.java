package yummongi.todo.domain.task;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public interface TaskRepository {

    Task save(Task task);

    Task findById(Long taskId);

    Task remove(Long taskId);

    Task edit(Long taskId, Task task);

    void clear();

    List<Task> findAll();
}
