package com.willingtogohome.gymga.login.auth.model;

import com.willingtogohome.gymga.login.common.UserRole;
import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthDetails implements UserDetails {

    private LoginDTO loginDTO;

    public AuthDetails(){}

    public AuthDetails(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    /* 권한 정보를 반환하는 메소드이다.
     * UsernamePasswordAuthenticationToken에 사용자의 권한 정보를 넣을 때 사용한다. */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        loginDTO.getRole().forEach(role -> authorities.add(() -> role));
        return authorities;
    }

    /* 사용자의 비밀번호를 반환하는 메소드이다.
     * UsernamePasswordAuthenticationToken과 사용자의 비밀번호를 비교할 때 사용한다. */
    @Override
    public String getPassword() {
        return loginDTO.getUserPwd();
    }

    /* 사용자의 아이디를 반환하는 메소드이다.
     * UsernamePasswordAuthenticationToken과 사용자의 아이디를 비교할 때 사용한다. */
    @Override
    public String getUsername() {
        return loginDTO.getUserId();
    }

    /* 계정 만료 여부를 표현하는 메소드로 false이면 해당 계정을 사용할 수 없다. */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /* 잠겨있는 계정을 확인하는 메소드로 false 이면 해당 계정을 사용할 수 없다.
     * 비밀번호 반복 실패로 일시적인 계정 lock인 경우 혹은 오랜 시간 비 접속으로 휴먼 처리 */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /* 탈퇴 계정 여부를 표현하는 메소드 false 면 해당 계정을 사용할 수 없다.
     * 보통 데이터 삭제는 즉시 하는 것이 아닌 일정 기간 보관 후 삭제한다. */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /* 계정 비활성화 여부로 사용자가 사용할 수 없는 상태
     * false이면 계정을 사용할 수 없다. 삭제 처리 같은 경우 */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
