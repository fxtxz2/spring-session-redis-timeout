package zyl.spring.web.session;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class Controller {
    @Resource
    private ObjectMapper jacksonObjectMapper;

    @GetMapping("/hello")
    public String get(HttpSession session) throws JsonProcessingException {
        String json = (String) session.getAttribute("userinfor");
        UserInfor userInfor = jacksonObjectMapper.readValue(json, UserInfor.class);
        return "hello " + userInfor.getUsername();
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(HttpSession session, @RequestBody UserInfor userInfor) throws JsonProcessingException {
        session.setAttribute("userinfor", jacksonObjectMapper.writeValueAsString(userInfor));

        return ResponseEntity.ok().build();
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "logout";
    }


}
