package com.example.packagetracker.controller;

import com.example.packagetracker.model.Package;
import com.example.packagetracker.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PackageController {

    @Autowired
    private PackageService packageService;

    /**
     * GET / - Display home page with package registration form and list of all packages
     * @param model the model to pass data to the view
     * @return the view name (index.html)
     */
    @GetMapping("/")
    public String home(Model model) {
        // Create a new empty package object for the form
        model.addAttribute("package", new Package());
        
        // Retrieve all packages from the database
        List<Package> packages = packageService.getAllPackages();
        model.addAttribute("packages", packages);
        
        return "index";
    }

    /**
     * POST /save - Save a new package to the database
     * @param pkg the package object from the form
     * @param redirectAttributes to pass messages back after redirect
     * @return redirect to home page
     */
    @PostMapping("/save")
    public String savePackage(@ModelAttribute("package") Package pkg, 
                              RedirectAttributes redirectAttributes) {
        try {
            // Validate input and save package through service layer
            packageService.savePackage(pkg);
            
            // Add success message
            redirectAttributes.addFlashAttribute("successMessage", 
                "Package registered successfully! Tracking ID: " + pkg.getTrackingId());
            
        } catch (IllegalArgumentException e) {
            // Add error message if validation fails
            redirectAttributes.addFlashAttribute("errorMessage", 
                "Error: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other unexpected errors
            redirectAttributes.addFlashAttribute("errorMessage", 
                "An unexpected error occurred. Please try again.");
        }
        
        // Redirect to home page to display updated list
        return "redirect:/";
    }
}
