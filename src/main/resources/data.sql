-- 맛 세부
INSERT taste_detail INTO VALUES (1, 1, "가볍고 상큼한 단 맛");
INSERT taste_detail INTO VALUES (2, 1, "부드럽고 크레미한 단 맛");
INSERT taste_detail INTO VALUES (3, 1, "진한 캐러맬 같은 단 맛");
INSERT taste_detail INTO VALUES (4, 2, "톡 쏘는 상큼함");
INSERT taste_detail INTO VALUES (5, 2, "과일의 자연스러운 상큼함");
INSERT taste_detail INTO VALUES (6, 3, "진하고 묵직한 느낌");
INSERT taste_detail INTO VALUES (7, 3, "가볍고 향긋한 느낌");
INSERT taste_detail INTO VALUES (8, 4, "스파이시하고 자극적인 느낌");
INSERT taste_detail INTO VALUES (9, 4, "묵직하고 깊은 맛");
INSERT taste_detail INTO VALUES (10, 1, "달콤 쌉쌀한 맛");


-- 맛 카테고리
INSERT taste_category INTO VALUES (1, "달콤한 맛");
INSERT taste_category INTO VALUES (2, "새콤한 맛");
INSERT taste_category INTO VALUES (3, "쌉싸름한 맛");
INSERT taste_category INTO VALUES (4, "강렬한 맛");

-- 마티니 칵테일 재료
INSERT ingredient INTO VALUES (1, "진 (GIN)");
INSERT ingredient INTO VALUES (2, "드라이 베르무트 (DRY VERMOUTH)");
INSERT ingredient INTO VALUES (3, "올리브 (OLIVE)");
INSERT ingredient INTO VALUES (4, "레몬 필 (LEMON PEAL)");

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
INSERT INTO ingredient (id, material) VALUES (25, '보드카');
INSERT INTO ingredient (id, material) VALUES (27, '트리플 섹');
INSERT INTO ingredient (id, material) VALUES (28, '데킬라');
INSERT INTO ingredient (id, material) VALUES (29, '레몬 주스');
INSERT INTO ingredient (id, material) VALUES (31, '다크 럼');
INSERT INTO ingredient (id, material) VALUES (32, '오렌지 큐라소');
INSERT INTO ingredient (id, material) VALUES (33, '오르제 시럽');
INSERT INTO ingredient (id, material) VALUES (34, '샴페인');
INSERT INTO ingredient (id, material) VALUES (35, '오렌지 주스');
INSERT INTO ingredient (id, material) VALUES (36, '크랜베리 주스');
INSERT INTO ingredient (id, material) VALUES (37, '라임 주스');
INSERT INTO ingredient (id, material) VALUES (38, '복숭아 퓨레');
INSERT INTO ingredient (id, material) VALUES (39, '커피 리큐어');
INSERT INTO ingredient (id, material) VALUES (40, '크림');
INSERT INTO ingredient (id, material) VALUES (41, '스카치 위스키');
INSERT INTO ingredient (id, material) VALUES (42, '스모키 위스키');
INSERT INTO ingredient (id, material) VALUES (43, '라이 위스키');
INSERT INTO ingredient (id, material) VALUES (44, '페이쇼드 비터스');
INSERT INTO ingredient (id, material) VALUES (45, '압생트 린스');
INSERT INTO ingredient (id, material) VALUES (46, '토닉 워터');
INSERT INTO ingredient (id, material) VALUES (47, '위스키');
INSERT INTO ingredient (id, material) VALUES (48, '진저비어');
INSERT INTO ingredient (id, material) VALUES (50, '아마레토');


