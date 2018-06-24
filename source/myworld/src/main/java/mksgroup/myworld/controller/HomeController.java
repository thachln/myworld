/**
 * Copyright 2018, MKS GROUP.
 */
package mksgroup.myworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Đây là Controller xử lý trang chủ.
 * @author ThachLN
 */
@Controller
public class HomeController {

    /**
     * Xử lý request /.
     * @return view "home".
     */
    @GetMapping("/")
    public String goHome() {

        return "home";
    }
}
