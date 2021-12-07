package front.baseCode.dao;

import java.util.List;

import front.baseCode.vo.BaseCodeVO;

public interface BaseCodeDAO {

	public List<BaseCodeVO> selectAreaAll(BaseCodeVO mvo);

	public List<BaseCodeVO> selectHobyyAll(BaseCodeVO mvo);

}
