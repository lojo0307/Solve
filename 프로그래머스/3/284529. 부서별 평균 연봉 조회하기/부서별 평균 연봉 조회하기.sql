-- 코드를 작성해주세요
SELECT HR_DEPARTMENT.DEPT_ID, DEPT_NAME_EN, ROUND(AVG(SAL), 0) AVG_SAL FROM HR_DEPARTMENT JOIN HR_EMPLOYEES ON HR_DEPARTMENT.DEPT_ID = HR_EMPLOYEES.DEPT_ID GROUP BY HR_EMPLOYEES.DEPT_ID ORDER BY 3 DESC;