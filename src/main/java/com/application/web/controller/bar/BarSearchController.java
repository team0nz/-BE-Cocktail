package com.application.web.controller.bar;

import com.application.common.Constant;
import com.application.common.response.ResponseDto;
import com.application.web.services.bar.BarsSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bar/search")
public class BarSearchController {

    private final BarsSearchService barsSearchService;

    @GetMapping
    public ResponseEntity<?> getBarDetail(@RequestParam(name = "bar-id") Long barId) {

        return new ResponseEntity<>(new ResponseDto<>(
                Constant.SUCCESS_CODE,
                "search by bar id",
                barsSearchService.getBarDetails(barId)),
                HttpStatus.OK
        );
    }

    @GetMapping("/by-name")
    public ResponseEntity<?> getBarsByBarName(@RequestParam(name = "keyword") String keyword, Pageable pageable) {

        return new ResponseEntity<>(new ResponseDto<>(
                Constant.SUCCESS_CODE,
                "search by bar name or menu name",
                barsSearchService.getBarsByBarNameOrMenuName(keyword, pageable)),
                HttpStatus.OK
        );
    }

    @GetMapping("/by-coordinate")
    public ResponseEntity<?> getBarsByCurrentCoordinates(@RequestParam(name = "x") Double currentX,
                                                         @RequestParam(name = "y") Double currentY,
                                                         Pageable pageable) {

        return new ResponseEntity<>(new ResponseDto<>(
                Constant.SUCCESS_CODE,
                "search by current coordinates",
                barsSearchService.getBarsByCurrentCoordinates(currentX, currentY, pageable)),
                HttpStatus.OK
        );
    }

}
