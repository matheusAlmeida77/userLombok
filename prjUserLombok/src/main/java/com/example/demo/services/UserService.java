package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User saveUser(User User) {
		return userRepository.save(User);
	}
	
	public User getUserById(Long id) {
		Optional <User> User = userRepository.findById(id);
		return User.orElse(null);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public boolean deleteUserById(Long id) {
		Optional <User> existentUser = userRepository.findById(id);
		if(existentUser.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public User updateUser(Long id, User updatedUser) {
		Optional <User> existentUser = userRepository.findById(id);
		if (existentUser.isPresent()){
			return userRepository.save(updatedUser);
		} 
		return null;
	}
}