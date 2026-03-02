package com.study.profile_stack_api.domain.profile.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class ProfileUpdateRequest{
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
    private String position;

    @NotNull(message = "경력 연차는 필수입니다.")
    @Min(value = 0, message = "경력 연차는 0 이상이어야 합니다.")
    private Integer careerYears;

    @Size(max = 200, message = "GitHub 주소는 200자 이하여야 합니다.")
    private String githubUrl;

    @Size(max = 200, message = "블로그 주소는 200자 이하여야 합니다.")
    private String blogUrl;

    // 전부 null인지 체크용
    public boolean hasNoUpdates() {
        return name == null
                && email == null
                && bio == null
                && position == null
                && careerYears == null
                && githubUrl == null
                && blogUrl == null;
    }
}
