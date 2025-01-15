package cafeboard.Board;

import java.time.LocalDateTime;

public record ReadBoardResponse(
        Long id,
        String title,
        LocalDateTime createdTime

) {
}
