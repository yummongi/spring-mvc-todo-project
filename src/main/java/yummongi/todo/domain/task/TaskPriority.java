package yummongi.todo.domain.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public enum TaskPriority {
    HIGH("높음"),
    MEDIUM("중간"),
    LOW("낮음");

    private final String description;

    @Override
    public String toString() {
        return description;
    }
}
