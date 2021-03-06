package uz.pj.simple_trello.mapper.project;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pj.simple_trello.dto.project.ProjectMemberCreateDto;
import uz.pj.simple_trello.dto.project.ProjectMemberDto;
import uz.pj.simple_trello.dto.project.ProjectMemberUpdateDto;
import uz.pj.simple_trello.entity.project.ProjectMember;
import uz.pj.simple_trello.mapper.base.BaseMapper;


import java.util.List;


@Component
@Mapper(componentModel = "spring")
public abstract class ProjectMemberMapper implements BaseMapper<
        ProjectMember,
        ProjectMemberDto,
        ProjectMemberCreateDto,
        ProjectMemberUpdateDto>,
        uz.pj.simple_trello.mapper.base.Mapper {
    @Override
    public ProjectMemberDto toDto(ProjectMember projectMember) {
        return null;
    }

    @Override
    public List<ProjectMemberDto> toDto(List<ProjectMember> e) {
        return null;
    }

    @Override
    public ProjectMember fromCreateDto(ProjectMemberCreateDto projectMemberCreateDto) {
        return null;
    }

    @Override
    public ProjectMember fromUpdateDto(ProjectMemberUpdateDto projectMemberUpdateDto) {
        return null;
    }
}
