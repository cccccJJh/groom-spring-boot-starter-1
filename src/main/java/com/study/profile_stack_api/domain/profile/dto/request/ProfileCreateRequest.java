package com.study.profile_stack_api.domain.profile.dto.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.study.profile_stack_api.domain.profile.entity.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileCreateRequest {
//    private String name;
//    private String email;
//    private String bio;
//    private String position;
//    private Integer careerYears;
//    private String githubUrl;
//    private String blogUrl;

    private Long memberId;

    @NotBlank(message = "이름은 필수입니다.")
    @Size(max = 50, message = "이름은 50자 이하여야 합니다.")
    private String name;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    @Size(max = 100, message = "이메일은 100자 이하여야 합니다.")
    private String email;

    @Size(max = 500, message = "자기소개는 500자 이하여야 합니다.")
    private String bio;

    @NotNull(message = "직무는 필수입니다.")
    private Position position;

    @NotNull(message = "경력 연차는 필수입니다.")
    @Min(value = 0, message = "경력 연차는 0 이상이어야 합니다.")
    private Integer careerYears;

    @Size(max = 200, message = "GitHub 주소는 200자 이하여야 합니다.")
    private String githubUrl;

    @Size(max = 200, message = "블로그 주소는 200자 이하여야 합니다.")
    private String blogUrl;
}
