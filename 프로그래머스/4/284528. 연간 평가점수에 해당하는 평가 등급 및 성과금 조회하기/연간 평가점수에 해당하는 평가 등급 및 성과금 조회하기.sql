SELECT E.EMP_NO EMP_NO, EMP_NAME, 
CASE WHEN AVG(G.SCORE) > 95 THEN 'S' WHEN AVG(G.SCORE) >= 90 THEN 'A' WHEN AVG(G.SCORE) >= 80 THEN 'B' ELSE 'C' END AS GRADE,
SAL * CASE WHEN AVG(G.SCORE) > 95 THEN 0.2 WHEN AVG(G.SCORE) >= 90 THEN 0.15 WHEN AVG(G.SCORE) >= 80 THEN 0.1 ELSE 0 END AS BONUS
FROM HR_GRADE G JOIN HR_EMPLOYEES E ON E.EMP_NO = G.EMP_NO
GROUP BY G.EMP_NO
ORDER BY 1;
