package br.com.gsafj.user;

import java.util.ArrayList;
import java.util.List;

public class UserMock {

  private static long userVOID = 1L;
  private static long userModelID = 1L;


  public final UserVO getUserVOMock() {
    return this.createUserVO();
  }

  public final List<UserVO> getUserVOMockList(final int length) {
    final List<UserVO> userVOList = new ArrayList<>(length);

    for (int i = 0; i < length; i++) {
      userVOList.add(createUserVO());
    }

    return userVOList;
  }

  public final UserModel getUserModelMock() {
    return createUserModel();
  }

  public final List<UserModel> getUserModelMockList(final int length) {
    final List<UserModel> userModels = new ArrayList<>(length);

    for (int i = 0; i < length; i++) {
      userModels.add(createUserModel());
    }

    return userModels;
  }


  private UserVO createUserVO() {
    final UserVO userVO = new UserVO();

    userVO.setId(userVOID++);
    userVO.setFirstName("First Name " + userVO.getId());
    userVO.setLastName("Last Name " + userVO.getId());
    userVO.setPassword("Password " + userVO.getId());

    return userVO;
  }


  private UserModel createUserModel() {
    final UserModel userModel = new UserModel();

    userModel.setId(userModelID++);
    userModel.setFirstName("First Name " + userModel.getId());
    userModel.setLastName("Last Name " + userModel.getId());
    userModel.setPassword("Password " + userModel.getId());

    return userModel;
  }


}
