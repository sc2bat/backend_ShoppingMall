package com.groupc.controller;

import com.groupc.controller.action.Action;
import com.groupc.controller.action.CancelListAction;
import com.groupc.controller.action.CancelNOrderAction;
import com.groupc.controller.action.CancelOrderAction;
import com.groupc.controller.action.CartDeleteAction;
import com.groupc.controller.action.CartInsertAction;
import com.groupc.controller.action.CartInsertMultiAction;
import com.groupc.controller.action.CartListAction;
import com.groupc.controller.action.ContractAction;
import com.groupc.controller.action.EditFormAction;
import com.groupc.controller.action.FindIdAction;
import com.groupc.controller.action.FindNZipNumAction;
import com.groupc.controller.action.FindPwdAction;
import com.groupc.controller.action.FindZipNumAction;
import com.groupc.controller.action.IdCheckFormAction;
import com.groupc.controller.action.IdResultAction;
import com.groupc.controller.action.IndexAction;
import com.groupc.controller.action.JoinAction;
import com.groupc.controller.action.LoginAction;
import com.groupc.controller.action.LoginFormAction;
import com.groupc.controller.action.LogoutAction;
import com.groupc.controller.action.MemberUpdateAction;
import com.groupc.controller.action.MenuAction;
import com.groupc.controller.action.MypageAction;
import com.groupc.controller.action.NOrderListAction;
import com.groupc.controller.action.NOrderResultAction;
import com.groupc.controller.action.NmemberBuyFormAction;
import com.groupc.controller.action.NoticeListAction;
import com.groupc.controller.action.NoticeViewAction;
import com.groupc.controller.action.OrderAllAction;
import com.groupc.controller.action.OrderDetailAction;
import com.groupc.controller.action.OrderInsertAction;
import com.groupc.controller.action.OrderListAction;
import com.groupc.controller.action.OrderOneAction;
import com.groupc.controller.action.OrderninsertAction;
import com.groupc.controller.action.ProSideAction;
import com.groupc.controller.action.ProductDetailAction;
import com.groupc.controller.action.PwdResultAction;
import com.groupc.controller.action.QnaListAction;
import com.groupc.controller.action.QnaViewAction;
import com.groupc.controller.action.QnaWriteAction;
import com.groupc.controller.action.QnaWriteFormAction;
import com.groupc.controller.action.ReviewListAction;
import com.groupc.controller.action.ReviewViewAction;
import com.groupc.controller.action.SearchingAction;
import com.groupc.controller.action.TrackingAction;
import com.groupc.controller.action.WithdrawalAction;
import com.groupc.controller.action.WriteReviewAction;
import com.groupc.controller.action.joinFormAction;
import com.groupc.controller.action.nonmemberLoginAction;
import com.groupc.controller.admin_action.AdminAction;
import com.groupc.controller.admin_action.AdminLoginAction;
import com.groupc.controller.admin_action.AdminLogoutAction;
import com.groupc.controller.admin_action.AdminMainAction;
import com.groupc.controller.admin_action.AdminMemberListAction;
import com.groupc.controller.admin_action.AdminMemberUpdateAction;
import com.groupc.controller.admin_action.AdminMemberUpdateFormAction;
import com.groupc.controller.admin_action.AdminMemberUpdateUseynAction;
import com.groupc.controller.admin_action.AdminMemberUseNListAction;
import com.groupc.controller.admin_action.AdminNoticeDetailAction;
import com.groupc.controller.admin_action.AdminNoticeListAction;
import com.groupc.controller.admin_action.AdminNoticeWriteAction;
import com.groupc.controller.admin_action.AdminNoticeWriteFormAction;
import com.groupc.controller.admin_action.AdminProductBestListAction;
import com.groupc.controller.admin_action.AdminProductDeleteAction;
import com.groupc.controller.admin_action.AdminProductDetailAction;
import com.groupc.controller.admin_action.AdminProductListAction;
import com.groupc.controller.admin_action.AdminProductUpdateAction;
import com.groupc.controller.admin_action.AdminProductUpdateBestynAction;
import com.groupc.controller.admin_action.AdminProductUpdateFormAction;
import com.groupc.controller.admin_action.AdminProductUploadAction;
import com.groupc.controller.admin_action.AdminProductUploadFormAction;
import com.groupc.controller.admin_action.AdminQnaDetailAction;
import com.groupc.controller.admin_action.AdminQnaListAction;

