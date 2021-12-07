package front.baseCode.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import front.baseCode.vo.BaseCodeVO;

public interface BaseCodeService {

	public List<BaseCodeVO> selectAreaAll(BaseCodeVO mvo);

	public List<BaseCodeVO> selectHobyyAll(BaseCodeVO mvo);

}
