package de.xddosapi.controller;

import de.xddosapi.XddosApi;
import de.xddosapi.repository.IXddos;
import de.xddosapi.utils.enums.Methods;
import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
@Getter
public class XddosController {

    private final XddosApi xddosApi = XddosApi.getInstance();
    private final IXddos iXddos;

    public XddosController(final IXddos iXddos) {
        this.iXddos = iXddos;
    }

    @CrossOrigin
    @RequestMapping("/info")
    public Object info() {
        return "Info";
    }

    @CrossOrigin
    @RequestMapping("attack")
    public Object startAttack(@RequestParam(required = false) final String token, @RequestParam(required = false) final String ip, @RequestParam(required = false) final String method, @RequestParam(required = false) final String protocol, @RequestParam(required = false) final String time, @RequestParam(required = false) final String waves) {
        if (token == null) return new HashMap<>() {{
            this.put("msg", "Missing RequestParam (token)");
        }};
        if (ip == null) return new HashMap<>() {{
            this.put("msg", "Missing RequestParam (ip)");
        }};
        if (method == null) return new HashMap<>() {{
            this.put("msg", "Missing RequestParam (method)");
        }};
        if (protocol == null) return new HashMap<>() {{
            this.put("msg", "Missing RequestParam (protocol)");
        }};
        if (time == null) return new HashMap<>() {{
            this.put("msg", "Missing RequestParam (time)");
        }};
        if (waves == null) return new HashMap<>() {{
            this.put("msg", "Missing RequestParam (waves)");
        }};

        try {
            final Methods method_ = Methods.valueOf(method.toUpperCase());
        } catch (final Exception e) {
            if (e.getMessage().contains("Methods"))
                return new HashMap<>() {{
                    this.put("msg", "Method '" + method + "' not found");
                    this.put("Available Methods", Methods.values());
                }};
        }

        return "Wow";
    }
}
