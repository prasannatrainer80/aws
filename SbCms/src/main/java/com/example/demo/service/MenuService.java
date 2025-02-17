package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Menu;
import com.example.demo.repo.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	public List<Menu> showMenu() {
		return menuRepository.findAll();
	}
	
	public Menu searchMenu(int menuId) {
		return menuRepository.findById(menuId).get();
	}
}
