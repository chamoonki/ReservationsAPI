package com.dev.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.user.UserPayment;
import com.dev.repository.user.UserPaymentRepository;
import com.dev.service.user.form.UserPaymentService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    @Autowired
    private UserPaymentRepository userPaymentRepository;
    
    /**
     * 사용자 결제 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<UserPayment> user_payments = new ArrayList<>();
			userPaymentRepository.findAll().forEach(e -> user_payments.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_payments);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 사용자 결제 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String user_payment_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			UserPayment user_payment = userPaymentRepository.findById(user_payment_id).orElseThrow(
					() -> new ResourceNotFoundException("UserPayment", "user_payment_id", user_payment_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_payment);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 사용자 결제 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String user_payment_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			userPaymentRepository.deleteById(user_payment_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_payment_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 사용자 결제 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String user_payment_id, UserPayment user_payment) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			UserPayment update_user_payment = userPaymentRepository.findById(user_payment_id).orElseThrow(
					() -> new ResourceNotFoundException("UserPayment", "user_payment_id", user_payment_id));
			
			update_user_payment.setCard(user_payment.getCard());
			update_user_payment.setCash(user_payment.getCash());
			update_user_payment.setPayment_instructor_id(user_payment.getPayment_instructor_id());
			update_user_payment.setMod_dd(new Date());
			update_user_payment.setMod_id(user_payment.getMod_id());
			update_user_payment.setPayment_status(user_payment.getPayment_status());
			update_user_payment.setPayment_type(user_payment.getPayment_type());
			update_user_payment.setPayment_type_id(user_payment.getPayment_type_id());
			update_user_payment.setUser_id(user_payment.getUser_id());
				
			userPaymentRepository.save(update_user_payment);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_payment_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 사용자 결제 추가
    * @return
    */
	@Override
	public ResponseResult save(UserPayment user_payment) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			userPaymentRepository.save(user_payment);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), user_payment);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
