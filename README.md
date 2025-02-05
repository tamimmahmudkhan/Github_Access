# Android GitHub ユーザー API アプリ
(English version below)
GitHub ユーザー API と連携するシンプルな Android フロントエンドアプリケーションです。このアプリでは以下の操作ができます：

- GitHub ユーザーの公開リストを見る。
- リストに表示されている各ユーザーの詳細情報を見る。

## 機能

- **ユーザーリスト**: API から取得した GitHub ユーザーのリストを表示します。
- **ユーザー詳細**: ユーザーをタップすると、ログイン情報、ノード ID、フォロワー、フォロー、ギストなどの詳細情報を表示します。
- **2列レイアウト**: ユーザーの詳細情報を、より良いユーザー体験のために整然とした2列グリッドで表示します。
- **MVVM**: MVVM アーキテクチャガイドラインに基づいて実装されています。

## インストール

始めるには、このリポジトリをクローンし、Android Studio で開いてください。

### 手順:

1. このリポジトリをクローンします：
    ```bash
    git clone https://github.com/your-username/your-repo-name.git
    ```

2. [Android Studio](https://developer.android.com/studio) でプロジェクトを開きます。

3. アプリケーションをビルドし、Android エミュレーターまたは実機で実行します。

## 必要な環境

- Android Studio
- 最低 SDK: API 21 (Android 5.0 Lollipop)
- GitHub API アクセス (公開)

## 使用されている API

このアプリは、[GitHub Users API](https://docs.github.com/en/rest/users/users) と連携し、公開ユーザー情報を取得します。

## UI レイアウト

- **ホーム画面**: ユーザーのリストを表示します。
- **ユーザー詳細画面**: 選択したユーザーの詳細情報（ログイン、ノード ID、フォロワー、フォロー、ギストなど）を、2列グリッドで表示します。

## 使用ライブラリ

- **Jetpack Compose**: アプリのインターフェースを構築するための UI コンポーネント。
- **Volley**: API リクエストを処理するためのネットワークライブラリ。
- **Coil**: Jetpack Compose 用の画像ローディング（使用されている場合）。

## スクリーンショット

![ユーザーリスト](screenshots/user_list.png)
![ユーザー詳細](screenshots/user_details.png)

## コントリビュート

1. リポジトリをフォークします。
2. 新しいブランチを作成します (`git checkout -b feature-name`)。
3. 変更をコミットします (`git commit -am 'Add feature'`)。
4. ブランチにプッシュします (`git push origin feature-name`)。
5. 新しいプルリクエストを作成します。

## 改善案

以下の機能を追加すると、アプリの機能やユーザー体験を向上させることができます：

1. **リポジトリ、イベント、ギスト、スターの詳細 UI を追加**  
   各サブカテゴリ（リポジトリ、イベント、ギスト、スター）について、詳細情報をすべて表示できるようにする。これにより、ユーザーは自分の活動や関心のある情報を詳細に確認できるようになります。

2. **UI デザインの改善**  
   色のコーディネートやスタイリングを改善し、より洗練された、直感的なデザインにすることで、アプリの見た目や使い心地を向上させることができます。

3. **ログイン機能の追加**  
   認証されたユーザーが自分のリポジトリを閲覧できるように、GitHub の OAuth 認証を使ってログイン機能を追加します。これにより、ユーザーは自分のリポジトリや他のプライベートな情報にアクセスできるようになります。




# Android GitHub Users API App

A simple Android front-end application that interacts with the GitHub Users API. It allows you to:

- View a public list of GitHub users.
- See detailed information for each user in the list.

## Features

- **User List**: Displays a list of GitHub users retrieved from the API.
- **User Details**: Tap on a user to view detailed information such as login, node ID, followers, following, gists, and more.
- **Two-Column Layout**: Displayed user details are shown in a neat two-column grid for a better user experience.
- **MVVM**: Implemented with MVVM architecture guidelines.

## Installation

To get started, clone the repository and open it in Android Studio.

### Steps:

1. Clone this repository:
    ```bash
    git clone https://github.com/your-username/your-repo-name.git
    ```

2. Open the project in [Android Studio](https://developer.android.com/studio).

3. Build and run the application on an Android emulator or a physical device.

## Requirements

- Android Studio
- Minimum SDK: API 21 (Android 5.0 Lollipop)
- GitHub API access (public)

## API Used

This app interacts with the [GitHub Users API](https://docs.github.com/en/rest/users/users) to fetch public user information.

## UI Layout

- **Home Screen**: Displays a list of users.
- **User Details Screen**: Displays detailed information about a selected user, including login, node ID, followers, following, gists, and more, laid out in a two-column grid.

## Libraries Used

- **Jetpack Compose**: UI components for building the app interface.
- **Volley**: Network library for handling API requests.
- **Coil**: Image loading for Jetpack Compose (if used).

## Screenshots

![User List](screenshots/user_list.png)
![User Details](screenshots/user_details.png)

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -am 'Add feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Create a new Pull Request.
