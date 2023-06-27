package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Human;
import com.example.demo.repository.HumanRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class HumanController {
 
	@Autowired
	HttpSession session;
	
	
	@Autowired
	Human human;

	@Autowired
	HumanRepository humanRepository;
	
	// ログイン画面を表示
		@GetMapping({ "/", "/login", "/logout"  })
		public String index(
				@RequestParam(name = "error", defaultValue = "") String error,
				Model m) {
			session.invalidate();
			
			// エラーパラメータのチェック
			if (error.equals("notLoggedIn")) {
				m.addAttribute("message", "ログインしてください");
			}

			return "login";
		}

		// ログインを実行
		@PostMapping("/login")
		public String login(
				@RequestParam("bango") String bango,
				@RequestParam("password") String password,
				Model m) {
			//ログインチェック
			Human human = null;
			
			Optional<Human> record = humanRepository.findByBangoAndPassword(bango, password);
			
			if (record.isEmpty() == false) {
				human = record.get();
			}
			
			// 名前が空の場合にエラーとする
			if (human == null) {
				m.addAttribute("message", "番号とパスワードが一致しませんでした");
				return "login";
			}

			// セッション管理されたアカウント情報にIDと名前をセット
			Integer bango1 = human.getBango();
			String namae = human.getNamae();
			
			human.setBango(bango1);
			human.setNamae(namae);

			// 「/items」へのリダイレクト
			return "redirect:/eat";
		}
		
		// お客様情報登録フォームを表示
		@GetMapping("/account")
		public String create() {
			return "accountForm";
		}
		
		// お客様情報登録
		@PostMapping("/account")
		public String store(
				@RequestParam(name="bango", required=false) Integer bango,
				@RequestParam(name="namae", required=false) String namae,
		
				@RequestParam(name="password", required=false) String password,
				Model m
		) {
			//エラー情報格納用配列
			List<String> errors = new ArrayList<>();
			
			if (bango == null || bango.equals("")) {
				errors.add("ユーザIDは必須です");
			}
			
			
			if (namae == null || namae.equals("")) {
				errors.add("名前は必須です");
			} else {
				List<Human> records = humanRepository.findByBango(bango);
				
				if (records.size() > 0) {
					errors.add("登録済みのユーザーIDです");
				}
			}
			
			if (password == null || password.equals("")) {
				errors.add("パスワードは必須です");
			}
			
			if (errors.size() > 0) {
				m.addAttribute("errors", errors);
				m.addAttribute("namae", namae);
				m.addAttribute("bango", bango);
				m.addAttribute("password", password);
				
				return "accountForm";
			}
			
			
			//Customerクラスの登録用のコンストラクタでインスタンスを生成
			Human human = new Human(bango,namae, password);
			
			//登録処理
			humanRepository.save(human);
			
			// 「/login」へのリダイレクト
			return "redirect:/login";
		}
	}

