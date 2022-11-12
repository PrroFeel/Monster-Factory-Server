package com.profeel.monsterfac.monsterfactoryserver.project.command.infra.service;


import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.MemberId;
import com.profeel.monsterfac.monsterfactoryserver.member.query.service.MemberQueryService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Editor;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.service.ProjectService;
import com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.model.TowerId;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * Class : ProjectServiceImpl
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-06       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@DomainService
public class ProjectServiceImpl implements ProjectService {

    private MemberQueryService memberQueryService;

    @Autowired
    public ProjectServiceImpl(MemberQueryService memberQueryService){
        this.memberQueryService = memberQueryService;
    }

    @Override
    public TowerId isValid(Integer towerId) {
        return new TowerId(towerId);
    }
    @Override
    public Editor createEditor(String userId) {
        memberQueryService.isVailable(userId);
        return new Editor(new MemberId(userId));
    }




}