INSERT INTO situation (id, situation) VALUES (1, "고급스러운 자리");
INSERT INTO situation (id, situation) VALUES (2, "세련된 자리");
INSERT INTO situation (id, situation) VALUES (3, "식전주");
INSERT INTO situation (id, situation) VALUES (4, "이탈리아 요리와 함께");
INSERT INTO situation (id, situation) VALUES (5, "조용한");
INSERT INTO situation (id, situation) VALUES (6, "위스키를 즐길때");
INSERT INTO situation (id, situation) VALUES (7, "해변에서 시원하게");
INSERT INTO situation (id, situation) VALUES (8, "브런치");
INSERT INTO situation (id, situation) VALUES (9, "가벼운 술자리");
INSERT INTO situation (id, situation) VALUES (10, "휴양지");
INSERT INTO situation (id, situation) VALUES (11, "가벼운 대화");
INSERT INTO situation (id, situation) VALUES (12, "파티");
INSERT INTO situation (id, situation) VALUES (13, "강한 한 잔이 필요할 때");
INSERT INTO situation (id, situation) VALUES (14, "칵테일 바");
INSERT INTO situation (id, situation) VALUES (15, "격식 있는 자리");
INSERT INTO situation (id, situation) VALUES (16, "연말 모임");
INSERT INTO situation (id, situation) VALUES (17, "디저트 칵테일");
INSERT INTO situation (id, situation) VALUES (18, "부드러운 맛을 원할 때");
INSERT INTO situation (id, situation) VALUES (19, "커피 리큐어 애호가");
INSERT INTO situation (id, situation) VALUES (20, "위스키 애호가");
INSERT INTO situation (id, situation) VALUES (21, "클래식 칵테일");
INSERT INTO situation (id, situation) VALUES (22, "식사와 함께 가벼운 음주");
INSERT INTO situation (id, situation) VALUES (23, "상쾌한 한 잔이 필요할 때");


INSERT INTO mood (id, mood) VALUES (1, "클래식한 분위기");
INSERT INTO mood (id, mood) VALUES (2, "조용한 분위기");
INSERT INTO mood (id, mood) VALUES (3, "세련된 분위기");
INSERT INTO mood (id, mood) VALUES (4, "트로피컬 무드");
INSERT INTO mood (id, mood) VALUES (5, "여성적인 무드");
INSERT INTO mood (id, mood) VALUES (6, "고급스러운 분위기");


INSERT INTO season (id, season) VALUES (1, "봄");
INSERT INTO season (id, season) VALUES (2, "여름");
INSERT INTO season (id, season) VALUES (3, "가을");
INSERT INTO season (id, season) VALUES (4, "겨울");

INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol) VALUES (1, "마티니", 120, "단순하지만 완벽한 클래식 칵테일 (드라이, 약간 쓴 맛)", 32, 30);
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol) VALUES (2, "맨해튼", 90, "깊고 부드러운 위스키와 스위트 베르무트의 조화 (달콤 쌉싸름, 묵직한 맛)", 33, 30);
-- 네그로니
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (3, '네그로니', 90, '쓰고 달콤한, 이탈리아 감성의 한 잔 (씁쓸한 달콤한 맛)', 26, 24);

-- 올드 패션드
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (4, '올드 패션드', 90, '위스키 본연의 맛을 즐길 수 있는 전통 칵테일 (묵직하고 달콤한 쓴 맛)', 35, 32);

-- 모히토
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (5, '모히토', 250, '상쾌한 민트와 라임이 만드는 청량한 한 잔 (상큼, 달콤, 청량감)', 13, 10);

-- 아페롤 스프리츠
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (6, '아페롤 스프리츠', 250, '가벼운 달콤 쌉싸름한 맛과 스파클링의 조화 (달콤, 쌉싸름, 청량감)', 12, 10);

-- 다이키리
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (7, '다이키리', 120, '럼과 라임의 깔끔한 조화, 쿠바 스타일 칵테일 (상큼, 깔끔한 단 맛)', 20, 18);

-- 피나콜라다
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (8, '피나콜라다', 300, '코코넛과 파인애플이 어우러진 달콤한 휴양지 칵테일 (달콤, 크리미함)', 15, 13);

