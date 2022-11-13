package com.profeel.monsterfac.monsterfactoryserver.play.query.repository;

import com.profeel.monsterfac.monsterfactoryserver.play.query.data.PlayRankData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <pre>
 * Class : PlayQueryMapper
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Mapper
public interface PlayQueryMapper {

    List<PlayRankData> findRankingByGameId(int playGameId);

}
