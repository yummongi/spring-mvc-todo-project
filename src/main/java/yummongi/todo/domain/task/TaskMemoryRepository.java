package yummongi.todo.domain.task;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskMemoryRepository implements TaskRepository{

    private Map<Long, Task> store = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong(0);

    @Override
    public Task save(Task task) {
        long newId = sequence.incrementAndGet();
        task.setId(new AtomicLong(newId));
        store.put(newId, task);
        return task;
    }

    @Override
    public Task findById(Long taskId) {
        return store.get(taskId);
    }

    @Override
    public Task edit(Long taskId, Task task) {
        Task editTask = findById(taskId);
        editTask.setTitle(task.getTitle());
        editTask.setDescription(task.getDescription());
        editTask.setIsComplete(task.getIsComplete());
        editTask.setCategory(task.getCategory());
        editTask.setPriority(task.getPriority());
        editTask.setPostDate(task.getPostDate());
        editTask.setEditDate(task.getEditDate());
        return editTask;
    }

    @Override
    public Task remove(Long taskId) {
        return store.remove(taskId);
    }

    @Override
    public void clear() {
        store.clear();
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }
}
