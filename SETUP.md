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

### Import Local Repo to GitHub

```shell
git init -b main
git add .
git commit -m "initial commit" -a
gh repo create --homepage "https://github.com/rubensgomes" --public useraccount-ms
git remote add origin https://github.com/rubensgomes/useraccount-ms
git push -u origin main
```
