package com.profeel.monsterfac.monsterfactoryserver.member.command.presentation;


import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto.LoginDTO;
import com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto.SignUpDTO;
import com.profeel.monsterfac.monsterfactoryserver.member.command.application.service.ReqMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * Class : MemberController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-03       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Api(tags = {"Auth API"}, description = "회원 로그인, 회원가입 api")
@RestController
@RequestMapping("/auth")
public class MemberController {

    private final ReqMemberService memberService;

    public MemberController(ReqMemberService memberService) {
        this.memberService = memberService;
    }

    @ApiOperation(value = "회원가입", notes = "회원 가입하는 api, 비밀번호는 10자 이상으로 대문자, 숫자, 특수문자를 포함해야 한다")
    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO> signup(@RequestBody SignUpDTO signupinfo) {
        System.out.println("post 요청 옴");
        System.out.println("controller : "+ signupinfo);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED.value(), "회원 가입 성공", memberService.registMember(signupinfo)));
    }

    @ApiOperation(value = "로그인", notes = "로그인을 하는 api")
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO logininfo) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK.value(), "로그인 성공", memberService.login(logininfo)));
    }

}