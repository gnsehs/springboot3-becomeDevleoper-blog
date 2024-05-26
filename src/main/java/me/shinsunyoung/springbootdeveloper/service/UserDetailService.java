package me.shinsunyoung.springbootdeveloper.service;


import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final field 생성자
@Service
public class UserDetailService implements UserDetailsService { // 스프링 시큐리티에서 사용자 정보를 가져오는 인터페이스

    private final UserRepository userRepository;
    @Override // 사용자 이름(email)으로 사용자의 정보를 가져오는 메서드
    public UserDetails loadUserByUsername(String email) { // 사용자 정보를 가져오는 로직
        return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException(email));
    }
}
