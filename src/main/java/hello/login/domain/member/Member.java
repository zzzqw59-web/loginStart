package hello.login.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member {
    private Long id;
    @NotBlank
    private String loginId; // 로그인ID
    @NotBlank
    private String name;
    @NotBlank
    private String password;
}