-- 롱 아일랜드 아이스티
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (9, '롱 아일랜드 아이스티', 350, '다양한 술이 섞여 강렬한 도수를 자랑하는 아이스티 스타일 칵테일 (상큼, 달콤한 맛)', 25, 22);

-- 마이타이
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (10, '마이타이', 300, '럼과 오렌지 리큐어의 조화가 빚어내는 트로피컬한 한 잔 (상큼, 견과류 향, 과일 향)', 20, 15);

-- 미모사
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (11, '미모사', 180, '가벼운 브런치에 어울리는 상큼한 샴페인 칵테일 (상큼, 가벼움)', 10, 8);

-- 코스모폴리탄
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (12, '코스모폴리탄', 200, '도시적인 감각이 돋보이는 크랜베리 베이스 칵테일 (새콤달콤, 시트러스)', 20, 18);

-- 프렌치 75
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (13, '프렌치 75', 200, '샴페인과 진이 만나 탄생한 우아한 칵테일 (상큼, 드라이)', 18, 15);

-- 벨리니
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (14, '벨리니', 200, '복숭아 퓨레와 샴페인이 조화를 이루는 달콤한 칵테일 (달콤, 상큼)', 10, 8);

-- 화이트 러시안
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (15, '화이트 러시안', 250, '보드카, 커피 리큐어, 크림이 어우러진 부드러운 칵테일 (달콤, 크리미)', 18, 15);

-- 블랙 러시안
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (16, '블랙 러시안', 200, '화이트 러시안에서 크림을 뺀 강렬한 커피 리큐어 칵테일 (달콤, 강렬)', 25, 20);

-- 부케레
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (17, '부케레', 250, '위스키 베이스의 클래식하고 깊은 맛을 가진 칵테일 (씁쓸, 부드러움)', 25, 20);

-- 로부로이
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (18, '로부로이', 200, '스카치 위스키로 만든 네그로니 스타일 칵테일 (강렬, 드라이)', 25, 22);

-- 스모키 올드 패션드
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (19, '스모키 올드 패션드', 200, '스모키한 향이 강조된 클래식한 올드 패션드 (스코미, 강렬)', 28, 25);

-- 사제락
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (20, '사제락', 200, '뉴올리언스의 대표적인 강렬하고 스파이시한 위스키 칵테일 (강렬, 스파이시)', 30, 25);

-- 진토닉
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (21, '진토닉', 300, '깔끔한 진과 톡 쏘는 탄산이 어우러진 클래식 칵테일 (상쾌, 드라이)', 15, 10);

-- 하이볼
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (22, '하이볼', 300, '위스키와 탄산수의 조화가 주는 시원한 한 잔 (깔끔, 드라이)', 12, 8);

-- 모스코 뮬
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (23, '모스코 뮬', 300, '보드카와 진저비어가 만드는 상큼하고 청량한 칵테일 (상큼, 스파이시)', 12, 10);

-- 아마레토 사워
INSERT INTO cocktail (id, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol)
VALUES (24, '아마레토 사워', 250, '달콤한 아마레토와 새콤한 레몬이 조화된 부드러운 칵테일 (달콤, 새콤한 맛)', 15, 12);



-- 매핑재료
--먀티니
INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (1, 1, 1, 60, "ml");
INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (2, 2, 1, 10, "ml");
INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (3, 3, 1, 1, "ea");
INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (4, 4, 1, 1, "ea");

-- 맨헤튼
INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (5, 5, 2, 90, "ml");
INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (6, 6, 2, 10, "ml");
INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (7, 7, 2, 2, "drop");
INSERT INTO mapping_ingredient (id, ingredient_id, cocktail_id, quantity, unit) VALUES  (8, 8, 2, 1, "ea");

