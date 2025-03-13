# Spotify API Java Project

This Java project interacts with the Spotify API to retrieve  
an artist's top tracks based on their name. The project uses HTTP requests to fetch data from Spotify.

## Prerequisites

**Before running this project, ensure you have the following installed:**
- Java 8 or later
- Maven (optional, for dependency management)
- A Spotify Developer account
- A registered Spotify application with `CLIENT_ID` and `CLIENT_SECRET`

## Setting Up Environment Variables

Before running the application, set the following environment variables:

### Windows (Command Prompt)
```sh
set SPOTIFY_CLIENT_ID=your_client_id
set SPOTIFY_CLIENT_SECRET=your_client_secret
```

## Running the Application

### Clone the repository:

```sh
git clone https://github.com/your-repo-name.git
cd your-repo-name
```

### Compile and run the Java program:

```sh
javac SpotifyApp.java
java SpotifyApp
```

### How It Works
- The application retrieves an access token using the Spotify API.  
- It searches for an artist by name and fetches their Spotify ID.  
- It retrieves and displays the artist's top tracks.  