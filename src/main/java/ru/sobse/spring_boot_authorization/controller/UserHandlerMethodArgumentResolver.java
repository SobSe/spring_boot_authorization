package ru.sobse.spring_boot_authorization.controller;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.sobse.spring_boot_authorization.model.User;

public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter
            , ModelAndViewContainer mavContainer
            , NativeWebRequest webRequest
            , WebDataBinderFactory binderFactory) throws Exception {
        String name = webRequest.getParameter("user");
        String password = webRequest.getParameter("password");
        return new User(name, password);
    }
}