-- 네그로니 (cocktail id 3)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (1, 3, 30, 'ml');  -- 진 (Gin)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (9, 3, 30, 'ml');  -- 캄파리 (Campari)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (6, 3, 30, 'ml');  -- 스위트 베르무트 (Sweet Vermouth);

-- 올드 패션드 (cocktail id 4)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (10, 4, 50, 'ml');  -- 버번 위스키 (Bourbon Whiskey)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (11, 4, 1, 'ea');   -- 각설탕 (Sugar Cube)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (7, 4, 3, 'drop');  -- 앙고스투라 비터스 (Angostura Bitters);

-- 모히토 (cocktail id 5)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (12, 5, 45, 'ml');  -- 화이트 럼 (White Rum)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (13, 5, 30, 'ml');  -- 라임 주스 (Lime Juice)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (14, 5, 2, 'tsp');  -- 설탕 (Sugar) (2 티스푼)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (15, 5, 100, 'ml'); -- 탄산수 (Soda Water);

-- 아페롤 스프리츠 (cocktail id 6)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (17, 6, 60, 'ml');  -- 아페롤 (Aperol)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (18, 6, 90, 'ml');  -- 프로세코 (Prosecco)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (15, 6, 30, 'ml');  -- 탄산수 (Soda Water);

-- 다이키리 (cocktail id 7)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (12, 7, 45, 'ml');  -- 화이트 럼 (White Rum)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (13, 7, 25, 'ml');  -- 라임 주스 (Lime Juice)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (19, 7, 15, 'ml');  -- 설탕 시럽 (Simple Syrup);

-- 피나콜라다 (cocktail id 8)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (12, 8, 45, 'ml');  -- 화이트 럼 (White Rum)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (20, 8, 60, 'ml');  -- 코코넛 크림 (Coconut Cream)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (21, 8, 90, 'ml');  -- 파인애플 주스 (Pineapple Juice);

-- 롱 아일랜드 아이스티 (cocktail id 9)
-- 필요한 추가 재료: 보드카, 진, 화이트 럼, 트리플 섹, 데킬라, 레몬 주스, 콜라(선택)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (25, 9, 15, 'ml');  -- 보드카 (Vodka) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (1, 9, 15, 'ml');   -- 진 (Gin)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (12, 9, 15, 'ml');  -- 화이트 럼 (White Rum)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (27, 9, 15, 'ml');  -- 트리플 섹 (Triple Sec) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (28, 9, 15, 'ml');  -- 데킬라 (Tequila) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (29, 9, 30, 'ml');  -- 레몬 주스 (Lemon Juice) [새로운 재료];

-- 마이타이 (cocktail id 10)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (12, 10, 30, 'ml');  -- 화이트 럼 (White Rum)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (31, 10, 30, 'ml');  -- 다크 럼 (Dark Rum) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (32, 10, 15, 'ml');  -- 오렌지 큐라소 (Orange Curacao) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (13, 10, 30, 'ml');  -- 라임 주스 (Lime Juice)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (33, 10, 15, 'ml');  -- 오르제 시럽 (Orgeat Syrup) [새로운 재료]

-- 미모사 (cocktail id 11)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (34, 11, 90, 'ml');  -- 샴페인 (Champagne) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (35, 11, 90, 'ml');  -- 오렌지 주스 (Orange Juice) [새로운 재료]

-- 코스모폴리탄 (cocktail id 12)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (25, 12, 45, 'ml');  -- 보드카 (Vodka)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (27, 12, 15, 'ml');  -- 트리플 섹 (Triple Sec)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (36, 12, 30, 'ml');  -- 크랜베리 주스 (Cranberry Juice) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (37, 12, 15, 'ml');  -- 라임 주스 (Lime Juice) [새로운 재료]

-- 프렌치 75 (cocktail id 13)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (1, 13, 45, 'ml');   -- 진 (Gin)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (29, 13, 15, 'ml');   -- 레몬 주스 (Lemon Juice)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (19, 13, 10, 'ml');   -- 심플 시럽 (Simple Syrup)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (34, 13, 0, '');      -- 샴페인 (Champagne) - "적당량" 처리

