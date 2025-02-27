package com.application.web.services.bar;

import com.application.common.exception.custom.EntityNotFoundException;
import com.application.domain.bar.entity.Bar;
import com.application.domain.bar.model.response.BarDetailResponse;
import com.application.domain.bar.model.response.BarSearchResponse;
import com.application.domain.bar.repository.BarRepository;
import com.application.domain.bar.repository.BarSearchRepository;
import com.application.domain.barImage.entity.BarImage;
import com.application.domain.barImage.repository.BarImageRepository;
import com.application.domain.menu.entity.Menu;
import com.application.domain.menu.repository.MenuRepository;
import com.application.domain.openHour.entity.OpenHour;
import com.application.domain.openHour.repository.OpenHourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarsSearchService {

    private final BarRepository barRepository;
    private final BarSearchRepository barSearchRepository;
    private final MenuRepository menuRepository;
    private final OpenHourRepository openHourRepository;
    private final BarImageRepository barImageRepository;

    public BarDetailResponse getBarDetails(Long barId) {
        Bar bar = barRepository.findById(barId).orElseThrow(
                () -> new EntityNotFoundException("cannot find entity with id: "+barId));
        List<Menu> menus = menuRepository.findAllByBar(bar);
        List<OpenHour> openHours = openHourRepository.findAllByBar(bar);
        List<BarImage> barImages = barImageRepository.findAllByBar(bar);

        return BarDetailResponse.from(bar, menus, openHours, barImages);
    }

    public Page<BarSearchResponse> getBarsByBarNameOrMenuName(String keyword, Pageable pageable) {
        return getBarSearchResponses(searchBarsByBarNameOrMenuName(keyword, pageable));
    }

    public Page<BarSearchResponse> getBarsByCurrentCoordinates(double currentX, double currentY, Pageable pageable) {
        return getBarSearchResponses(searchBarsByCurrentCoordinates(currentX, currentY, pageable));
    }

    public Page<BarSearchResponse> getBarSearchResponses(Page<Bar> bars) {
        return bars.map(bar -> {
            List<Menu> menus = menuRepository.findAllByBar(bar);
            BarImage barImage = barImageRepository.findFirstByBar(bar);

            return BarSearchResponse.from(bar, menus, barImage);
        });
    }

    private Page<Bar> searchBarsByBarNameOrMenuName(String keyword, Pageable pageable) {
        return barSearchRepository.findBarsByNameOrMenuName(keyword, pageable);
    }

    private Page<Bar> searchBarsByCurrentCoordinates(double currentX, double currentY, Pageable pageable) {
        return barSearchRepository.findByCurrentCoordinates(currentX, currentY, 5, pageable);
    }
}
