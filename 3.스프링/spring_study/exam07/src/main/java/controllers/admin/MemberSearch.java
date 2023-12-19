package controllers.admin;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data // getter와 setter위주
public class MemberSearch {
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private LocalDate sdate;

    @DateTimeFormat(pattern="yyyy/MM/dd")
    private LocalDate edate;
}
