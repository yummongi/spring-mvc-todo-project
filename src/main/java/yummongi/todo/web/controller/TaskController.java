package yummongi.todo.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yummongi.todo.domain.task.Task;
import yummongi.todo.domain.task.TaskCategories;
import yummongi.todo.domain.task.TaskMemoryRepository;
import yummongi.todo.domain.task.TaskPriority;
import yummongi.todo.web.form.TaskSaveForm;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TaskController {

    private final TaskMemoryRepository taskMemoryRepository;

    @ModelAttribute("categoryType")
    public TaskCategories[] categories() {
        return TaskCategories.values(); //[PERSONAL, ETC ...]
    }

    @ModelAttribute("priorityType")
    public TaskPriority[] priorities() {
        return TaskPriority.values();
    }

    //할일 목록
    @GetMapping
    public String taskList(Model model) {
        List<Task> tasks = taskMemoryRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "todos/taskList";
    }

    //할 일 등록 폼
    @GetMapping("/save")
    public String saveForm(@ModelAttribute("task") TaskSaveForm task) {
        return "todos/taskSaveForm";
    }

    //할 일 등록
    @PostMapping("/save")
    public String save(@ModelAttribute("task") TaskSaveForm form) {
        log.info("form={}", form);
        Task task = new Task();
        task.setTitle(form.getTitle());
        task.setDescription(form.getDescription());
        task.setIsComplete(form.getIsComplete());
        task.setCategory(form.getCategory());
        task.setPriority(form.getPriority());
        task.setPostDate(LocalDateTime.now());
        task.setEditDate(LocalDateTime.now());

        taskMemoryRepository.save(task);

        return "redirect:/todos";
    }

    //할 일 상세
    @GetMapping("/{taskId}")
    public String taskView(@PathVariable Long taskId, Model model) {
        Task task = taskMemoryRepository.findById(taskId);
        model.addAttribute("task", task);
        return "todos/task";
    }

    @PostMapping("/{taskId}/delete")
    public String delete(@PathVariable Long taskId) {
        taskMemoryRepository.remove(taskId);
        return "redirect:/todos";
    }




    //TODO 할 일 수정 :  /{taskId}/edit POST, GET
    //TODO Bean Validation 검증 추가
    //TODO 로그인, 로그아웃, 인터셉터 추가
    //TODO 검색 기능, 필터 기능 추가


}
