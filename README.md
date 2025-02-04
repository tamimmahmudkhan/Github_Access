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
