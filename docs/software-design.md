# 設計メモ

## URL

### page
|機能|URL|
|:--|:--|
|ログイン|/login|
|一覧表示|/timecard/{userid}/list|
|対象月データ表示|/timecard/{userid}/{yearMonth}|
|更新|/timecard/{userid}/{yearMonth}/edit|

### API
|機能|メソッド|URL|
|:--|:--|:--|
|ログイン|POST|/api/login|
|一覧取得|GET|/api/timecard/{userid}/list|
|対象月データ取得|GET|/api/timecard/{userid}/{yearMonth}|
|登録更新|POST|/api/timecard/{userid}/{yearMonth}/update|


prmd のインストール
```sh
bundle install --path vendor/bundle
```

- API作成

```sh
bundle exec prmd init --yaml timecard > docs/schema/schemata/timecard.yml
```

- schemaファイル結合

```sh
bundle exec prmd combine --meta docs/json-schema/meta.yml docs/json-schema/schemata/ > docs/json-schema/schema.json
```

```sh
bundle exec prmd verify docs/json-schema/schema.json
```

- ドキュメント作成

```sh
bundle exec prmd doc docs/schema/schema.json > docs/schema/schema.md
```

- サンプルJSON

```request.json
{
  yearMonth: "201701"
}
```

```response.json
{
  result: {
    yearMonth: "",
    days: [
      {
        bizDate: "20170101",
        startDate: "YYYY-MM-DDTHH:mm:ss.SSSZ",
        endDate: "YYYY-MM-DDTHH:mm:ss.SSSZ",
        remarks: "備考"
      }
    ]
  },
  error: {
    code: "",
    message: ""
  }
}
```

- ファイル保存時の即時反映
  - ファイル更新を検知する
    - nodeでやるならこの辺を参考に
    https://github.com/webpack/watchpack/tree/master/lib
  - クライアント側への通知



- Jacksonでnullの場合は項目を出力しないアノテーションつける
- jsonファイル読み込みテスト追加
- 必須項目(required)対応

- コントローラの作成
- セッション単位でのユーザーアクセス
- モックサーバ用のJSON追加
- dockerのみでプロジェクトのビルドからデプロイまでできるように
- gradleで定義された依存ライブラリを事前にインストールできるようにする(ビルドはしない)



node --harmony-async-await buildSrc/src/main/javascript/excel-reader.js
