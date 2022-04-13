package com.dev.service.center.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ResourceNotFoundException;
import com.dev.model.center.CenterPayment;
import com.dev.repository.center.CenterPaymentRepository;
import com.dev.service.center.form.CenterPaymentService;
import com.dev.utils.enums.EResponseCode;
import com.dev.utils.response.ResponseResult;

@Service
public class CenterPaymentServiceImpl implements CenterPaymentService {

    @Autowired
    private CenterPaymentRepository centerPaymentRepository;
    
    /**
     * 센터 결제 이력 전체 가져오기
     * @return
     */
	@Override
	public ResponseResult findAll() throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			List<CenterPayment> center_payments = new ArrayList<>();
			centerPaymentRepository.findAll().forEach(e -> center_payments.add(e));
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_payments);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}
	
	/**
    * 지정 아이디 센터 결제 이력 가져오기
    * @return
    */
	@Override
	public ResponseResult findById(String center_payment_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterPayment CenterPayment = centerPaymentRepository.findById(center_payment_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterPayment", "center_payment_id", center_payment_id));
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), CenterPayment);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		  
		return result;
	}

	/**
    * 센터 결제 이력 삭제
    * @return
    */
	@Override
	public ResponseResult deleteById(String center_payment_id) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			centerPaymentRepository.deleteById(center_payment_id);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_payment_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

	/**
    * 센터 결제 이력 수정
    * @return
    */
	@Override
	public ResponseResult updateById(String center_payment_id, CenterPayment center_payment) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			CenterPayment update_center_payment = centerPaymentRepository.findById(center_payment_id).orElseThrow(
					() -> new ResourceNotFoundException("CenterPayment", "center_payment_id", center_payment_id));
			
			update_center_payment.setCard(center_payment.getCard());
			update_center_payment.setCash(center_payment.getCash());
			update_center_payment.setCenter_id(center_payment.getCenter_id());
			update_center_payment.setManagement_grade(center_payment.getManagement_grade());
			update_center_payment.setMod_dd(new Date());
			update_center_payment.setMod_id(center_payment.getMod_id());
			update_center_payment.setPayment_type(center_payment.getPayment_type());
			
			centerPaymentRepository.save(update_center_payment);
			
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_payment_id);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}
		return result;
	}
	
	/**
    * 센터 결제 이력 추가
    * @return
    */
	@Override
	public ResponseResult save(CenterPayment center_payment) throws Exception {
		ResponseResult result = new ResponseResult();
		
		try{
			centerPaymentRepository.save(center_payment);
			result = new ResponseResult(EResponseCode.SUCCESS.getCode(), EResponseCode.SUCCESS.getMsg(), center_payment);
		}catch(Exception e){
			result = new ResponseResult(EResponseCode.DB_EXCTION.getCode(), e.getMessage(), null);
		    throw new Exception("DB exception", e);
		}

		return result;
	}

}
