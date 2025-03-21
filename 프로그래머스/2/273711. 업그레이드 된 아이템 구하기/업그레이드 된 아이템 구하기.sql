-- 코드를 작성해주세요
-- SELECT ITEM_TREE.ITEM_ID, ITEM_NAME, RARITY FROM ITEM_INFO JOIN ITEM_TREE ON ITEM_INFO.ITEM_ID = ITEM_TREE.ITEM_ID WHERE (SELECT RARITY FROM ITEM_INFO WHERE ITEM_ID = ITEM_TREE.PARENT_ITEM_ID) = 'RARE' ORDER BY ITEM_ID DESC;

SELECT C.ITEM_ID ITEM_ID, C.ITEM_NAME ITEM_NAME, C.RARITY RARITY
FROM ITEM_TREE
JOIN ITEM_INFO AS C ON ITEM_TREE.ITEM_ID = C.ITEM_ID
JOIN ITEM_INFO AS P ON ITEM_TREE.PARENT_ITEM_ID = P.ITEM_ID
WHERE P.RARITY = 'RARE'
ORDER BY 1 DESC;