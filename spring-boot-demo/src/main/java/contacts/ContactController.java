package contacts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author hph
 */
@Controller
@RequestMapping("/")
public class ContactController {

    @Resource
    private ContactRepository contactRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String,Object> model) {
        List<Contact> contactList = contactRepository.findAll();
        model.put("contacts", contactList);
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact) {
        contactRepository.save(contact);
        return "redirect:/";
    }
}
