package com.M_Mureithi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
 
    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/contact")
    public String sendContactEmail(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String message
    ) {
        try {
            // ✅ This is where your SimpleMailMessage code goes:
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("your_email@outlook.com");  // your Outlook address
            mailMessage.setTo("your_email@outlook.com");    // where you want to receive it
            mailMessage.setSubject("New Contact Message from " + name);
            mailMessage.setText(
                    "Name: " + name + "\n" +
                    "Email: " + email + "\n" +
                    "Phone: " + phone + "\n\n" +
                    "Message:\n" + message
            );

            mailSender.send(mailMessage); // ✅ send the email

            // redirect back to the contact page with a success flag
            return "redirect:/contact?success";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/contact?error";
        }
    }

}
