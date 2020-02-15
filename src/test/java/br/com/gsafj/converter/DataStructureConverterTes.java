package br.com.gsafj.converter;

import br.com.gsafj.user.UserMock;
import br.com.gsafj.user.UserModel;
import br.com.gsafj.user.UserVO;
import br.com.gsafj.util.DataStructureConverter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DataStructureConverterTes {

  private UserMock userMock;

  @Before
  public void setup() {
    this.userMock = new UserMock();
  }

  @Test
  public void parseUserVOToModel() {
    final UserVO userVO = userMock.getUserVOMock();
    final UserModel userModel = DataStructureConverter
        .parseObject(userVO, UserModel.class);

    Assert.assertEquals(userVO.getId(), userModel.getId());
    Assert.assertEquals(userVO.getFirstName(), userModel.getFirstName());
    Assert.assertEquals(userVO.getLastName(), userModel.getLastName());
    Assert.assertEquals(userVO.getPassword(), userModel.getPassword());
  }


  @Test
  public void parseUserLisVOToModel() {
    final int listLength = 10;
    final List<UserVO> userVOMockList =
        this.userMock.getUserVOMockList(listLength);

    final List<UserModel> userModelList =
        DataStructureConverter.parseAll(userVOMockList, UserModel.class);


    for (int i = 0; i < listLength; i++) {
      final UserVO userVO = userVOMockList.get(i);
      final UserModel userModel = userModelList.get(i);

      Assert.assertEquals(userModel.getId(), userVO.getId());
      Assert.assertEquals(userModel.getFirstName(), userVO.getFirstName());
      Assert.assertEquals(userModel.getLastName(), userVO.getLastName());
      Assert.assertEquals(userModel.getPassword(), userVO.getPassword());
    }
  }




  @Test
  public void parseUserModelToVO() {
    final UserModel userModel = userMock.getUserModelMock();
    final UserVO userVO = DataStructureConverter
        .parseObject(userModel, UserVO.class);

    Assert.assertEquals(userModel.getId(), userVO.getId());
    Assert.assertEquals(userModel.getFirstName(), userVO.getFirstName());
    Assert.assertEquals(userModel.getLastName(), userVO.getLastName());
    Assert.assertEquals(userModel.getPassword(), userVO.getPassword());
  }

  @Test
  public void parseUserListModelToVO() {
    final int listLength = 10;
    final List<UserModel> userModelList =
        this.userMock.getUserModelMockList(listLength);

    final List<UserVO> userVOList =
        DataStructureConverter.parseAll(userModelList, UserVO.class);


    for (int i = 0; i < listLength; i++) {
      final UserModel userModel = userModelList.get(i);
      final UserVO userVO = userVOList.get(i);

      Assert.assertEquals(userModel.getId(), userVO.getId());
      Assert.assertEquals(userModel.getFirstName(), userVO.getFirstName());
      Assert.assertEquals(userModel.getLastName(), userVO.getLastName());
      Assert.assertEquals(userModel.getPassword(), userVO.getPassword());
    }
  }





}
