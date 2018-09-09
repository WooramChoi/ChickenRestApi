package net.adonika.chicken.api.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import net.adonika.chicken.api.entity.User;
import net.adonika.chicken.api.entity.UserRole;

public class UserVO implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5263946237857370274L;

	public enum CdStatusUser {
		정상("0010"),
		휴면("0040"),
		정지("0099");
		private String code;
		CdStatusUser(String code){this.code = code;}
		public String getCode() {return this.code;}
	}
	
	private User user;
	
	public UserVO(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
		if(user.getUserRoles()!=null && !user.getUserRoles().isEmpty()){
			for(UserRole userRole: user.getUserRoles()) {
				auths.add(new SimpleGrantedAuthority(userRole.getStrAuth()));
			}
		}
		return auths;
	}

	@Override
	public String getPassword() {
		return user.getStrPass();
	}

	@Override
	public String getUsername() {
		return user.getStrId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !CdStatusUser.휴면.getCode().equals(user.getCdStatusUser());
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO 계정 잠김 여부
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 계정 비밀번호 만료 여부
		return true;
	}

	@Override
	public boolean isEnabled() {
		return CdStatusUser.정상.getCode().equals(user.getCdStatusUser());
	}

}
