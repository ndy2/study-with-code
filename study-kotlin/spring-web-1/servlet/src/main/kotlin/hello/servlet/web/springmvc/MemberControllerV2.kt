package hello.servlet.web.springmvc

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/springmvc/v2/members")
class MemberControllerV2 {

    private val memberRepository = MemberRepository.instance

    @GetMapping("/new-form")
    fun form(): String {
        return "new-form"
    }

    @PostMapping("/save")
    fun save(
        @RequestParam username: String,
        @RequestParam age: Int,
        model: Model
    ): String {
        val member = memberRepository.save(Member(username, age))
        model.addAttribute("member", member)
        return "save-result"
    }

    @GetMapping
    fun list(model: Model): String {
        model.addAttribute("members", memberRepository.findAll())
        return "members"
    }
}