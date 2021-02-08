package com.local.i_sit_bbs.services;

import com.local.i_sit_bbs.pojo.Advertisement;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdvertisementService {

    int addAdv(Advertisement advertisement);

    int deleteAdv(Advertisement advertisement);

    int editAdv(Advertisement advertisement);

    List<Advertisement> getAdvs(Advertisement advertisement);
}
