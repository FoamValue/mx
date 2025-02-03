package cn.chenxinjie.mx.sys.token.interceptor;

import cn.chenxinjie.mx.sys.token.exception.MxTokenErrorException;
import cn.chenxinjie.mx.sys.token.exception.MxTokenNullException;
import cn.chenxinjie.mx.sys.token.utils.MxTokenUtil;
import io.micrometer.common.util.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(1)
public class TokenFilter implements WebFilter {

    private final static List<String> ignoreUrls = new ArrayList<>();

    static {
        ignoreUrls.add("/hello");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        if (ignoreUrls.contains(url)) {
            return chain.filter(exchange);
        }
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (StringUtils.isBlank(token)) {
            return Mono.error(new MxTokenNullException("token is null"));
        }
        if (!MxTokenUtil.validateToken(token)) {
            return Mono.error(new MxTokenErrorException("token is not valid"));
        }
        return chain.filter(exchange);
    }
}
