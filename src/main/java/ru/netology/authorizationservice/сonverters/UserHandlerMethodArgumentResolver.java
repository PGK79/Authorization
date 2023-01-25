package ru.netology.authorizationservice.сonverters;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.authorizationservice.model.User;
public final class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(User.class);
    }
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        String user = nativeWebRequest.getParameter("user");
        String password = nativeWebRequest.getParameter("password");

        if (isNotSet(user)) {
            user = "VasyaPupkin";
        }

        if (isNotSet(password)) {
            password = "netology";
        }

        return new User(user, password);
    }

    //Хоть и валидируются, но на перспективу
    private boolean isNotSet(String value) {
        return value == null;
    }
}