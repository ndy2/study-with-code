package hello.servlet.web.servletmvc;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = ["/servlet-mvc/members/save"])
 class MvcMemberSaveServlet : HttpServlet() {

    private val memberRepository = MemberRepository.instance

    override fun service(request: HttpServletRequest, response :HttpServletResponse){

        val username = request.getParameter("username")
        val age = Integer.parseInt(request.getParameter("age"))

        val member = Member(username, age)
        memberRepository.save(member)

        //Model에 데이터를 보관한다
        request.setAttribute("member", member)

        val viewPath = "/WEB-INF/views/save-result.jsp"
        val dispatcher = request.getRequestDispatcher(viewPath)
        dispatcher.forward(request, response)
    }
}
