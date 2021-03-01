## Release Checklist

0. Make sure to reference just public artifacts in `gradle.build`

1. Increment version in `README.md`, `gradle.build` and update [CHANGES.md](../CHANGES.md)

2. Do the release

```bash
export JB_HOME=" /d/projects/misc/jsonbuilder";

trim() { while read -r line; do echo "$line"; done; }
jb_version='v'$(grep '^version' ${JB_HOME}/build.gradle | cut -f2 -d' ' | tr -d "'" | trim)

echo "new version is $jb_version"


if [[ $jb_version == *"-SNAPSHOT" ]]; then
  echo "ERROR: Won't publish snapshot build $jb_version}!" 1>&2
  exit 1
fi

cd  $JB_HOME

git status
git commit -am "${jb_version} release"
#git diff --exit-code  || echo "There are uncomitted changes"

git tag "${jb_version}"

git push origin 
git push origin --tags


########################################################################
### Build and publish the binary release to maven-central

./gradlew install

# careful with this one!
# https://getstream.io/blog/publishing-libraries-to-mavencentral-2021/
# https://central.sonatype.org/pages/gradle.html
./gradlew publishReleasePublicationToSonatypeRepository
./gradlew closeAndReleaseRepository

## also see https://oss.sonatype.org/
```

3. Increment version to *-SNAPSHOT for next release cycle

