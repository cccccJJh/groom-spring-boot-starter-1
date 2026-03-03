package com.study.profile_stack_api.domain.techstack.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.study.profile_stack_api.domain.techstack.entity.Proficiency;
import com.study.profile_stack_api.domain.techstack.entity.TechCategory;
import com.study.profile_stack_api.domain.techstack.entity.TechStack;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TechStackResponse {
    private Long id;
    private Long profileId;
    private String name;
    private TechCategory category;
    private String categoryIcon;
    private Proficiency proficiency;
    private String proficiencyIcon;
    private Integer yearsOfExp;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 기본 생성자
    public TechStackResponse() {}

    // 모든 필드를 포함한 생성자
    public TechStackResponse(TechStack techStack) {
        this.id = techStack.getId();
        this.profileId = techStack.getProfileId();
        this.name = techStack.getName();
        this.category = techStack.getCategory();
        this.categoryIcon = techStack.getCategory().getIcon();
        this.proficiency = techStack.getProficiency();
        this.proficiencyIcon = techStack.getProficiency().getIcon();
        this.yearsOfExp = techStack.getYearsOfExp();
        this.createdAt = techStack.getCreatedAt();
        this.updatedAt = techStack.getUpdatedAt();
    }

    public static TechStackResponse from(TechStack techStack) {
        TechStackResponse response =  new TechStackResponse(techStack);

        response.setCategoryIcon(techStack.getCategory().getIcon());
        response.setProficiencyIcon(techStack.getProficiency().getIcon());

        return response;
    }
}
