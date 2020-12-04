package dao;

import java.util.ArrayList;

public class userInfoList {
	ArrayList<UserInfoDao> userInfoList = new ArrayList<UserInfoDao>();

	public ArrayList<UserInfoDao> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(ArrayList<UserInfoDao> userInfoList) {
		this.userInfoList = userInfoList;
	}


}
