package com.douzone.guestbook.dao.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.douzone.guestbook.dao.GuestbookDao;
import com.douzone.guestbook.vo.GuestbookVo;


public class GuestBookDaoTest {
	
		public static void main(String[] args) {
//			insertTest();
			selectTest();
		}
		public static void selectTest() {
			List<GuestbookVo> list = new GuestbookDao().findAll();
			for(GuestbookVo vo : list) {
				System.out.println(vo);
			}
		}
		public static void insertTest() {
			GuestbookVo vo = new GuestbookVo();
			Date date = new Date();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			vo.setName("박춘봉");
			vo.setPassword("4321");
			vo.setContents("춘봉박입니다.");
			vo.setRegDate(sdf.format(date));
			new GuestbookDao().insert(vo);
		}
	
}
