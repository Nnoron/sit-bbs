package com.local.i_sit_bbs.services.servicesImp;

import com.local.i_sit_bbs.dao.AdvertisementMapper;
import com.local.i_sit_bbs.pojo.Advertisement;
import com.local.i_sit_bbs.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImp implements AdvertisementService {

    @Autowired
    AdvertisementMapper advertisementMapper;

    @Override
    public int addAdv(Advertisement advertisement) {
        return advertisementMapper.insertSelective(advertisement);
    }

    @Override
    public int deleteAdv(Advertisement advertisement) {
        return advertisementMapper.deleteAdv(advertisement);
    }

    @Override
    public int editAdv(Advertisement advertisement) {
        return advertisementMapper.editAdv(advertisement);
    }

    @Override
    public List<Advertisement> getAdvs(Advertisement advertisement) {
        return advertisementMapper.getAdvs(advertisement);
    }
}