public class ActionFactory {
	private ActionFactory () {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	public Action getAction(String cmd) {
		Action ac = null;
		/* 220222 콩콩 */
		if(cmd.equals("index")) {ac = new IndexAction();}
		
		
		// login
		else if( cmd.equals("loginForm")) { ac = new LoginFormAction();}
		else if( cmd.equals("login")) { ac = new LoginAction();}
		else if( cmd.equals("logout") ) ac = new LogoutAction();
		
		// nonmember
		else if( cmd.equals("nonmemberlogin")) { ac = new nonmemberLoginAction();}
		
		// mypage
		else if( cmd.equals("mypage")) { ac = new MypageAction();}
		// edit
		else if(cmd.equals("editForm"))ac = new EditFormAction();
		else if( cmd.equals("memberUpdate") ) ac = new MemberUpdateAction();		
		// withdrawal(회원탈퇴)
		else if(cmd.equals("withdrawal"))ac = new WithdrawalAction();
		

		// product
		else if(cmd.equals("productDetail")) ac = new ProductDetailAction();
		else if(cmd.equals("menu"))ac = new MenuAction(); // top_menu action
		else if(cmd.equals("proSide"))ac = new ProSideAction(); // prodcut side_menu action
		else if(cmd.equals("searching"))ac = new SearchingAction(); // index.jsp searching -> view product
		else if(cmd.equals("writeReview")) ac = new WriteReviewAction();
		//review
		else if(cmd.equals("reviewList")) ac = new ReviewListAction();
		else if(cmd.equals("reviewView")) ac = new ReviewViewAction();
		
		//join
		else if(cmd.equals("contract")) {ac = new ContractAction();}
		else if(cmd.equals("joinForm")) {ac = new joinFormAction();}
		else if(cmd.equals("join")) {ac = new JoinAction();}
		else if(cmd.equals("findZipNum")) ac = new FindZipNumAction();

		// CheckForm
		else if(cmd.equals("idCheckForm")) ac = new IdCheckFormAction();
		else if(cmd.equals("findId")) ac = new FindIdAction();
		else if(cmd.equals("findPwd")) ac = new FindPwdAction();
		else if(cmd.equals("idResult")) ac = new IdResultAction();
		else if(cmd.equals("pwdResult")) ac = new PwdResultAction();
		
		// cart
		else if(cmd.equals("cartList")) {ac = new CartListAction();}
		else if(cmd.equals("cartInsert")) ac = new CartInsertAction();
		else if(cmd.equals("cartDelete") ) ac = new CartDeleteAction();
		else if(cmd.equals("cartInsertMulti") ) ac = new CartInsertMultiAction();
		
		// order
		else if(cmd.equals("orderList")) {ac = new OrderListAction();}
		else if(cmd.equals("orderInsert") ) ac = new OrderInsertAction();
		else if(cmd.equals("orderAll")) ac = new OrderAllAction();
		else if(cmd.equals("orderDetail")) ac = new OrderDetailAction();
		else if(cmd.equals("orderOne")) ac = new OrderOneAction();

		// tracking(배송 조회)
		else if(cmd.equals("tracking"))ac = new TrackingAction();
		else if(cmd.equals("cancelList"))ac = new CancelListAction();
		else if(cmd.equals("cancelOrder"))ac = new CancelOrderAction();
		else if(cmd.equals("cancelNOrder"))ac = new CancelNOrderAction();
		
		// qna
		else if(cmd.equals("qnaList")) {ac = new QnaListAction();}
		else if(cmd.equals("qnaView") ) ac = new QnaViewAction();
		else if(cmd.equals("qnaWrite") ) ac = new QnaWriteAction();
		else if(cmd.equals("qnaWriteForm") ) ac = new QnaWriteFormAction();
		else if(cmd.equals("noticeList")) ac = new NoticeListAction();
		else if(cmd.equals("noticeView")) ac = new NoticeViewAction();
		
		
		// nmember
		else if(cmd.equals("nmemberBuyForm"))ac = new NmemberBuyFormAction();
		else if(cmd.equals("orderninsert"))ac = new OrderninsertAction();
		else if(cmd.equals("nOrderResult"))ac = new NOrderResultAction();
		else if(cmd.equals("findNZipNum"))ac = new FindNZipNumAction();
		else if(cmd.equals("nOrderList"))ac = new NOrderListAction();
		
		
		// admin
		else if(cmd.equals("admin"))ac = new AdminAction();
		else if(cmd.equals("adminLogin"))ac = new AdminLoginAction();
		else if(cmd.equals("adminLogout"))ac = new AdminLogoutAction();
		
		// admin product
		else if(cmd.equals("adminMain"))ac = new AdminMainAction();
		else if(cmd.equals("adminProductList"))ac = new AdminProductListAction();
		else if(cmd.equals("adminProductDetail"))ac = new AdminProductDetailAction();
		else if(cmd.equals("adminProductUpdateForm"))ac = new AdminProductUpdateFormAction();
		else if(cmd.equals("adminProductUpdate"))ac = new AdminProductUpdateAction();
		else if(cmd.equals("adminProductUploadForm"))ac = new AdminProductUploadFormAction();
		else if(cmd.equals("adminProductUpload"))ac = new AdminProductUploadAction();
		else if(cmd.equals("adminProductBestList"))ac = new AdminProductBestListAction();
		else if(cmd.equals("adminProductDelete"))ac = new AdminProductDeleteAction();
		else if(cmd.equals("adminQnaList")) ac = new AdminQnaListAction();
		else if(cmd.equals("adminQnaDetail")) ac = new AdminQnaDetailAction();
		
		// 220222
		else if(cmd.equals("adminProductUpdateBestyn"))ac = new AdminProductUpdateBestynAction();
		else if(cmd.equals("adminMemberList"))ac = new AdminMemberListAction();
		else if(cmd.equals("adminMemberUseNList"))ac = new AdminMemberUseNListAction();
		else if(cmd.equals("adminMemberUpdateUseyn"))ac = new AdminMemberUpdateUseynAction();
		else if(cmd.equals("adminMemberUpdateForm"))ac = new AdminMemberUpdateFormAction();
		else if(cmd.equals("adminMemberUpdate"))ac = new AdminMemberUpdateAction();
		//
		else if(cmd.equals("adminNoticeList")) ac = new AdminNoticeListAction();
		else if(cmd.equals("adminNoticeDetail")) ac = new AdminNoticeDetailAction();
		else if(cmd.equals("adminNoticeWrite")) ac = new AdminNoticeWriteAction();
		else if(cmd.equals("adminNoticeWriteForm")) ac = new AdminNoticeWriteFormAction();
		
		/**/
		
		return ac;
	}
	
	

}