-- 벨리니 (cocktail id 14)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (38, 14, 60, 'ml');   -- 복숭아 퓨레 (Peach Puree) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (34, 14, 120, 'ml');  -- 샴페인 (Champagne)

-- 화이트 러시안 (cocktail id 15)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (25, 15, 45, 'ml');   -- 보드카 (Vodka)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (39, 15, 30, 'ml');   -- 커피 리큐어 (Coffee Liqueur) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (40, 15, 30, 'ml');   -- 크림 (Cream) [새로운 재료]

-- 블랙 러시안 (cocktail id 16)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (25, 16, 45, 'ml');   -- 보드카 (Vodka)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (39, 16, 30, 'ml');   -- 커피 리큐어 (Coffee Liqueur)

-- 부케레 (cocktail id 17)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (10, 17, 45, 'ml');   -- 버번 위스키 (Bourbon Whiskey)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (6, 17, 30, 'ml');    -- 스위트 베르무트 (Sweet Vermouth)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (9, 17, 30, 'ml');    -- 캄파리 (Campari)

-- 로부로이 (cocktail id 18)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (41, 18, 60, 'ml');   -- 스카치 위스키 (Scotch Whisky) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (6, 18, 30, 'ml');    -- 스위트 베르무트 (Sweet Vermouth)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (7, 18, 2, 'drop');   -- 앙고스투라 비터스 (Angostura Bitters)

-- 스모키 올드 패션드 (cocktail id 19)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (42, 19, 60, 'ml');   -- 스모키 위스키 (Smoky Whisky) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (7, 19, 2, 'drop');   -- 앙고스투라 비터스 (Angostura Bitters)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (11, 19, 1, 'ea');    -- 각설탕 (Sugar Cube)

