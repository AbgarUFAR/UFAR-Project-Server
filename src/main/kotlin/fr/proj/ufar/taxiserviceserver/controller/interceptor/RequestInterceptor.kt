package fr.proj.ufar.taxiserviceserver.controller.interceptor

import fr.proj.ufar.taxiserviceserver.service.AdminService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class RequestInterceptor(private val adminService: AdminService) : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        adminService.getAdminByKey(request.getHeader("x-api-key"))
        return true
    }
}
