package portal.repository;

import org.springframework.data.repository.CrudRepository;

import portal.domain.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
	UserInfo findById(int id);
    UserInfo findByUsername(String username);
}