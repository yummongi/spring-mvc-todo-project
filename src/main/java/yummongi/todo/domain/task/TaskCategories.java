package yummongi.todo.domain.task;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskCategories {
    WORK("업무"),
    PERSONAL("개인"),
    EXERCISE("운동"),
    STUDY("공부"),
    ETC("기타");

    private final String description;

    @Override
    public String toString() {
        return description;
    }
}
