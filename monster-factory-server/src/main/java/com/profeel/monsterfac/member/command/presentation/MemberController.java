package com.profeel.monsterfac.member.command.presentation;


import com.profeel.monsterfac.common.dto.ResponseDTO;
import com.profeel.monsterfac.member.command.application.dto.LoginDTO;
import com.profeel.monsterfac.member.command.application.dto.SignUpDTO;
import com.profeel.monsterfac.member.command.application.service.ReqMemberService;
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

@RestController
@RequestMapping("/auth")
public class MemberController {

    private final ReqMemberService memberService;

    public MemberController(ReqMemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO> signup(@RequestBody SignUpDTO signupinfo) {
        System.out.println("post 요청 옴");
        System.out.println("controller : "+ signupinfo);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED.value(), "회원 가입 성공", memberService.registMember(signupinfo)));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO logininfo) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK.value(), "로그인 성공", memberService.login(logininfo)));
    }

}