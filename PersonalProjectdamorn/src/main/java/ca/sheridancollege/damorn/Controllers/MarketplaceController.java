package ca.sheridancollege.damorn.Controllers;

import ca.sheridancollege.damorn.models.Message;
import ca.sheridancollege.damorn.models.Product;
import ca.sheridancollege.damorn.repositories.MessageRepository;
import ca.sheridancollege.damorn.repositories.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MarketplaceController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private MessageRepository messageRepo;

    @GetMapping("/")
    public String listProducts(Model model) {
        model.addAttribute("products", productRepo.getAllProducts());
        return "index";
    }

    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable Long id,
                                 @RequestParam(required = false) String success,
                                 Model model) {
        Product product = productRepo.getProductById(id);
        List<Message> messages = messageRepo.getMessagesByProductId(id);
        model.addAttribute("product", product);
        model.addAttribute("messages", messages);

        if ("true".equals(success)) {
            model.addAttribute("successMessage", "✅ Message sent successfully!");
        }

        return "productDetails";
    }

    @GetMapping("/newProduct")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product) {
        if (product.getId() == null) {
            productRepo.addProduct(product);
        } else {
            productRepo.updateProduct(product);
        }
        return "redirect:/";
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        Product product = productRepo.getProductById(id);
        model.addAttribute("product", product);
        return "productForm";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepo.deleteProduct(id);
        return "redirect:/";
    }

    @PostMapping("/sendMessage/{productId}")
    public String sendMessage(@PathVariable Long productId,
                              @RequestParam String senderName,
                              @RequestParam String content) {
        try {
            Message message = new Message();
            message.setProductId(productId);
            message.setSenderName(senderName);
            message.setContent(content);
            message.setSentTime(LocalDateTime.now());

            messageRepo.saveMessage(message);

            return "redirect:/product/" + productId + "?success=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/product/" + productId + "?success=false";
        }
    }

    @GetMapping("/test")
    public String test(Model model, HttpSession session) {
        session.setAttribute("sessionId", session.getId());
        session.setAttribute("myTest", session.isNew() ? "New Session" : "Welcome Back");
        return "test";
    }

    @GetMapping("/retest")
    public String invalidateSession(HttpSession session) {
        session.invalidate();
        return "test";
    }
}
