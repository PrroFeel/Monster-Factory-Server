package com.profeel.monsterfac.monsterfactoryserver.member.query.dao;

import com.profeel.monsterfac.monsterfactoryserver.member.query.data.MemberData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : MemberRepository
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
public interface MemberDataDAO extends JpaRepository<MemberData, String> {
}