-- 사제락 (cocktail id 20)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (43, 20, 60, 'ml');   -- 라이 위스키 (Rye Whiskey) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (44, 20, 2, 'drop');   -- 페이쇼드 비터스 (Peychaud''s Bitters) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (7, 20, 1, 'drop');    -- 앙고스투라 비터스 (Angostura Bitters)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (19, 20, 10, 'ml');    -- 심플 시럽 (Simple Syrup)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (45, 20, 0, 'rinse');  -- 압생트 (Absinthe) 린스 [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (4, 20, 0, '');        -- 레몬 필 (Lemon Peel)

-- 진토닉 (cocktail id 21)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (1, 21, 45, 'ml');    -- 진 (Gin)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (46, 21, 120, 'ml');  -- 토닉워터 (Tonic Water) [새로운 재료]

-- 하이볼 (cocktail id 22)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (47, 22, 45, 'ml');   -- 위스키 (Whisky) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (15, 22, 150, 'ml');  -- 탄산수 (Soda Water)

-- 모스코 뮬 (cocktail id 23)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (25, 23, 45, 'ml');   -- 보드카 (Vodka)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (37, 23, 15, 'ml');   -- 라임 주스 (Lime Juice) [재사용]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (48, 23, 120, 'ml');  -- 진저비어 (Ginger Beer) [새로운 재료]

-- 아마레토 사워 (cocktail id 24)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (50, 24, 60, 'ml');   -- 아마레토 (Amaretto) [새로운 재료]
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (29, 24, 30, 'ml');   -- 레몬 주스 (Lemon Juice)
INSERT INTO mapping_ingredient (ingredient_id, cocktail_id, quantity, unit)
VALUES (19, 24, 10, 'ml');   -- 심플 시럽 (Simple Syrup)


-- 매핑 맛
INSERT INTO mapping_taste (id, taste_category_id, taste_detail_id, cocktail_id)
VALUES (1, 4, 8, 1);
INSERT INTO mapping_taste (id, taste_category_id, taste_detail_id, cocktail_id)
VALUES (1, 1, 10, 2)
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (4, 8, 3);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (4, 9, 4);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (1, 1, 5);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (2, 4, 6);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (1, 1, 7);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (1, 2, 8);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (1, 1, 9);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (2, 5, 10);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (2, 4, 11);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (1, 1, 12);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (2, 5, 13);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (1, 1, 14);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (1, 2, 15);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (3, 6, 16);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (3, 7, 17);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (4, 9, 18);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (4, 9, 19);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (4, 8, 20);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (2, 4, 21);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (3, 7, 22);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (4, 8, 23);
INSERT INTO mapping_taste (taste_category_id, taste_detail_id, cocktail_id)
VALUES (1, 1, 24);




-- 매핑 추천
INSERT INTO mapping_recommend (id, cocktail_id, situation_id, mood_id)
VALUES (1, 1, 1);
INSERT INTO mapping_recommend (id, cocktail_id, situation_id, mood_id)
VALUES (2, 2, 5, 3);
-- 네그로니 (cocktail id 3)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (3, 3);
VALUES (3, 4);

-- 올드 패션드 (cocktail id 4)
INSERT INTO mapping_recommend (cocktail_id, situation_id, mood_id)
VALUES (4, 6, 1);

-- 모히토 (cocktail id 5)
INSERT INTO mapping_recommend (cocktail_id, situation_id, season_id)
VALUES (5, 7, 2);

-- 아페롤 스프리츠 (cocktail id 6)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (6, 8);
VALUES (6, 9);

-- 다이키리 (cocktail id 7)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (7, 10);
VALUES (7, 11);

-- 피나콜라다 (cocktail id 8)
INSERT INTO mapping_recommend (cocktail_id, situation_id, season_id)
VALUES (8, 10, 2);

-- 롱 아일랜드 아이스티 (cocktail id 9)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (9, 12);
VALUES (9, 13);

-- 마이타이 (cocktail id 10)
INSERT INTO mapping_recommend (cocktail_id, situation_id, mood_id)
VALUES (10, 7, 4);

-- 미모사 (cocktail id 11)
INSERT INTO mapping_recommend (cocktail_id, situation_id, mood_id, season_id)
VALUES (11, 8);
VALUES (11, 9);

-- 코스모폴리탄 (cocktail id 12)
INSERT INTO mapping_recommend (cocktail_id, situation_id, mood_id)
VALUES (12, 14, 5);

-- 프렌치 75 (cocktail id 13)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (13, 15);
VALUES (13, 16);

-- 벨리니 (cocktail id 14)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (14, 8);
VALUES (14, 9);

-- 화이트 러시안 (cocktail id 15)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (15, 17);
VALUES (15, 18);

-- 블랙 러시안 (cocktail id 16)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (16, 13);
VALUES (16, 19);

-- 부케레 (cocktail id 17)
INSERT INTO mapping_recommend (cocktail_id, situation_id, mood_id)
VALUES (17, 20, 6);

-- 로부로이 (cocktail id 18)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (18, 20);
VALUES (18, 21);

-- 스모키 올드 패션드 (cocktail id 19)
INSERT INTO mapping_recommend (cocktail_id, situation_id, mood_id)
VALUES (19, 20, 6);

-- 사제락 (cocktail id 20)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (20, 20);
VALUES (20, 21);

-- 진토닉 (cocktail id 21)
INSERT INTO mapping_recommend (cocktail_id, situation_id, season_id)
VALUES (21, 9, 2);

-- 하이볼 (cocktail id 22)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (22, 22);

-- 모스코 뮬 (cocktail id 23)
INSERT INTO mapping_recommend (cocktail_id, situation_id, season_id)
VALUES (23, 23, 2);

-- 아마레토 사워 (cocktail id 24)
INSERT INTO mapping_recommend (cocktail_id, situation_id)
VALUES (24, 17);
VALUES (24, 18);
