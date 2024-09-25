package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.SampleDto;


@Controller
@RequestMapping("/sample")
public class SampleController {
	
		@GetMapping("/ex1")	// /sample/ex1
		public void ex1() {
			// 리턴 타입이 void인 경우, url 경로와 일치하는 html 파일을 찾아 반환
			// 템플릿 경로: /templates/sample/ex1.html
		}
		
		// Model 은 화면에 값을 전달하는 객체
		@GetMapping("/ex2")
		public void ex2(Model model) {
			
			model.addAttribute("msg", "바이");
		}
	
		@GetMapping("/ex3")
		public void ex3(Model model) {

			model.addAttribute("msg1", "안녕하세요");
			model.addAttribute("msg2", "반가워요");
			// 모델 객체에 데이터를 여러번 담을 수 있다.
		}
	
		@GetMapping("/ex4")
		public void ex4(Model model) {
			
			SampleDto dto = new SampleDto(1, "hello", LocalDate.now());
			model.addAttribute("dto", dto);	// 화면에 객체 전달
			
		}
		
		// @GetMapping에 {} 를 사용하여 여러 URL을 처리할 수 있음.
		// 예 : /ex5 , /ex6 ... 요청이 들어오면 동일한 메소드가 호출된다.
		// URL은 다르지만 화면에 동일한 데이터를 전달
		
		@GetMapping({"/ex5" , "/ex6", "/ex7", "/ex8"})
		public void ex5(Model model) {
			
			List<SampleDto> list = new ArrayList<>();
			
			list.add(new SampleDto(1, "aaa", LocalDate.now()));
			list.add(new SampleDto(2, "bbb", LocalDate.now()));
			list.add(new SampleDto(3, "ccc", LocalDate.now()));
//			list.add(new SampleDto(4, "ddd", LocalDate.now()));
			
			model.addAttribute("list", list);
			
		}		
		
		@GetMapping("/ex9")
		public void ex9(Model model) {
			List<SampleDto> list = new ArrayList<>();
			
			for (int i = 1; i <= 20; i++) {
				list.add(new SampleDto(i, i+ "번" , LocalDate.now()));
			}
			model.addAttribute("list" , list);
		}
		
		@GetMapping("/ex10")
		public void ex10(Model model) {
			
			SampleDto dto = new SampleDto(1, "aaa", LocalDate.now());
			
			model.addAttribute("result", "success");	// 문자열 전달
			model.addAttribute("dto", dto);	// 객체 전달
			
		}
		
		@GetMapping("/ex11")
		public void ex11(Model model) {
			model.addAttribute("date", LocalDateTime.now());
		}
		

		
	
}
