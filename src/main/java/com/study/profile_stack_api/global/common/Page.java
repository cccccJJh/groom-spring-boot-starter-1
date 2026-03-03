package com.study.profile_stack_api.global.common;

import com.study.profile_stack_api.domain.techstack.entity.TechStack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean first;
    private boolean last;
    private boolean hasPrevious;
    private boolean hasNext;


    public Page(List<T> content, int page, int size, long totalElements) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;

        //자동 계산
        this.totalPages = size == 0 ? 0 : (int) Math.ceil((double) totalElements / size);
        this.first = page == 0;
        this.last = page >= this.totalPages - 1;
        this.hasPrevious = page > 0;
        this.hasNext = page < this.totalPages - 1;
    }

}

