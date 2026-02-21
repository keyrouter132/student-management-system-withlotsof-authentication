package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import com.student.model.AuditLog;
import com.student.repository.AuditLogRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import com.student.model.StudentRegistration;

import com.student.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class StudentController {
	
   	
   	
	@Autowired
	StudentRepository srepo;
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView();	
		
			mv.setViewName("Home");
		
		return mv;
	}
	
	
	@RequestMapping("/login")
	public ModelAndView login() {
	    return new ModelAndView("login");
	}
	
	
	@RequestMapping("/addStudent")
	public ModelAndView addstudent()
	{
		ModelAndView mv = new ModelAndView("addStudent");	
			
		return mv;
	}
	
	
	@PostMapping("/addStud")
	public ModelAndView addStud(@Valid StudentRegistration sreg,
            BindingResult result,
            HttpServletRequest request) {

	    ModelAndView mv = new ModelAndView("addStudent");

	    // 🔹 Log attempt
	    logger.info("Attempt to add student with ID: {}", sreg.getSno());

	    if (result.hasErrors()) {

	        // 🔹 Log validation failure
	        logger.warn("Validation failed while adding student with ID: {}", sreg.getSno());

	        mv.addObject("PrintSwal",
	            "<script>swal('Invalid input detected');</script>");
	        return mv;
	    }

	    if (srepo.existsById(sreg.getSno())) {

	        // 🔹 Log duplicate attempt
	        logger.warn("Duplicate student ID attempt: {}", sreg.getSno());

	        mv.addObject("PrintSwal",
	            "<script>swal('User Already Exists');</script>");

	    } else {

	        srepo.save(sreg);

	        // 🔹 Log success
	        logger.info("Student successfully added with ID: {}", sreg.getSno());
	        
	        logAction("ADD STUDENT ID: " + sreg.getSno(), request);
	        mv.addObject("PrintSwal",
	            "<script>swal('Registration Successful');</script>");
	    }

	    return mv;
	}
	
	
	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent()
	{
		ModelAndView mv = new ModelAndView("deleteStudent");	
		
		return mv;
	}
	
	@PostMapping("/delStud")
	public ModelAndView delStud(int studNo,
	                            HttpServletRequest request) {

	    ModelAndView mv = new ModelAndView("deleteStudent");

	    logger.info("Attempt to delete student with ID: {}", studNo);

	    if (!srepo.existsById(studNo)) {

	        logger.warn("Delete attempt on non-existing student ID: {}", studNo);

	        mv.addObject("PrintSwal",
	            "<script>swal('Sorry Record Not Found');</script>");

	        return mv;
	    }

	    srepo.deleteById(studNo);

	    logAction("DELETE STUDENT ID: " + studNo, request);

	    logger.info("Student successfully deleted with ID: {}", studNo);

	    mv.addObject("PrintSwal",
	        "<script>swal('Record Deleted Successfully');</script>");

	    return mv;
	}
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent()
	{
		ModelAndView mv = new ModelAndView("searchStudent");	
		
		return mv;
	}
	
	@RequestMapping("/searStud")
	public ModelAndView searStud(int studNo) {

	    ModelAndView mv = new ModelAndView("searchStudent");

	    String print = "<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";

	    Optional<StudentRegistration> sreg = srepo.findById(studNo);

	    if (sreg.isPresent()) {

	        StudentRegistration student = sreg.get();

	        // Directly pass object to updateView
	        return updateView(student);

	    } else {

	        print = print + "<script>swal('Sorry Record Not Found');</script>";
	        mv.addObject("PrintSwal", print);
	    }

	    return mv;
	}
	
	@RequestMapping("/updateView")
	public ModelAndView updateView(StudentRegistration sreg) {

	    ModelAndView mv = new ModelAndView("updateStudent");

	    mv.addObject("Sno", sreg.getSno());
	    mv.addObject("Sname", sreg.getName());

	    // Force ISO format yyyy-MM-dd
	    mv.addObject("SDOB", sreg.getDob().toString());
	    mv.addObject("SDOJ", sreg.getDoj().toString());

	    return mv;
	}
	
	@PostMapping("/updateStud")
	public ModelAndView update(@Valid StudentRegistration sreg,
	                           BindingResult result,
	                           HttpServletRequest request) {

	    ModelAndView mv = new ModelAndView("searchStudent");

	    logger.info("Attempt to update student with ID: {}", sreg.getSno());

	    if (result.hasErrors()) {

	        logger.warn("Validation failed while updating student with ID: {}", sreg.getSno());

	        mv.addObject("PrintSwal",
	            "<script>swal('Invalid input detected');</script>");
	        return mv;
	    }

	    if (!srepo.existsById(sreg.getSno())) {

	        logger.warn("Update attempt on non-existing student ID: {}", sreg.getSno());

	        mv.addObject("PrintSwal",
	            "<script>swal('Student Not Found');</script>");
	        return mv;
	    }

	    srepo.save(sreg);

	    logAction("UPDATE STUDENT ID: " + sreg.getSno(), request);

	    logger.info("Student successfully updated with ID: {}", sreg.getSno());

	    mv.addObject("PrintSwal",
	        "<script>swal('Record Updated Successfully');</script>");

	    return mv;
	}
	
	@RequestMapping("/accessDenied")
	public String accessDenied() {
	    return "accessDenied";
	}
	
	@Autowired
	private AuditLogRepository auditLogRepository;
	
	private void logAction(String action, HttpServletRequest request) {

	    String username = SecurityContextHolder
	            .getContext()
	            .getAuthentication()
	            .getName();

	    AuditLog log = new AuditLog();
	    log.setUsername(username);
	    log.setAction(action);
	    log.setIpAddress(request.getRemoteAddr());
	    log.setTimestamp(LocalDateTime.now());

	    auditLogRepository.save(log);
	}
	
	@RequestMapping("/viewAllStudent")
	public ModelAndView viewAllStudent() {

	    ModelAndView mv = new ModelAndView("viewAllStudent");

	    List<StudentRegistration> s1 = srepo.findAll();

	    if (s1.isEmpty()) {
	        mv.addObject("message", "No Data Found");
	    } else {
	        mv.addObject("students", s1);
	    }

	    return mv;
	}


}		


