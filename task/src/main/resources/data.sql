INSERT INTO task (title, done)
SELECT '牛乳を買う', false
WHERE NOT EXISTS (SELECT 1 FROM task WHERE title = '牛乳を買う');

INSERT INTO task (title, done)
SELECT '掃除をする', false
WHERE NOT EXISTS (SELECT 1 FROM task WHERE title = '掃除をする');

INSERT INTO task (title, done)
SELECT '本を読む', false
WHERE NOT EXISTS (SELECT 1 FROM task WHERE title = '本を読む');

