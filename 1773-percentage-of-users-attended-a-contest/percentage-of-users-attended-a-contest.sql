WITH total_users AS (
  SELECT COUNT(*) AS cnt FROM Users
)
SELECT 
    contest_id,
    ROUND(COUNT(user_id) * 100.0 / tu.cnt, 2) AS percentage
FROM Register, total_users tu
GROUP BY contest_id
ORDER BY percentage DESC, contest_id ASC;