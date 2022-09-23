package hello.servlet.web.springmvc

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/springmvc/v1/members")
class MemberControllerV1 {

    private val memberRepository = MemberRepository.instance

    @GetMapping("/new-form")
    fun form(): ModelAndView {
        return ModelAndView("new-form")
    }

    @PostMapping("/save")
    fun save(request: HttpServletRequest): ModelAndView {
        val member = memberRepository.save(
            Member(
                request.getParameter("username"),
                request.getParameter("age").toInt()
            )
        )

        val mv = ModelAndView("save-result")
        mv.addObject("member", member)
        return mv
    }

    @GetMapping
    fun list(): ModelAndView {
        val mv = ModelAndView("members")
        mv.addObject("members", memberRepository.findAll())
        return mv
    }
}