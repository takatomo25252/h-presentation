package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Human;
import com.example.demo.repository.HumanRepository;

@Controller
public class HumanController {

	@Autowired
	Human human;

	@Autowired
	HumanRepository humanRepository;
	
	// ログイン画面を表示
		@GetMapping({ "/", "/login" })
		public String index(
				@RequestParam(name = "error", defaultValue = "") String error,
				Model m) {
		
			
			// エラーパラメータのチェック
			if (error.equals("notLoggedIn")) {
				model.addAttribute("message", "ログインしてください");
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
			
			Optional<Huamn> record = humanRepository.findByBangoAndPassword(bango, password);
			
			if (record.isEmpty() == false) {
				human = record.get();
			}
			
			// 名前が空の場合にエラーとする
			if (human == null) {
				m.addAttribute("message", "番号とパスワードが一致しませんでした");
				return "login";
			}

			// セッション管理されたアカウント情報にIDと名前をセット
			Integer bango = human.getBango();
			String namae = human.getNamae();
			
			account.setBango(bango);
			account.setNamae(namae);

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
				errors.add("名前は3必須です");
			}
			
			if (address == null || address.equals("")) {
				errors.add("住所は必須です");
			}
			
			if (tel == null || tel.equals("")) {
				errors.add("電話番号は必須です");
			}
			
			if (email == null || email.equals("")) {
				errors.add("メールアドレスは必須です");
			} else {
				List<Customer> records = customerRepository.findByEmail(email);
				
				if (records.size() > 0) {
					errors.add("登録済みのメールアドレスです");
				}
			}
			
			if (password == null || password.equals("")) {
				errors.add("パスワードは必須です");
			}
			
			if (errors.size() > 0) {
				model.addAttribute("errors", errors);
				model.addAttribute("name", name);
				model.addAttribute("address", address);
				model.addAttribute("tel", tel);
				model.addAttribute("email", email);
				model.addAttribute("password", password);
				
				return "accountForm";
			}
			
			
			//Customerクラスの登録用のコンストラクタでインスタンスを生成
			Customer customer = new Customer(name, address, tel, email, password);
			
			//登録処理
			customerRepository.save(customer);
			
			// 「/login」へのリダイレクト
			return "redirect:/login";
		}
	}

