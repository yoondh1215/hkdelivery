package hkdelivery.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkdelivery.domain.DeliveryDTO;

@Repository
public class DeliveryRepository {

	@Autowired
	SqlSession sqlSession;
	
	//mapper xml의 namespace와 동일
	String namespace = "DeliveryRepositorySql";
	String statement;
	
	public Integer deliveryInsert(DeliveryDTO deliveryDTO) {
		statement = namespace + ".deliveryInsert";
		return sqlSession.insert(statement, deliveryDTO);
		//이는 곧 return SqlSession.insert(DeliveryRepositorySql.deliveryDTO); 와도 같다.
	};
	
	public Integer deliveryDelete(String purchaseNum) {
		statement = namespace + ".deliveryDelete";
		return sqlSession.delete("statement", purchaseNum);
	}
	
}
