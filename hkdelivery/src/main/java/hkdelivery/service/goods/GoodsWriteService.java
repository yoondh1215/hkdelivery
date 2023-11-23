package hkdelivery.service.goods;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hkdelivery.command.GoodsCommand;
import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.GoodsDTO;
import hkdelivery.mapper.GoodsMapper;
import hkdelivery.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsWriteService {

	@Autowired
	ShopMapper shopMapper;
	@Autowired
	GoodsMapper goodsMapper;
	public void execute (GoodsCommand goodsCommand, HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		dto.setDeliveryCost(goodsCommand.getDeliveryCost());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		//우선은 이미지 없이 텍스트만 먼저 구현
		
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		//auth에는 id pw grade 뿐이라 shopNum을 가져오기 위해 shopMapper에 추가.
		String shopNum = shopMapper.getShopNum(auth.getId());
		dto.setShopNum(shopNum);
		
		//이미지 파일 구현
		//파일이 저장될 경로 가져오기 + src/main/resource/static 밑에 upload 폴더를 생성해 저장하겠음. 
		URL resource = getClass().getClassLoader().getResource("static/upload");
		String fileDir = resource.getFile();
		
		//대문이미지
		MultipartFile mf = goodsCommand.getGoodsMain(); //command에서 이미지객체 가져옴
		String originalFile = mf.getOriginalFilename(); //원본 이미지파일 이름 가져옴
		String extension = originalFile.substring(originalFile.lastIndexOf(".")); //파일명에서 확장자만 추출
		String storeName = UUID.randomUUID().toString().replace("-", ""); //UUID로 임의의 이름 부여. "-"는 못들어감.
		String storeFileName = storeName + extension; //새로운 파일명 만들어주기
		//파일은 새로운 파일명으로 저장한다.
		
		//static/upload에 새로운 파일명으로 저장하겠음.
		File file = new File(fileDir + "/" + storeFileName);
		try {
			mf.transferTo(file);
		} catch (Exception e){
			e.printStackTrace();
		}
		//파일을 저장했으니 도메인 dto에 파일명 저장
		dto.setGoodsMain(storeFileName); // static/upload에 저장된 이름
		dto.setGoodsMainOrg(originalFile); // upload할때 사용한 원래 이름
		
		//multiple 로 가져온 파일은 필수가 아니므로 먼저 파일이 있는지 확인
		if (!goodsCommand.getGoodsImage()[0].getOriginalFilename().isEmpty()) {
			String originalTotal = "";
			String storeTotal = "";
			//파일이 여러 개 이므로 전에 작성한 코드 재활용해 반복
			for (MultipartFile mtf : goodsCommand.getGoodsImage()) {
				originalFile = mf.getOriginalFilename(); //원본 이미지파일 이름 가져옴
				extension = originalFile.substring(originalFile.lastIndexOf(".")); //파일명에서 확장자만 추출
				storeName = UUID.randomUUID().toString().replace("-", ""); //UUID로 임의의 이름 부여. "-"는 못들어감.
				storeFileName = storeName + extension; //새로운 파일명 만들어주기
				
				file = new File(fileDir + "/" + storeFileName);
				try {
					mf.transferTo(file);
				} catch (Exception e){
					e.printStackTrace();
				}
				//여러 파일명을 하나의 문자열로 합치기
				originalTotal += originalFile + "-";
				storeTotal += storeFileName + "-";
			}
			//합쳐진 파일명 문자열을 dto에 저장.
			dto.setGoodsImage(storeTotal);
			dto.setGoodsImageOrg(originalTotal);
		}
		//파일은 hkdelivery/bin/main/static/upload 에 저장됨.
		//주의: src가 아니라 bin 에 저장됨. 프로젝트에서는 보이지 않음.
		
		goodsMapper.goodsInsert(dto);
		
	
	}
}
