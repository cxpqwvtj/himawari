# 設計メモ

## URL

### page
|機能|URL|
|:-|:-|
|ログイン|/login|
|一覧表示|/timecard/{userid}/list|
|対象月データ表示|/timecard/{userid}/{yearMonth}|
|更新|/timecard/{userid}/{yearMonth}/edit|

### API
|機能|メソッド|URL|
|:-|:-|:-|
|ログイン|POST|/api/login|
|一覧取得|GET|/api/timecard/{userid}/list|
|対象月データ取得|GET|/api/timecard/{userid}/{yearMonth}|
|登録更新|POST|/api/timecard/{userid}/{yearMonth}/update|
