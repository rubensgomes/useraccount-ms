# setup
This file describes the steps to set up this project.

## Initial steps to get barebone project setup

1. `mkdir <proj_name>` and then `gradle init`.
2. Copy `.gitignore` and `.gitattributes` from another project.
3. Copy and adjust `settings.gradle.kts` from another project.
4. Copy and adjust `build.gradle.kts` from another project
5. Delete `gradle/libs.versions.toml` from project
6. Rename the packages to `com.rubensgomes`
7. Run `./gradlew clean`, `./gradlew spotlessApply`, and `./gradlew build`
8. Fix any issus from above until 100% succeeds and no warnings.

## GitHub Repo Setup

### Import local repo to GitHub

```shell
git init -b main
git add .
git commit -m "initial commit" -a
gh repo create --homepage "https://github.com/rubensgomes" --public useraccount-ms
git remote add origin https://github.com/rubensgomes/useraccount-ms
git push -u origin main
```

### Create the very first 0.0.1 release

1. Go to the [repo](https://github.com/rubensgomes/useraccount-ms) and create  a `release` branch. Click on the `drop-down` to `View all branches` and createthe `release` branch from main.
2. Commit any local changes and push `git commit -m "initial release" -a; git push`
3. Run `./gradlew release`
