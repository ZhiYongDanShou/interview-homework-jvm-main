package com.example.demo.controller;

import com.example.demo.service.WebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author LinHaojia
 * @create 2022-07-26 20:21
 */
@Controller
@CrossOrigin
public class TestController {
    @Resource
    private WebSocket webSocket;

    /**
     * 页面文件入口
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 发送场景模拟
     * @param msg
     * @return
     */
    @GetMapping("/test")
    @ResponseBody
    public String sendMessage(String msg){
        //如果访问的地址中msg参数不为空值，发送msg的值给前端
        if(!StringUtils.isEmpty(msg)){
            webSocket.sendMessage(msg);
            return "服务端发送消息msg："+msg;
        }
        return "服务端未发送消息msg："+msg;
    }
}
