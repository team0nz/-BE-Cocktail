-- 맛 세부
INSERT taste_detail INTO VALUES (1, 1, "가볍고 상큼한 단 맛");
INSERT taste_detail INTO VALUES (2, 1, "부드럽고 크레미한 단 맛");
INSERT taste_detail INTO VALUES (3, 1, "진한 캐러맬 같은 단 맛");
INSERT taste_detail INTO VALUES (4, 2, "톡 쏘는 상큼함");
INSERT taste_detail INTO VALUES (5, 2, "과일의 자연스러운 상큼함");
INSERT taste_detail INTO VALUES (6, 3, "진하고 묵직한 느낌");
INSERT taste_detail INTO VALUES (7, 3, "가볍고 향긋한 느낌");
INSERT taste_detail INTO VALUES (8, 4, "스파이시하고 자극적인 느낌");
INSERT taste_detail INTO VALUES (8, 4, "묵직하고 깊은 맛");

-- 맛 카테고리
INSERT taste_category INTO VALUES (1, "달콤한 맛")
INSERT taste_category INTO VALUES (2, "새콤한 맛")
INSERT taste_category INTO VALUES (3, "쌉싸름한 맛")
INSERT taste_category INTO VALUES (4, "강렬한 맛")

-- 마티니 칵테일 재료
INSERT ingredient INTO VALUES (1, "진 (GIN)")
INSERT ingredient INTO VALUES (2, "드라이 베르무트 (DRY VERMOUTH)")
INSERT ingredient INTO VALUES (3, "올리브 (OLIVE)")
INSERT ingredient INTO VALUES (4, "레몬 필 (LEMON PEAL)")

-- 마티니 외 다른 칵테일 재료
INSERT INTO ingredient (id, material) VALUES (5, '라이 위스키 (RYE WHISKEY)');
INSERT INTO ingredient (id, material) VALUES (6, '스위트 베르무트 (SWEET VERMOUTH)');
INSERT INTO ingredient (id, material) VALUES (7, '앙고스투라 비터스 (ANGOSTURA BITTERS)');
INSERT INTO ingredient (id, material) VALUES (8, '체리 (CHERRY)');
INSERT INTO ingredient (id, material) VALUES (9, '캄파리 (CAMPARI)');
INSERT INTO ingredient (id, material) VALUES (10, '버번 위스키 (BOURBON WHISKEY)');
INSERT INTO ingredient (id, material) VALUES (11, '각설탕 (SUGAR CUBE)');

-- 청량한 여름 칵테일 재료
INSERT INTO ingredient (id, material) VALUES (12, '화이트 럼 (WHITE RUM)');
INSERT INTO ingredient (id, material) VALUES (13, '라임 주스 (LIME JUICE)');
INSERT INTO ingredient (id, material) VALUES (14, '설탕 (SUGAR)');
INSERT INTO ingredient (id, material) VALUES (15, '탄산수 (SODA WATER)');
INSERT INTO ingredient (id, material) VALUES (16, '민트 잎 (MINT LEAF)');
INSERT INTO ingredient (id, material) VALUES (17, '아페롤 (APEROL)');
INSERT INTO ingredient (id, material) VALUES (18, '프로세코 (PROSECCO)');
INSERT INTO ingredient (id, material) VALUES (19, '설탕 시럽 (SIMPLE SYRUP)');
INSERT INTO ingredient (id, material) VALUES (20, '코코넛 크림 (COCONUT CREAM)');
INSERT INTO ingredient (id, material) VALUES (21, '파인애플 주스 (PINEAPPLE JUICE)');
INSERT INTO ingredient (id, material) VALUES (22, '오렌지 필 (ORANGE PEEL)');
INSERT INTO ingredient (id, material) VALUES (23, '오렌지 슬라이스 (ORANGE SLICE)');
INSERT INTO ingredient (id, material) VALUES (24, '파인애플 슬라이스 (PINEAPPLE SLICE)');

INSERT INTO location (id, location) VALUES (1, "고급스러운 자리");


INSERT INTO mood (id, mood) VALUES (1, "클래식한 분위기");



INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol) VALUES (1, "마티니", 120, "단순하지만 완벽한 클래식 칵테일", 32, 30);
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol) VALUES (2, "맨해튼", 90, "깊고 부드러운 위스키와 스위트 베르무트의 조화", 33, 30);
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol) VALUES (3, "네그로니", 90, "쓰고 달콤한, 이탈리아 감서으이 한 잔", 24, 26);
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol) VALUES (4, "올드 패션드", 90, "위스키 본연의 맛을 즐길 수 있는 전통 칵테일", 35, 32);
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol) VALUES (5, "모히토", 250, "상쾌한 민트와 라임이 만드는 청량한 한 잔", 13, 10);
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol) VALUES (6, "아페롤 스프리츠", 250, "가벼운 달콤 쌉싸름한 맛과 스파클리의 조화", 12, 10);
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol) VALUES (7, "다이키리", 120, "럼과 라임의 깔끔한 조화, 쿠바 스타일 칵테일", 20, 18);
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol) VALUES (8, "피나콜라다", 300, "코코넛과 파인애플이 어우러진 달콤한 휴양지 칵테일", 15, 13);



INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (1, 1, 1, 60, "ml")
INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (2, 2, 1, 10, "ml")
INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (3, 3, 1, 1, "ea")
INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (4, 4, 1, 1, "ea")


INSERT INTO mapping_recommend (id, cocktail_id, location_id, mood_id) VALUES (1, 1, 1);

INSERT INTO mapping_taste (id, taste_category_id, taste_detail_id, cocktail_id) VALUES (1, 4, 8, 1);