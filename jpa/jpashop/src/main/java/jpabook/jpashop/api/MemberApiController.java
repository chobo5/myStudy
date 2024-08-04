package jpabook.jpashop.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberApiController {
    private final MemberService memberService;

    @GetMapping("/api/v1/members")
    public List<Member> memberListV1() {
        return memberService.findMembers();
    }

    @GetMapping("/api/v2/members")
    public Result<List<MemberDto>> memberListV2() {
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> dtoList  = findMembers.stream()
                .map(member -> new MemberDto(member.getUsername()))
                .collect(Collectors.toList());
        return new Result<>(dtoList.size() ,dtoList);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class MemberDto {
        private String name;
    }

    @PostMapping("/api/v1/member/new")
    public CreateMemberResponse saveMember(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PostMapping("/api/v2/member/new")
    public CreateMemberResponse saveMember(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        log.info("request: " + request.toString());
        member.setUsername(request.getName());
        Long id =  memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PutMapping("/api/v2/member/{id}")
    public UpdateMemberResponse updateMember(@PathVariable Long id, @RequestBody @Valid UpdateMemberRequest request) {
        memberService.update(id, request.getName()); //여기서 Member를 반환하면 영속성이 끝난 객체이며, command성이 아닌 query성 메서드가 된다.
        Member findMember = memberService.findOne(id);
        return new UpdateMemberResponse(findMember.getId(), findMember.getUsername());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class CreateMemberRequest {
        @NotEmpty
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class CreateMemberResponse {
        private Long id;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class UpdateMemberRequest {
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class UpdateMemberResponse {
        private Long id;
        private String name;
    }










}
