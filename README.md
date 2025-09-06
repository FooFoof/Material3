# Android Views × Material3 サンプルアプリ

このリポジトリは、**Android ViewsでMaterial3コンポーネントを実装したサンプルアプリ**です。  
Material3の各コンポーネントを実際に配置・カスタマイズし、UIの見た目や使い勝手、カスタマイズしづらい点を確認できるようにしています。

---

## 背景
Material3は公式ドキュメントが整備されていますが、以下の課題があります:
- 多くのドキュメントが英語で提供されている  
- 実装例は **Jetpack Compose** が中心  
- **Android Views × Material3** の情報が少なく、学習コストが高い  

そこで本アプリでは、Android ViewsでのMaterial3コンポーネントの実装例を整理し、見やすく表現しました。  

調査内容は以下のドキュメントにもまとめています:  
[Material3 調査ドキュメント（Notion）](https://www.notion.so/Material3-24e9cf2c9685802987edc2724b76933c)

改善点などがありましたら、ぜひコメントいただけると嬉しいです。

---

## 動作環境
- **推奨OS**: Android 12 以上  
  - Android 12 未満ではダイナミックカラーが利用できません
- **開発環境**
  - Android Studio Ladybug | 2024.2.1 Patch 3
  - minSdkVersion: 31
  - targetSdkVersion: 35
  - compileSdkVersion: 35
  - Material Components: `com.google.android.material:material:1.14.0-alpha01`

---

## アプリ構成
### トップページ
- **1ページ目**: 大きいコンポーネント一覧  
- **2ページ目**: 小さいコンポーネント一覧  
- **3ページ目**: ローディング、ダイナミックカラー、スナックバーの表示  

### 各コンポーネントページ
- トップページから遷移可能  
- コンポーネントをカスタマイズした例を配置  

---

## インストール方法
1. このリポジトリをcloneします  
   
2. Android Studioで開きます

3. 実機またはエミュレータで実行してください


###  参考資料

[Material Design 3 (公式)](https://m3.material.io/components)
[Material Components for Android (GitHub)](material)
[Google Fonts Icons](https://fonts.google.com/icons)
 ※アプリ内で使用

### ライセンス
このリポジトリは [MIT License](LICENSE) のもとで公開されています。  
使用しているアイコンやコンポーネントは、それぞれの提供元のライセンスに従います。  
- [Material Components for Android](https://github.com/material-components/material-components-android) (Apache License 2.0)  
- [Google Fonts Icons](https://fonts.google.com/icons) (Apache License 2.0)  
