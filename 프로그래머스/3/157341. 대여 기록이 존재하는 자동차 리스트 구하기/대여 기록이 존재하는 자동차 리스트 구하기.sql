-- 코드를 입력하세요
SELECT DISTINCT CAR_RENTAL_COMPANY_CAR.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY ON CAR_RENTAL_COMPANY_CAR.CAR_ID = CAR_RENTAL_COMPANY_RENTAL_HISTORY.CAR_ID
WHERE CAR_TYPE = '세단' AND MONTH(START_DATE) = 10
ORDER BY 1 DESC;